import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class ImageCollection {

    public static BufferedImage aquarium;
    public static BufferedImage coin;
    public static BufferedImage food;
.
    public static BufferedImage guppy_01_L;
    public static BufferedImage guppy_01_R;
    public static BufferedImage guppy_01_L_H;
    public static BufferedImage guppy_01_R_H;

    public static BufferedImage guppy_02_L;
    public static BufferedImage guppy_02_R;
    public static BufferedImage guppy_02_L_H;
    public static BufferedImage guppy_02_R_H;

    public static BufferedImage guppy_03_L;
    public static BufferedImage guppy_03_R;
    public static BufferedImage guppy_03_L_H;
    public static BufferedImage guppy_03_R_H;

    public static BufferedImage piranha_L;
    public static BufferedImage piranha_R;
    public static BufferedImage piranha_L_H;
    public static BufferedImage piranha_R_H;

    public static BufferedImage siput_left;
    public static BufferedImage siput_right;

    public static BufferedImage main_menu;
    public static BufferedImage win;
    public static BufferedImage lose;
    public static BufferedImage credit;


    // pathNAME SECTION

    private static final String path_aquarium = "img/Aquarium2.jpg";
    private static final String path_coin = "img/coin.png";
    private static final String path_food = "img/food.png";

    private static final String path_guppy_01_left = "img/guppy_01.png";
    private static final String path_guppy_02_left = "img/guppy_02.png";
    private static final String path_guppy_03_left = "img/guppy_03.png";

    private static final String path_guppy_01_right = "img/guppy_01_r.png";
    private static final String path_guppy_02_right = "img/guppy_02_r.png";
    private static final String path_guppy_03_right = "img/guppy_03_r.png";

    private static final String path_guppy_01_left_hungry = "img/guppy_01_h.png";
    private static final String path_guppy_02_left_hungry = "img/guppy_02_h.png";
    private static final String path_guppy_03_left_hungry = "img/guppy_03_h.png";

    private static final String path_guppy_01_right_hungry = "img/guppy_01_r_h.png";
    private static final String path_guppy_02_right_hungry = "img/guppy_02_r_h.png";
    private static final String path_guppy_03_right_hungry = "img/guppy_03_r_h.png";

    private static final String path_piranha_left = "img/piranha.png";
    private static final String path_piranha_right = "img/piranha_r.png";
    private static final String path_piranha_left_hungry = "img/piranha_h.png";
    private static final String path_piranha_right_hungry = "img/piranha_r_h.png";

    private static final String path_siput_left = "img/snail.png";
    private static final String path_siput_right = "img/snail_r.png";

    private static final String path_main_menu = "img/main.jpg";
    private static final String path_win = "img/youwin.png";
    private static final String path_lose = "img/gameover.png";
    private static final String path_credit = "img/credit.jpeg";

    // path SECTION

    private static final File file_aquarium = new File(ImageCollection.path_aquarium);
    private static final File file_coin = new File(ImageCollection.path_coin);
    private static final File file_food = new File(ImageCollection.path_food);

    private static final File file_guppy_01_L = new File(ImageCollection.path_guppy_01_left);
    private static final File file_guppy_01_R = new File(ImageCollection.path_guppy_01_right);
    private static final File file_guppy_01_L_H = new File(ImageCollection.path_guppy_01_left_hungry);
    private static final File file_guppy_01_R_H = new File(ImageCollection.path_guppy_01_right_hungry);

    private static final File file_guppy_02_L = new File(ImageCollection.path_guppy_02_left);
    private static final File file_guppy_02_R = new File(ImageCollection.path_guppy_02_right);
    private static final File file_guppy_02_L_H = new File(ImageCollection.path_guppy_02_left_hungry);
    private static final File file_guppy_02_R_H = new File(ImageCollection.path_guppy_02_right_hungry);

    private static final File file_guppy_03_L = new File(ImageCollection.path_guppy_03_left);
    private static final File file_guppy_03_R = new File(ImageCollection.path_guppy_03_right);
    private static final File file_guppy_03_L_H = new File(ImageCollection.path_guppy_03_left_hungry);
    private static final File file_guppy_03_R_H = new File(ImageCollection.path_guppy_03_right_hungry);

    private static final File file_piranha_L = new File(ImageCollection.path_piranha_left);
    private static final File file_piranha_R = new File(ImageCollection.path_piranha_right);
    private static final File file_piranha_L_H = new File(ImageCollection.path_piranha_left_hungry);
    private static final File file_piranha_R_H = new File(ImageCollection.path_piranha_right_hungry);

    private static final File file_siput_left = new File(ImageCollection.path_siput_left);
    private static final File file_siput_right = new File(ImageCollection.path_siput_right);

    private static final File file_main_menu = new File(ImageCollection.path_main_menu);
    private static final File file_win = new File(ImageCollection.path_win);
    private static final File file_lose = new File(ImageCollection.path_lose);
    private static final File file_credit = new File(ImageCollection.path_credit);


    private ImageCollection() {
        // restrict instantiation
    }

    public static void init_image() {

        try {

            ImageCollection.aquarium = ImageIO.read(ImageCollection.file_aquarium);
            ImageCollection.coin = ImageIO.read(ImageCollection.file_coin);
            ImageCollection.food = ImageIO.read(ImageCollection.file_food);

            ImageCollection.guppy_01_L = ImageIO.read(ImageCollection.file_guppy_01_L);
            ImageCollection.guppy_01_R = ImageIO.read(ImageCollection.file_guppy_01_R);
            ImageCollection.guppy_01_L_H = ImageIO.read(ImageCollection.file_guppy_01_L_H);
            ImageCollection.guppy_01_R_H = ImageIO.read(ImageCollection.file_guppy_01_R_H);

            ImageCollection.guppy_02_L = ImageIO.read(ImageCollection.file_guppy_02_L);
            ImageCollection.guppy_02_R = ImageIO.read(ImageCollection.file_guppy_02_R);
            ImageCollection.guppy_02_L_H = ImageIO.read(ImageCollection.file_guppy_02_L_H);
            ImageCollection.guppy_02_R_H = ImageIO.read(ImageCollection.file_guppy_02_R_H);

            ImageCollection.guppy_03_L = ImageIO.read(ImageCollection.file_guppy_03_L);
            ImageCollection.guppy_03_R = ImageIO.read(ImageCollection.file_guppy_03_R);
            ImageCollection.guppy_03_L_H = ImageIO.read(ImageCollection.file_guppy_03_L_H);
            ImageCollection.guppy_03_R_H = ImageIO.read(ImageCollection.file_guppy_03_R_H);

            ImageCollection.piranha_L = ImageIO.read(ImageCollection.file_piranha_L);
            ImageCollection.piranha_R = ImageIO.read(ImageCollection.file_piranha_R);
            ImageCollection.piranha_L_H = ImageIO.read(ImageCollection.file_piranha_L_H);
            ImageCollection.piranha_R_H = ImageIO.read(ImageCollection.file_piranha_R_H);

            ImageCollection.siput_left = ImageIO.read(ImageCollection.file_siput_left);
            ImageCollection.siput_right = ImageIO.read(ImageCollection.file_siput_right);

            ImageCollection.main_menu = ImageIO.read(ImageCollection.file_main_menu);
            ImageCollection.win = ImageIO.read(ImageCollection.file_win);
            ImageCollection.lose = ImageIO.read(ImageCollection.file_lose);
            ImageCollection.credit = ImageIO.read(ImageCollection.file_credit);


        } catch (IOException e) {
            System.out.println("Error occured when loading image");
        }


    }

};

