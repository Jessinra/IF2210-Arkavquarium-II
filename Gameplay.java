import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends JPanel implements ActionListener, KeyListener, MouseListener {

    private static final long serialVersionUID = 1L; // dont know what is this, needed to be implemented

	private boolean play = true;
    private int win = 0;

    private Aquarium aquarium;
    private Timer timer;

    public Gameplay() {

        ImageCollection.init_image();
        aquarium = new Aquarium();

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        timer = new Timer(Constants.TIME_DELAY, this);
        timer.start();
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.drawImage(aquarium.get_image(),0,0,this);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        String money = "Money:  " + Aquarium.money;
        g.drawString(money, 20, 40);
        String egg = "Egg:   " + Aquarium.egg;
        g.drawString(egg, 1150, 40);

        // win lose state
        if (win == 1) {
            g.drawImage(ImageCollection.win, Constants.SCREEN_WIDTH/2-100, Constants.SCREEN_HEIGHT/2, this);
        } else if (win == -1) {
            g.drawImage(ImageCollection.lose, Constants.SCREEN_WIDTH/2-100, Constants.SCREEN_HEIGHT/2, this);
        }

        // iterate list guppy
        LinkedList<Guppy> guppyList = aquarium.get_list_guppy();
		for (int i = 1; i <= guppyList.getNBelmt(); i++) {

            Guppy currentGuppy = guppyList.get(i);
			g.drawImage(currentGuppy.get_image(), (int) currentGuppy.get_x(), (int) currentGuppy.get_y(), this);
        }

        // iterate list piranha
        LinkedList<Piranha> piranhaList = aquarium.get_list_piranha();
		for (int i = 1; i <= piranhaList.getNBelmt(); i++) {

            Piranha currentPiranha = piranhaList.get(i);
			g.drawImage(currentPiranha.get_image(), (int) currentPiranha.get_x(), (int) currentPiranha.get_y(), this);
        }

        // iterate list siput
        LinkedList<Siput> siputList = aquarium.get_list_siput();
		for (int i = 1; i <= siputList.getNBelmt(); i++) {

            Siput currentSiput = siputList.get(i);
			g.drawImage(currentSiput.get_image(), (int) currentSiput.get_x(), (int) currentSiput.get_y(), this);
        }

        // iterate list food
        LinkedList<Food> foodList = aquarium.get_list_food();
		for (int i = 1; i <= foodList.getNBelmt(); i++) {
            Food currentFood = foodList.get(i);
			g.drawImage(currentFood.get_image(), (int) currentFood.get_x(), (int) currentFood.get_y(), this);
        }

        // iterate list coin
        LinkedList<Coin> coinList = aquarium.get_list_coin();
		for (int i = 1; i <= coinList.getNBelmt(); i++) {

            Coin currentCoin = coinList.get(i);
			g.drawImage(currentCoin.get_image(), (int) currentCoin.get_x(), (int) currentCoin.get_y(), this);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        // check jumlah ikan untuk lose state
        if (aquarium.get_list_guppy().getNBelmt() == 0 && aquarium.get_list_piranha().getNBelmt() == 0 && Aquarium.money < Constants.GUPPY_PRICE) {
            play = false;
            win = -1;
        } else if (Aquarium.egg == 3) {
            play = false;
            win = 1;
        }

        if (play) {

            // iterate list of guppy
            for (int i = 1; i <= aquarium.get_list_guppy().getNBelmt(); i++) {
                // cek mati
                Guppy current_guppy = aquarium.get_list_guppy().get(i);
                if (current_guppy.get_hunger() < 0) {
                    aquarium.remove_guppy(current_guppy);
                    i--;
                } else {
                    // move
                    current_guppy.move(aquarium.get_list_food());
                    // cek drop coin
                    if (current_guppy.produce_coin()) {
                        
                        Coin c = new Coin(current_guppy.get_x(), current_guppy.get_y(), current_guppy.get_coin_value());
                        aquarium.add_coin(c);
                    }
                    // makan
                    current_guppy.eat(aquarium.get_list_food());
                    // mengurangi hunger
                    current_guppy.makeHunger();
                }
            }

            // iterasi list piranha
            for (int i = 1; i <= aquarium.get_list_piranha().getNBelmt(); i++) {
                Piranha current_piranha = aquarium.get_list_piranha().get(i);

                // cek mati
                if (current_piranha.get_hunger() < 0) {
                    aquarium.remove_piranha(current_piranha);
                    i--;
                } else {    // masih hidup
                    // move piranha
                    current_piranha.move(aquarium.get_list_guppy());
                    // cek untuk makan
                    int eaten_lv = current_piranha.eat(aquarium.get_list_guppy());

                    // check drop coin
                    if (eaten_lv > 0) {
                        int coin_val = current_piranha.get_coin_value();
                        Coin c = new Coin(current_piranha.get_x(), current_piranha.get_y(), coin_val);
                        aquarium.add_coin(c);
                    }

                    // mengurangi hunger
                    current_piranha.makeHunger();
                }
            }

            // iterasi list siput
            for (int i = 1; i <= aquarium.get_list_siput().getNBelmt(); i++) {
                Siput current_siput = aquarium.get_list_siput().get(i);
                // move siput
                current_siput.move(aquarium.get_list_coin());
                // get coin
                Aquarium.money += current_siput.take_coin(aquarium.get_list_coin());
            }

            // iterasi list food
            for (int i = 1; i <= aquarium.get_list_food().getNBelmt(); i++) {
                Food current_food = aquarium.get_list_food().get(i);

                // remove food that touch the bottom
                if (current_food.get_y() >= Constants.SCREEN_BOTTOM){
                    aquarium.remove_food(current_food);
                    i--;
                }

                // move food
                current_food.move();
            }

            // iterasi list coin
            for (int i = 1; i <= aquarium.get_list_coin().getNBelmt(); i++) {
                aquarium.get_list_coin().get(i).move();
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
            aquarium.buy_food();
        } else if (e.getKeyCode() == KeyEvent.VK_G) {        // buy guppy
            aquarium.buy_guppy();
        } else if (e.getKeyCode() == KeyEvent.VK_P) {      // buy piranha
            aquarium.buy_piranha();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {        // buy siput
            aquarium.buy_snail();
        } else if (e.getKeyCode() == KeyEvent.VK_E) {          // buy egg
            aquarium.buy_egg();
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

        int c_value = aquarium.click_coin(x, y);
        if (c_value > 0) {
            Aquarium.money += c_value;
        } else {
            aquarium.buy_food(x);
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
