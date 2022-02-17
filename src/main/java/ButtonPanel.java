import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.security.Key;

public class ButtonPanel extends JPanel {

    private JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    public ButtonPanel() {
        this.leftButton = createButton("Disable middle button", "right.gif", "DISABLE", KeyEvent.VK_D);
        this.leftButton.setToolTipText("Ovaj dugmic disable srednji dugmic...");
        this.leftButton.setHorizontalTextPosition(AbstractButton.LEADING);
        this.leftButton.setVerticalTextPosition(AbstractButton.CENTER);

        this.middleButton = createButton("Middle VICTIM", "middle.gif", "", KeyEvent.VK_S);
        this.middleButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        this.middleButton.setHorizontalTextPosition(AbstractButton.CENTER);

        this.rightButton = createButton("Enable middle button", "left.gif", "ENABLE", KeyEvent.VK_E);


        ActionListener buttonListener = (ActionEvent e) -> middleButtonAction(e);
        this.leftButton.addActionListener(buttonListener);
        this.rightButton.addActionListener(buttonListener);
        this.rightButton.setToolTipText("Ovaj dugmic enable srednji dugmic");


        add(leftButton);
        add(middleButton);
        add(rightButton);

    }

    private JButton createButton(String labela, String iconName, String actionCommand, int mnemonic) {
        ImageIcon imageIcon = createImageIcon(iconName);
        JButton button = new JButton(labela, imageIcon);
        button.setActionCommand(actionCommand);
        button.setMnemonic(mnemonic);
return button;

    }

    private ImageIcon createImageIcon(String iconName) {
        URL imageAdress = ButtonPanel.class.getResource(iconName);
        System.out.println(imageAdress);
        if (imageAdress != null) {
            ImageIcon imageIcon = new ImageIcon(imageAdress);
            return imageIcon;
        } else {
            System.err.println("Ne mogu ocitati sliku...");
            return  null;
        }

    }

    private void middleButtonAction(ActionEvent e) {
        if ("ENABLE".equals(e.getActionCommand())) {
            middleButton.setEnabled(true);
        } else {
            middleButton.setEnabled(false);
        }
        System.out.println("Izvrsava se blok koda actionPerform metode...");
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("ENABLE".equals(e.getActionCommand())) {
                middleButton.setEnabled(true);
            } else {
                middleButton.setEnabled(false);
            }
            System.out.println("Izvrsava se blok koda actionPerform metode...");

        }
    }

}
