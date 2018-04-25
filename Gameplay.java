import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel
        implements ActionListener, KeyListener, MouseListener {

  // dont know what is this, needed to be implemented
  private static final long serialVersionUID = 1L;

  private boolean play = true;
  private int win = 0;

  private Aquarium aquarium;
  private Timer timer;

  /**
   * default constructor.
   */
  public Gameplay() {

    ImageCollection.initImage();
    aquarium = new Aquarium();

    addMouseListener(this);
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);

    timer = new Timer(Constants.TIME_DELAY, this);
    timer.start();
  }

  /**
   * paint graphic on screen.
   *
   * @param g graphics
   */
  public void paint(Graphics g) {

    g.setColor(Color.BLACK);
    g.drawImage(aquarium.getImage(), 0, 0, this);

    g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
    String money = "Money:  " + Aquarium.money;
    g.drawString(money, 20, 40);
    String egg = "Egg:   " + Aquarium.egg;
    g.drawString(egg, 1150, 40);

    // win lose state
    if (win == 1) {
      g.drawImage(ImageCollection.win,
              Constants.SCREEN_WIDTH / 2 - 405,
              Constants.SCREEN_HEIGHT / 2 - 220,
              this);
    } else if (win == -1) {
      g.drawImage(ImageCollection.lose,
              Constants.SCREEN_WIDTH / 2 - 435,
              Constants.SCREEN_HEIGHT / 2 - 330,
              this);
    }

    // iterate list guppy
    LinkedList<Guppy> guppyList = aquarium.getListGuppy();
    for (int i = 1; i <= guppyList.getNBelmt(); i++) {

      Guppy currentGuppy = guppyList.get(i);
      g.drawImage(currentGuppy.getImage(),
              (int) currentGuppy.getX(),
              (int) currentGuppy.getY(),
              this);
    }

    // iterate list piranha
    LinkedList<Piranha> piranhaList = aquarium.getListPiranha();
    for (int i = 1; i <= piranhaList.getNBelmt(); i++) {

      Piranha currentPiranha = piranhaList.get(i);
      g.drawImage(currentPiranha.getImage(),
              (int) currentPiranha.getX(),
              (int) currentPiranha.getY(),
              this);
    }

    // iterate list siput
    LinkedList<Siput> siputList = aquarium.getListSiput();
    for (int i = 1; i <= siputList.getNBelmt(); i++) {

      Siput currentSiput = siputList.get(i);
      g.drawImage(currentSiput.getImage(),
              (int) currentSiput.getX(),
              (int) currentSiput.getY(),
              this);
    }

    // iterate list food
    LinkedList<Food> foodList = aquarium.getListFood();
    for (int i = 1; i <= foodList.getNBelmt(); i++) {
      Food currentFood = foodList.get(i);
      g.drawImage(currentFood.getImage(), (int) currentFood.getX(), (int) currentFood.getY(), this);
    }

    // iterate list coin
    LinkedList<Coin> coinList = aquarium.getListCoin();
    for (int i = 1; i <= coinList.getNBelmt(); i++) {

      Coin currentCoin = coinList.get(i);
      g.drawImage(currentCoin.getImage(), (int) currentCoin.getX(), (int) currentCoin.getY(), this);
    }

    g.dispose();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timer.start();
    // check jumlah ikan untuk lose state
    if (aquarium.getListGuppy().getNBelmt() == 0
            && aquarium.getListPiranha().getNBelmt() == 0
            && Aquarium.money < Constants.GUPPY_PRICE) {
      play = false;
      win = -1;
    } else if (Aquarium.egg == 3) {
      play = false;
      win = 1;
    }

    if (play) {

      // iterate list of guppy
      for (int i = 1; i <= aquarium.getListGuppy().getNBelmt(); i++) {
        // cek mati
        Guppy currentGuppy = aquarium.getListGuppy().get(i);
        if (currentGuppy.getHunger() < 0) {
          aquarium.removeGuppy(currentGuppy);
          i--;
        } else {
          // move
          currentGuppy.move(aquarium.getListFood());
          // cek drop coin
          if (currentGuppy.produceCoin()) {

            Coin c = new Coin(currentGuppy.getX(),
                    currentGuppy.getY(),
                    currentGuppy.getCoinValue());
            aquarium.addCoin(c);
          }
          // makan
          currentGuppy.eat(aquarium.getListFood());
          // mengurangi hunger
          currentGuppy.makeHunger();
        }
      }

      // iterasi list piranha
      for (int i = 1; i <= aquarium.getListPiranha().getNBelmt(); i++) {
        Piranha currentPiranha = aquarium.getListPiranha().get(i);

        // cek mati
        if (currentPiranha.getHunger() < 0) {
          aquarium.removePiranha(currentPiranha);
          i--;
        } else {    // masih hidup
          // move piranha
          currentPiranha.move(aquarium.getListGuppy());
          // cek untuk makan
          int eatenLv = currentPiranha.eat(aquarium.getListGuppy());

          // check drop coin
          if (eatenLv > 0) {
            int coinVal = currentPiranha.getCoinValue();
            Coin c = new Coin(currentPiranha.getX(), currentPiranha.getY(), coinVal);
            aquarium.addCoin(c);
          }

          // mengurangi hunger
          currentPiranha.makeHunger();
        }
      }

      // iterasi list siput
      for (int i = 1; i <= aquarium.getListSiput().getNBelmt(); i++) {
        Siput currentSiput = aquarium.getListSiput().get(i);
        // move siput
        currentSiput.move(aquarium.getListCoin());
        // get coin
        Aquarium.money += currentSiput.takeCoin(aquarium.getListCoin());
      }

      // iterasi list food
      for (int i = 1; i <= aquarium.getListFood().getNBelmt(); i++) {
        Food currentFood = aquarium.getListFood().get(i);

        // remove food that touch the bottom
        if (currentFood.getY() >= Constants.SCREEN_BOTTOM) {
          aquarium.removeFood(currentFood);
          i--;
        }

        // move food
        currentFood.move();
      }

      // iterasi list coin
      for (int i = 1; i <= aquarium.getListCoin().getNBelmt(); i++) {
        aquarium.getListCoin().get(i).move();
      }
    }
    repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_F) {                // buy food
      aquarium.buyFood();
    } else if (e.getKeyCode() == KeyEvent.VK_G) {        // buy guppy
      aquarium.buyGuppy();
    } else if (e.getKeyCode() == KeyEvent.VK_P) {      // buy piranha
      aquarium.buyPiranha();
    } else if (e.getKeyCode() == KeyEvent.VK_S) {        // buy siput
      aquarium.buySnail();
    } else if (e.getKeyCode() == KeyEvent.VK_E) {          // buy egg
      aquarium.buyEgg();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }


  @Override
  public void mouseClicked(MouseEvent e) {
    PointerInfo a = MouseInfo.getPointerInfo();
    Point b = a.getLocation();
    int x = (int) b.getX();
    int y = (int) b.getY();

    int cvalue = aquarium.clickCoin(x, y);
    if (cvalue > 0) {
      Aquarium.money += cvalue;
    } else {
      aquarium.buyFood(x);
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
