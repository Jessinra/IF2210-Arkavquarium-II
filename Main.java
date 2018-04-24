import javax.swing.JFrame;

public class Main {
    /**
     * main program.
     * @param args sys args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Gameplay gameplay = new Gameplay();
        frame.setBounds(10, 10, 1280, 800);
        frame.setTitle("Arkavquarium");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
    }
}