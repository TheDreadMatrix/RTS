import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class TexturePackerTool extends JFrame {

    private final JTextField inputField = new JTextField();
    private final JTextField outputField = new JTextField();
    private final JTextField nameField = new JTextField("atlas");

    private final JSpinner maxWidth = new JSpinner(new SpinnerNumberModel(
            2048, 256, 8192, 256));

    private final JSpinner maxHeight = new JSpinner(new SpinnerNumberModel(
            2048, 256, 8192, 256));

    private final JSpinner paddingX = new JSpinner(new SpinnerNumberModel(
            2, 0, 64, 1));

    private final JSpinner paddingY = new JSpinner(new SpinnerNumberModel(
            2, 0, 64, 1));

    private final JCheckBox duplicatePadding = new JCheckBox("Duplicate padding", true);

    private final JComboBox<String> filter = new JComboBox<>(new String[] {
            "Nearest",
            "Linear"
    });

    public TexturePackerTool() {

        setTitle("Texture Packer");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new GridBagLayout());

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15));

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 0;

        // INPUT
        addRow(
                mainPanel,
                c,
                0,
                "Input:",
                inputField,
                "Choose...");

        // OUTPUT
        addRow(
                mainPanel,
                c,
                1,
                "Output:",
                outputField,
                "Choose...");

        // NAME
        addRow(
                mainPanel,
                c,
                2,
                "Atlas name:",
                nameField,
                null);

        // MAX WIDTH
        addComponent(
                mainPanel,
                c,
                3,
                "Max width:",
                maxWidth);

        // MAX HEIGHT
        addComponent(
                mainPanel,
                c,
                4,
                "Max height:",
                maxHeight);

        // PADDING X
        addComponent(
                mainPanel,
                c,
                5,
                "Padding X:",
                paddingX);

        // PADDING Y
        addComponent(
                mainPanel,
                c,
                6,
                "Padding Y:",
                paddingY);

        // FILTER
        addComponent(
                mainPanel,
                c,
                7,
                "Filter:",
                filter);

        // DUPLICATE PADDING
        c.gridx = 1;
        c.gridy = 8;
        c.gridwidth = 2;

        mainPanel.add(
                duplicatePadding,
                c);

        // PACK BUTTON
        JButton packButton = new JButton("PACK TEXTURES");

        packButton.addActionListener(
                e -> packTextures());

        c.gridx = 1;
        c.gridy = 9;
        c.gridwidth = 2;
        c.weightx = 1;

        mainPanel.add(
                packButton,
                c);

        add(
                mainPanel,
                BorderLayout.CENTER);
    }

    private void addRow(
            JPanel panel,
            GridBagConstraints c,
            int row,
            String label,
            JTextField field,
            String buttonText) {

        c.gridx = 0;
        c.gridy = row;
        c.gridwidth = 1;
        c.weightx = 0;

        panel.add(
                new JLabel(label),
                c);

        c.gridx = 1;
        c.weightx = 1;

        panel.add(
                field,
                c);

        if (buttonText != null) {

            JButton button = new JButton(buttonText);

            c.gridx = 2;
            c.weightx = 0;

            panel.add(
                    button,
                    c);

            button.addActionListener(
                    e -> chooseFolder(field));
        }
    }

    private void addComponent(
            JPanel panel,
            GridBagConstraints c,
            int row,
            String label,
            java.awt.Component component) {

        c.gridx = 0;
        c.gridy = row;
        c.gridwidth = 1;
        c.weightx = 0;

        panel.add(
                new JLabel(label),
                c);

        c.gridx = 1;
        c.gridwidth = 2;
        c.weightx = 1;

        panel.add(
                component,
                c);
    }

    private void chooseFolder(
            JTextField field) {

        JFileChooser chooser = new JFileChooser();

        chooser.setDialogTitle(
                "Choose folder");

        chooser.setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            File folder = chooser.getSelectedFile();

            field.setText(
                    folder.getAbsolutePath());
        }
    }

    private void packTextures() {

        String input = inputField.getText().trim();

        String output = outputField.getText().trim();

        String atlasName = nameField.getText().trim();

        if (input.isEmpty()
                || output.isEmpty()
                || atlasName.isEmpty()) {

            showError(
                    "Input, Output и Atlas name обязательны.");

            return;
        }

        File inputFolder = new File(input);

        if (!inputFolder.isDirectory()) {

            showError(
                    "Input папка не существует.");

            return;
        }

        File outputFolder = new File(output);

        if (!outputFolder.exists()) {

            if (!outputFolder.mkdirs()) {

                showError(
                        "Не удалось создать Output папку.");

                return;
            }
        }

        try {

            TexturePacker.Settings settings = new TexturePacker.Settings();

            // =========================
            // FILTER
            // =========================

            if (filter.getSelectedItem()
                    .equals("Nearest")) {

                settings.filterMin = Texture.TextureFilter.Nearest;

                settings.filterMag = Texture.TextureFilter.Nearest;

            } else {

                settings.filterMin = Texture.TextureFilter.Linear;

                settings.filterMag = Texture.TextureFilter.Linear;
            }

            // =========================
            // PADDING
            // =========================

            settings.duplicatePadding = duplicatePadding.isSelected();

            settings.paddingX = (Integer) paddingX.getValue();

            settings.paddingY = (Integer) paddingY.getValue();

            // =========================
            // SIZE
            // =========================

            settings.maxWidth = (Integer) maxWidth.getValue();

            settings.maxHeight = (Integer) maxHeight.getValue();

            // =========================
            // PACK
            // =========================

            TexturePacker.process(
                    settings,
                    input,
                    output,
                    atlasName);

            JOptionPane.showMessageDialog(
                    this,
                    "Atlas успешно создан!\n\n"
                            + output
                            + File.separator
                            + atlasName
                            + ".atlas",
                    "Texture Packer",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {

            e.printStackTrace();

            showError(
                    "Ошибка упаковки:\n\n"
                            + e.getMessage());
        }
    }

    private void showError(
            String message) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Texture Packer Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(() -> {

            TexturePackerTool tool = new TexturePackerTool();

            tool.setVisible(true);
        });
    }
}