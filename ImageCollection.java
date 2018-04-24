import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class ImageCollection {

  public static BufferedImage aquarium;
  public static BufferedImage coin;
  public static BufferedImage food;

  public static BufferedImage guppy01L;
  public static BufferedImage guppy01R;
  public static BufferedImage guppy01LH;
  public static BufferedImage guppy01RH;

  public static BufferedImage guppy02L;
  public static BufferedImage guppy02R;
  public static BufferedImage guppy02LH;
  public static BufferedImage guppy02RH;

  public static BufferedImage guppy03L;
  public static BufferedImage guppy03R;
  public static BufferedImage guppy03LH;
  public static BufferedImage guppy03RH;

  public static BufferedImage piranhaL;
  public static BufferedImage piranhaR;
  public static BufferedImage piranhaLH;
  public static BufferedImage piranhaRH;

  public static BufferedImage siputL;
  public static BufferedImage siputR;

  public static BufferedImage mainMenu;
  public static BufferedImage win;
  public static BufferedImage lose;
  public static BufferedImage credit;


  // pathNAME SECTION

  private static final String pathAquarium = "img/Aquarium2.jpg";
  private static final String pathCoin = "img/coin.png";
  private static final String pathFood = "img/food.png";

  private static final String pathGuppy01L = "img/guppy_01.png";
  private static final String pathGuppy02L = "img/guppy_02.png";
  private static final String pathGuppy03L = "img/guppy_03.png";

  private static final String pathGuppy01R = "img/guppy_01_r.png";
  private static final String pathGuppy02R = "img/guppy_02_r.png";
  private static final String pathGuppy03R = "img/guppy_03_r.png";

  private static final String pathGuppy01LH = "img/guppy_01_h.png";
  private static final String pathGuppy02LH = "img/guppy_02_h.png";
  private static final String pathGuppy03LH = "img/guppy_03_h.png";

  private static final String pathGuppy01RH = "img/guppy_01_r_h.png";
  private static final String pathGuppy02RH = "img/guppy_02_r_h.png";
  private static final String pathGuppy03RH = "img/guppy_03_r_h.png";

  private static final String pathPiranhaL = "img/piranha.png";
  private static final String pathPiranhaR = "img/piranha_r.png";
  private static final String pathPiranhaLH = "img/piranha_h.png";
  private static final String pathPiranhaRH = "img/piranha_r_h.png";

  private static final String pathSiputL = "img/snail.png";
  private static final String pathSiputR = "img/snail_r.png";

  private static final String pathMainMenu = "img/main.jpg";
  private static final String pathWin = "img/youwin.png";
  private static final String pathLose = "img/gameover.png";
  private static final String pathCredit = "img/credit.jpeg";

  // path SECTION

  private static final File fileAquarium = new File(ImageCollection.pathAquarium);
  private static final File fileCoin = new File(ImageCollection.pathCoin);
  private static final File fileFood = new File(ImageCollection.pathFood);

  private static final File fileGuppy01L = new File(ImageCollection.pathGuppy01L);
  private static final File fileGuppy01R = new File(ImageCollection.pathGuppy01R);
  private static final File fileGuppy01LH = new File(ImageCollection.pathGuppy01LH);
  private static final File fileGuppy01RH = new File(ImageCollection.pathGuppy01RH);

  private static final File fileGuppy02L = new File(ImageCollection.pathGuppy02L);
  private static final File fileGuppy02R = new File(ImageCollection.pathGuppy02R);
  private static final File fileGuppy02LH = new File(ImageCollection.pathGuppy02LH);
  private static final File fileGuppy02RH = new File(ImageCollection.pathGuppy02RH);

  private static final File fileGuppy03L = new File(ImageCollection.pathGuppy03L);
  private static final File fileGuppy03R = new File(ImageCollection.pathGuppy03R);
  private static final File fileGuppy03LH = new File(ImageCollection.pathGuppy03LH);
  private static final File fileGuppy03RH = new File(ImageCollection.pathGuppy03RH);

  private static final File filePiranhaL = new File(ImageCollection.pathPiranhaL);
  private static final File filePiranhaR = new File(ImageCollection.pathPiranhaR);
  private static final File filePiranhaLH = new File(ImageCollection.pathPiranhaLH);
  private static final File filePiranhaRh = new File(ImageCollection.pathPiranhaRH);

  private static final File fileSiputL = new File(ImageCollection.pathSiputL);
  private static final File fileSiputR = new File(ImageCollection.pathSiputR);

  private static final File fileMainMenu = new File(ImageCollection.pathMainMenu);
  private static final File fileWin = new File(ImageCollection.pathWin);
  private static final File fileLose = new File(ImageCollection.pathLose);
  private static final File fileCredit = new File(ImageCollection.pathCredit);


  private ImageCollection() {
    // restrict instantiation
  }

  /**
   * to initialize image.
   */
  public static void initImage() {

    try {

      ImageCollection.aquarium = ImageIO.read(ImageCollection.fileAquarium);
      ImageCollection.coin = ImageIO.read(ImageCollection.fileCoin);
      ImageCollection.food = ImageIO.read(ImageCollection.fileFood);

      ImageCollection.guppy01L = ImageIO.read(ImageCollection.fileGuppy01L);
      ImageCollection.guppy01R = ImageIO.read(ImageCollection.fileGuppy01R);
      ImageCollection.guppy01LH = ImageIO.read(ImageCollection.fileGuppy01LH);
      ImageCollection.guppy01RH = ImageIO.read(ImageCollection.fileGuppy01RH);

      ImageCollection.guppy02L = ImageIO.read(ImageCollection.fileGuppy02L);
      ImageCollection.guppy02R = ImageIO.read(ImageCollection.fileGuppy02R);
      ImageCollection.guppy02LH = ImageIO.read(ImageCollection.fileGuppy02LH);
      ImageCollection.guppy02RH = ImageIO.read(ImageCollection.fileGuppy02RH);

      ImageCollection.guppy03L = ImageIO.read(ImageCollection.fileGuppy03L);
      ImageCollection.guppy03R = ImageIO.read(ImageCollection.fileGuppy03R);
      ImageCollection.guppy03LH = ImageIO.read(ImageCollection.fileGuppy03LH);
      ImageCollection.guppy03RH = ImageIO.read(ImageCollection.fileGuppy03RH);

      ImageCollection.piranhaL = ImageIO.read(ImageCollection.filePiranhaL);
      ImageCollection.piranhaR = ImageIO.read(ImageCollection.filePiranhaR);
      ImageCollection.piranhaLH = ImageIO.read(ImageCollection.filePiranhaLH);
      ImageCollection.piranhaRH = ImageIO.read(ImageCollection.filePiranhaRh);

      ImageCollection.siputL = ImageIO.read(ImageCollection.fileSiputL);
      ImageCollection.siputR = ImageIO.read(ImageCollection.fileSiputR);

      ImageCollection.mainMenu = ImageIO.read(ImageCollection.fileMainMenu);
      ImageCollection.win = ImageIO.read(ImageCollection.fileWin);
      ImageCollection.lose = ImageIO.read(ImageCollection.fileLose);
      ImageCollection.credit = ImageIO.read(ImageCollection.fileCredit);


    } catch (IOException e) {
      System.out.println("Error occured when loading image");
    }


  }

}

