package encryption.view;

import javax.swing.*;
import java.awt.*;

public class EncryptionGUI {
    private JPanel mainPanel;
    private JTextField fileLocationTextField;
    private JButton fileLocationButton;
    private JLabel fileLocationLabel;
    private JTextArea encyptionTextArea;
    private JLabel textToEncryptLabel;
    private JComboBox typeOfEncryptionComboBox;
    private JLabel typeOfEncryptionLabel;
    private JComboBox levelOfEncryptionComboBox;
    private JLabel levelOfEncryptionLabel;
    private JButton executeButton;
    private JTextArea outputTextArea;
    private JLabel outputLabel;


    public JPanel getMainPanel() {return mainPanel;}
    public JButton getExecuteButton() {return executeButton;}
    public JButton getFileLocationButton() {return fileLocationButton;}
    public JComboBox getLevelOfEncryptionComboBox() {return levelOfEncryptionComboBox;}
    public JComboBox getTypeOfEncryptionComboBox() {return typeOfEncryptionComboBox;}
    public JTextArea getEncyptionTextArea() {return encyptionTextArea;}
    public JTextField getFileLocationTextField() {return fileLocationTextField;}
    public JTextArea getOutputTextArea() {return outputTextArea;}

    private void createUIComponents() {
        fileLocationTextField = new JTextField();
        fileLocationTextField.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        fileLocationTextField.setFont(Font.getFont("JetBrains Mono"));
        fileLocationTextField.setSelectedTextColor(Color.WHITE);

        fileLocationButton = new JButton();
        fileLocationButton.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        ImageIcon ii = new ImageIcon("icons/directory.gif");
        fileLocationButton.setIcon(ii);

        executeButton = new JButton();
        executeButton.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        executeButton.setBackground(new Color(93, 93, 93));

        typeOfEncryptionComboBox = new JComboBox<>();
        typeOfEncryptionComboBox.setBorder(null);
        typeOfEncryptionComboBox.setFont(Font.getFont("JetBrains Mono"));
        typeOfEncryptionComboBox.setBackground(new Color(93, 93, 93));

        levelOfEncryptionComboBox = new JComboBox<>();
        levelOfEncryptionComboBox.setBorder(null);
        levelOfEncryptionComboBox.setFont(Font.getFont("JetBrains Mono"));
        levelOfEncryptionComboBox.setBackground(new Color(93, 93, 93));

        encyptionTextArea = new JTextArea();
        encyptionTextArea.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        encyptionTextArea.setFont(Font.getFont("JetBrains Mono"));
        encyptionTextArea.setSelectedTextColor(Color.WHITE);
        encyptionTextArea.setBackground(new Color(93, 93, 93));

        outputTextArea = new JTextArea();
        outputTextArea.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        outputTextArea.setFont(Font.getFont("JetBrains Mono"));
        outputTextArea.setSelectedTextColor(Color.WHITE);
        outputTextArea.setBackground(new Color(93, 93, 93));
    }
}
