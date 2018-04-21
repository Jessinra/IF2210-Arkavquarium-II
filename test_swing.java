import java.awt.Dimension;
import javax.swing.*;

public class test_swing {

  public static void main(String args[]) {

    /** Create main window (this is on main prog)
     * 
     */
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)); // wajib , set window size
    frame.setResizable(false);

    /**
     * Create main frame , enable absolute positioning (this is for aquarium)
     */
    JPanel panel = (JPanel) frame.getContentPane();
    panel.setLayout(null);


    /** sample of text label */
    JLabel label = new JLabel("99999999999999999999999999999");
    Dimension size = label.getPreferredSize(); // set size
    label.setBounds(100, 100, size.width, size.height); // draw 
    panel.add(label); // add to <aquarium>


    /** sample of text label */
    JLabel label1 = new JLabel("aasdfasdfasdfadfasdfadfasdfadfa");
    panel.add(label1);
    Dimension size1 = label1.getPreferredSize();
    label1.setBounds(110, 100, size1.width, size1.height);

    /** sample of image label */
    String image_link = Constants.FILE_piranha_left;
    JLabel label_pict = new JLabel();
    panel.add(label_pict);
    label_pict.setIcon(new ImageIcon(image_link));
    
    /** sample of CHANGING IMAGE POSISITON */
    size = label_pict.getPreferredSize();
    label_pict.setBounds(100 - size.width/2, 100 - size.height/2, size.width, size.height); // draw
    label_pict.setBounds(350 - size.width/2, 350 - size.height/2, size.width, size.height); // draw << only this will be drawn
    

    /** example of setting file and image (CHANGING IMAGE ONLY: for change direction / hungry etc)*/ 
    image_link = Constants.FILE_guppy_01_left_hungry;
    label_pict.setIcon(new ImageIcon(image_link));


    /** example of creating object <panel is aquarium> */
    Food dummy_food = new Food();
    panel.add(dummy_food.get_label());
    
    Food dummy_food1 = new Food();
    panel.add(dummy_food1.get_label());

    Food dummy_food2 = new Food();
    panel.add(dummy_food2.get_label());

    /** (at main) compulsory */
    frame.pack();
    frame.setVisible(true);


  }
}

