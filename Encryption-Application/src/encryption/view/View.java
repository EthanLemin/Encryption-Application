package encryption.view;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class View extends JFrame {

    private final EncryptionGUI encryptionGUI;

    public View() {
        this.encryptionGUI = new EncryptionGUI();
        JPanel content = encryptionGUI.getMainPanel();

        this.setContentPane(content);
        this.pack();
        this.setTitle("Encryption");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
    }

    public EncryptionGUI form() {return encryptionGUI;}

}
