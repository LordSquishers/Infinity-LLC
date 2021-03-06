package game.gui.wizard;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import game.core.InfinityGame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameUI {
    public JPanel mainPanel;
    private JLabel gameSaveLabel;
    private JTextField gameSaveField;
    private JTextField companyNameField;
    private JLabel companyNameLabel;
    private JTextField playerNameField;
    private JLabel playerNameLabel;
    private JLabel programmingSkillLabel;
    private JLabel artSkillLabel;
    private JSlider programmingSkillSlider;
    private JSlider artSkillSlider;
    private JButton backButton;
    private JButton createNewSaveButton;

    public NewGameUI(NewGameWindow currentWindow) {
        programmingSkillSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int programmingSkillValue = programmingSkillSlider.getValue();

                artSkillSlider.setValue(40 - programmingSkillValue);
            }
        });
        artSkillSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int artSkillValue = artSkillSlider.getValue();

                programmingSkillSlider.setValue(40 - artSkillValue);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentWindow.dispose();
                new GameWizardWindow();
            }
        });
        createNewSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentWindow.dispose();
                InfinityGame.gameWizard.startGame(InfinityGame.gameWizard.newGameSetup(gameSaveField.getText(), companyNameField.getText(), playerNameField.getText(), artSkillSlider.getValue(), programmingSkillSlider.getValue()));
            }
        });
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(6, 3, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        mainPanel.add(spacer2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        mainPanel.add(spacer3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        mainPanel.add(spacer4, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        mainPanel.add(spacer5, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        gameSaveLabel = new JLabel();
        gameSaveLabel.setText("Game Save Name:");
        mainPanel.add(gameSaveLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        companyNameLabel = new JLabel();
        companyNameLabel.setText("Company Name:");
        mainPanel.add(companyNameLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        playerNameLabel = new JLabel();
        playerNameLabel.setText("Player Name:");
        mainPanel.add(playerNameLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        programmingSkillLabel = new JLabel();
        programmingSkillLabel.setText("Programming Skill");
        mainPanel.add(programmingSkillLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        artSkillLabel = new JLabel();
        artSkillLabel.setText("Art Skill:");
        mainPanel.add(artSkillLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gameSaveField = new JTextField();
        gameSaveField.setEnabled(true);
        mainPanel.add(gameSaveField, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        companyNameField = new JTextField();
        companyNameField.setEnabled(true);
        mainPanel.add(companyNameField, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        playerNameField = new JTextField();
        playerNameField.setEnabled(true);
        mainPanel.add(playerNameField, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        programmingSkillSlider = new JSlider();
        programmingSkillSlider.setMajorTickSpacing(10);
        programmingSkillSlider.setMaximum(40);
        programmingSkillSlider.setMinorTickSpacing(2);
        programmingSkillSlider.setOrientation(0);
        programmingSkillSlider.setPaintLabels(true);
        programmingSkillSlider.setPaintTicks(true);
        programmingSkillSlider.setSnapToTicks(false);
        programmingSkillSlider.setValue(20);
        programmingSkillSlider.setValueIsAdjusting(false);
        mainPanel.add(programmingSkillSlider, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Back");
        mainPanel.add(backButton, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createNewSaveButton = new JButton();
        createNewSaveButton.setText("Create New Save");
        mainPanel.add(createNewSaveButton, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        artSkillSlider = new JSlider();
        artSkillSlider.setMajorTickSpacing(10);
        artSkillSlider.setMaximum(40);
        artSkillSlider.setMinorTickSpacing(2);
        artSkillSlider.setOrientation(0);
        artSkillSlider.setPaintLabels(true);
        artSkillSlider.setPaintTicks(true);
        artSkillSlider.setSnapToTicks(false);
        artSkillSlider.setValue(20);
        artSkillSlider.setValueIsAdjusting(false);
        mainPanel.add(artSkillSlider, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
