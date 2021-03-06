package game.gui.game;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import game.core.GameLoop;
import game.core.GameSave;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerUI {

    public static boolean ART_SELECTED = false;
    public static String BOOST_LABEL_TEXT = "Boost Amount: ";
    public static String UPGRADE_LABEL_TEXT = "Upgrade Points: ";
    public static String USE_POINT_LABEL_TEXT = "Points Used: ";

    public JPanel mainPanel;
    private JLabel upgradeLabel;
    private JSlider skillSlider;
    private JButton upgradeSkillButton;
    private JRadioButton artButton;
    private JRadioButton programmingButton;
    private JLabel playerNameLabel;
    private JLabel playerArtLabel;
    private JLabel playerProgrammingLabel;
    private JButton dashboardButton;
    private JLabel upgradeAmtLabel;
    private JLabel upgradePointsLabel;
    private JLabel pointsUsedLabel;

    public PlayerUI(PlayerWindow currentWindow) {
        initializeLabels();
        upgradeSkillButton.setEnabled(false);

        artButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                programmingButton.setSelected(false);
                ART_SELECTED = true;
            }
        });
        programmingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                artButton.setSelected(false);
                ART_SELECTED = false;
            }
        });
        upgradeSkillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pointsUsed = skillSlider.getValue();

                //failsafe
                int points = Integer.parseInt(GameLoop.gameSave.getProperty("player_upgrade"));
                if (pointsUsed > points) pointsUsed = points;

                int boostAmount = (int) Math.ceil(pointsUsed * GameSave.UPGRADE_CONVERSION);
                GameLoop.gameSave.setProperty("player_upgrade", String.valueOf(points - pointsUsed));

                if (artButton.isSelected()) { // ART
                    int artAmount = Integer.parseInt(GameLoop.gameSave.getProperty("player_art"));
                    GameLoop.gameSave.setProperty("player_art", String.valueOf(artAmount + boostAmount));
                } else { // PROGRAMMING
                    int programmingAmount = Integer.parseInt(GameLoop.gameSave.getProperty("player_programming"));
                    GameLoop.gameSave.setProperty("player_programming", String.valueOf(programmingAmount + boostAmount));
                }

                skillSlider.setMaximum(Integer.parseInt(GameLoop.gameSave.getProperty("player_upgrade")));
                skillSlider.setValue(0);
                initializeLabels();
            }
        });
        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentWindow.dispose();
                new MainGameWindow();
            }
        });
        skillSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                upgradeAmtLabel.setText(BOOST_LABEL_TEXT + String.valueOf(skillSlider.getValue() * GameSave.UPGRADE_CONVERSION));
                pointsUsedLabel.setText(USE_POINT_LABEL_TEXT + skillSlider.getValue());

                if (skillSlider.getValue() < 1) {
                    upgradeSkillButton.setEnabled(false);
                } else {
                    upgradeSkillButton.setEnabled(true);
                }
            }
        });
    }

    private void initializeLabels() {
        playerNameLabel.setText("[" + GameLoop.gameSave.getProperty("player_name") + "] - Stats");
        playerArtLabel.setText("Art Skill: " + GameLoop.gameSave.getProperty("player_art"));
        playerProgrammingLabel.setText("Programming Skill: " + GameLoop.gameSave.getProperty("player_programming"));
        upgradeAmtLabel.setText(BOOST_LABEL_TEXT + "0");
        upgradePointsLabel.setText(UPGRADE_LABEL_TEXT + GameLoop.gameSave.getProperty("player_upgrade"));
        pointsUsedLabel.setText(USE_POINT_LABEL_TEXT + skillSlider.getValue());

        int maxPoints = Integer.parseInt(GameLoop.gameSave.getProperty("player_upgrade"));
        if (maxPoints > 0) {
            skillSlider.setEnabled(true);
            skillSlider.setMaximum(maxPoints);

            programmingButton.setEnabled(true);
            artButton.setEnabled(true);
        } else {
            skillSlider.setMaximum(0);
            skillSlider.setValue(0);
            skillSlider.setEnabled(false);

            programmingButton.setEnabled(false);
            artButton.setEnabled(false);
        }

        if (ART_SELECTED) {
            artButton.setSelected(true);
            programmingButton.setSelected(false);
        } else {
            programmingButton.setSelected(true);
            artButton.setSelected(false);
        }
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
        mainPanel.setLayout(new GridLayoutManager(11, 3, new Insets(0, 0, 0, 0), -1, -1));
        upgradeLabel = new JLabel();
        upgradeLabel.setText("Select a skill and upgrade:");
        mainPanel.add(upgradeLabel, new GridConstraints(0, 1, 2, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(1, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        skillSlider = new JSlider();
        skillSlider.setInverted(false);
        skillSlider.setMajorTickSpacing(5);
        skillSlider.setMaximum(5);
        skillSlider.setMinorTickSpacing(1);
        skillSlider.setOpaque(false);
        skillSlider.setPaintLabels(true);
        skillSlider.setPaintTicks(true);
        skillSlider.setPaintTrack(true);
        skillSlider.setSnapToTicks(true);
        skillSlider.setValue(0);
        mainPanel.add(skillSlider, new GridConstraints(3, 1, 6, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upgradeSkillButton = new JButton();
        upgradeSkillButton.setText("Upgrade Skill");
        mainPanel.add(upgradeSkillButton, new GridConstraints(10, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        artButton = new JRadioButton();
        artButton.setHorizontalAlignment(0);
        artButton.setText("Art");
        artButton.setVerticalAlignment(0);
        artButton.setVerticalTextPosition(0);
        mainPanel.add(artButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        programmingButton = new JRadioButton();
        programmingButton.setHorizontalAlignment(0);
        programmingButton.setHorizontalTextPosition(11);
        programmingButton.setText("Programming");
        mainPanel.add(programmingButton, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        playerNameLabel = new JLabel();
        playerNameLabel.setText("NAME");
        mainPanel.add(playerNameLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        playerProgrammingLabel = new JLabel();
        playerProgrammingLabel.setText("PROGRAMMING");
        mainPanel.add(playerProgrammingLabel, new GridConstraints(5, 0, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        playerArtLabel = new JLabel();
        playerArtLabel.setText("ART");
        mainPanel.add(playerArtLabel, new GridConstraints(3, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dashboardButton = new JButton();
        dashboardButton.setText("Dashboard");
        mainPanel.add(dashboardButton, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upgradePointsLabel = new JLabel();
        upgradePointsLabel.setText("Upgrade Points:");
        upgradePointsLabel.setVerticalAlignment(3);
        upgradePointsLabel.setVerticalTextPosition(3);
        mainPanel.add(upgradePointsLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_SOUTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upgradeAmtLabel = new JLabel();
        upgradeAmtLabel.setText("Boost Amount:");
        mainPanel.add(upgradeAmtLabel, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pointsUsedLabel = new JLabel();
        pointsUsedLabel.setText("Points Used:\n");
        mainPanel.add(pointsUsedLabel, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
