import javax.swing.*;

public class ButtonDemo {


    public static void main(String[] args) {

        Runnable runnable = ButtonDemo::createAndShowGUI;
        SwingUtilities.invokeLater(runnable);

    }

    private static void createAndShowGUI () {

        JFrame frame = new JFrame("Demonstracija upotrebe dugmica");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        ButtonPanel buttonPanel = new ButtonPanel();
        frame.setContentPane(buttonPanel);
        frame.pack();

        frame.setVisible(true);


    }
}
