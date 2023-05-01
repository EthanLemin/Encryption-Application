package encryption.controller;

import encryption.model.*;
import encryption.view.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Controller {

    private IEncryption model;
    private View view;

    public Controller(IEncryption model, View view) {
        this.model = model;
        this.view = view;
        EncryptionGUI viewForm = view.form();

        // ActionListener for File Button
        viewForm.getFileLocationButton().addActionListener(x -> {
            // Create objects for popup
            JFrame popupFrame = new JFrame();
            JPanel popupPanel = new JPanel();
            JFileChooser fileChooser = new JFileChooser();

            // Looks for selected file
            fileChooser.setCurrentDirectory(fileChooser.getFileSystemView().getHomeDirectory());
            int response = fileChooser.showOpenDialog(null);

            // File chooser instructions
            fileChooser.setBackground(new Color(60, 63, 65));
            fileChooser.setForeground(new Color(60, 63, 65));

            // Adds filechooser to panel, panel to frame
            popupPanel.add(fileChooser);
            popupFrame.add(popupPanel);

            // Default frame instructions
            popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            popupFrame.setSize(500, 375);
            popupFrame.setLocationRelativeTo(null);
            popupFrame.setVisible(true);

            // If file is selected, stores fileName and path. Closes window
            if (response == JFileChooser.APPROVE_OPTION) {
                File filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());
                viewForm.getFileLocationTextField().setText(String.valueOf(filePath));
                popupFrame.dispose();
            } else {
                popupFrame.dispose();
            }
        });

        // ActionListener for Execute button
        viewForm.getExecuteButton().addActionListener(x -> {
            boolean allFilled = true;
            File filePath = null;

            // Gets file location if supplied
            if (!viewForm.getFileLocationTextField().getText().isBlank()) {
                filePath = new File(viewForm.getFileLocationTextField().getText());
            }

            // Prints error if text field is blank
            if (viewForm.getEncyptionTextArea().getText().isBlank()) {
                JOptionPane.showMessageDialog(view, "No Text to Encrypt...");
                allFilled = false;
            }

            // If no errors, runs hashing
            if (allFilled) {
                // Variables
                String type = "";
                ArrayList<String> unhashed = new ArrayList<>();
                ArrayList<String> hashed = new ArrayList<>();
                int selectedType = viewForm.getTypeOfEncryptionComboBox().getSelectedIndex();
                int selectedLevel = viewForm.getLevelOfEncryptionComboBox().getSelectedIndex();

                // Changes index to string so it's readable for hashing method
                switch (selectedType) {
                    case 0:
                        type = "MD5";
                        break;
                    case 1:
                        type = "SHA-1";
                        break;
                    case 2:
                        type = "SHA-224";
                        break;
                    case 3:
                        type = "SHA-256";
                        break;
                    case 4:
                        type = "SHA-384";
                        break;
                    case 5:
                        type = "SHA-512";
                        break;
                }

                // Adds each line of text from field to an array list
                for (String line : viewForm.getEncyptionTextArea().getText().split("\\n")) {
                    unhashed.add(line);
                }

                // Hashes each line of unhashed array
                for (int i = 0; i < unhashed.size(); i++) {
                    hashed.add(model.hashing(type, unhashed.get(i), selectedLevel + 1));
                }

                // If there is a file path, prints to file
                if (filePath != null) {
                    try (PrintWriter out = new PrintWriter(filePath)) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < hashed.size() && i < unhashed.size(); i++) {
                            sb.append("\n");
                            sb.append(String.format("Unhashed - %s %nHashed - %s%n", unhashed.get(i), hashed.get(i)));
                        }
                        out.printf("%s Encryption - Level %d: %n%s", type, selectedLevel + 1, sb);
                        JOptionPane.showMessageDialog(view, "Save Complete.");
                    } catch (FileNotFoundException fne) {
                        JOptionPane.showMessageDialog(view, "Error When Saving...");
                    }
                }

                // Clears output text field
                if (!viewForm.getOutputTextArea().getText().isBlank()) {
                    viewForm.getOutputTextArea().setText("");
                }

                // Prints to output text field
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < hashed.size() && i < unhashed.size(); i++) {
                    sb.append(String.format("%s Encryption - Level %d: %nUnhashed - %s %nHashed - %s%n%n",
                            type, selectedLevel + 1, unhashed.get(i), hashed.get(i)));
                }
                viewForm.getOutputTextArea().setText(sb.toString());
            }
        });
    }
}
