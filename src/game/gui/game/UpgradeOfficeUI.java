package game.gui.game;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import game.core.GameLoop;
import game.core.Reference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpgradeOfficeUI {

    //OFFICE COST: 15000x^2 where x is the new office ID

    private static final String NEXT_COST_TEXT = "Next Office Cost: ";
    private static final String CURRENT_OFFICE_TEXT = "Current Office: ";
    private static final String CURRENT_FUNDS_TEXT = "Current Funds: ";

    public JPanel mainPanel;
    private JLabel companyLabel;
    private JButton upgradeOfficeButton;
    private JLabel nextCostLabel;
    private JLabel currentOfficeLabel;
    private JLabel currentFundsLabel;
    private JButton closeButton;

    public UpgradeOfficeUI(UpgradeOfficeWindow currentWindow) {
        initializeLabels();
        upgradeOfficeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextOfficeCost = (int) (Math.pow(Integer.parseInt(GameLoop.gameSave.getProperty("company_office")) + 1, 2) * 15000);
                float currentFunds = Float.parseFloat(GameLoop.gameSave.getProperty("company_money"));
                int currentOffice = Integer.parseInt(GameLoop.gameSave.getProperty("company_office"));

                if (currentFunds > nextOfficeCost) {
                    float newFunds = currentFunds - nextOfficeCost;

                    GameLoop.gameSave.setProperty("company_money", String.valueOf(newFunds));
                    GameLoop.gameSave.setProperty("company_office", String.valueOf(currentOffice + 1));
                    initializeLabels();
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentWindow.dispose();
                new CompanyWindow();
            }
        });
    }

    private void initializeLabels() {

        if (Integer.parseInt(GameLoop.gameSave.getProperty("company_office")) < 7) {
            int nextOfficeCost = (int) (Math.pow(Integer.parseInt(GameLoop.gameSave.getProperty("company_office")) + 1, 2) * 15000);
            float currentFunds = Float.parseFloat(GameLoop.gameSave.getProperty("company_money"));

            companyLabel.setText(GameLoop.gameSave.getProperty("company_name"));

            nextCostLabel.setText(NEXT_COST_TEXT + nextOfficeCost);
            currentOfficeLabel.setText(CURRENT_OFFICE_TEXT + Reference.getOffice(Integer.parseInt(GameLoop.gameSave.getProperty("company_office"))));
            currentFundsLabel.setText(CURRENT_FUNDS_TEXT + currentFunds);

            if (currentFunds < nextOfficeCost) {
                upgradeOfficeButton.setEnabled(false);
                nextCostLabel.setForeground(Color.RED);
            } else {
                upgradeOfficeButton.setEnabled(true);
                nextCostLabel.setForeground(Color.BLACK);
            }
        } else {
            upgradeOfficeButton.setEnabled(false);
            upgradeOfficeButton.setText("No more offices!");

            nextCostLabel.setText(NEXT_COST_TEXT + "No new offices!");
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
        mainPanel.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        companyLabel = new JLabel();
        companyLabel.setText("[COMPANY] - OFFICE");
        mainPanel.add(companyLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        currentFundsLabel = new JLabel();
        currentFundsLabel.setText("Current Funds:");
        mainPanel.add(currentFundsLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        currentOfficeLabel = new JLabel();
        currentOfficeLabel.setText("Current Office");
        mainPanel.add(currentOfficeLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nextCostLabel = new JLabel();
        nextCostLabel.setText("Next Upgrade Cost:");
        mainPanel.add(nextCostLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upgradeOfficeButton = new JButton();
        upgradeOfficeButton.setText("Upgrade Office");
        mainPanel.add(upgradeOfficeButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        closeButton = new JButton();
        closeButton.setText("Close");
        mainPanel.add(closeButton, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
