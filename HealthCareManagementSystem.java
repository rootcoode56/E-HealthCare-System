import javax.swing.*;

public class HealthCareManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthCareManagementSystemGUI gui = new HealthCareManagementSystemGUI();
            gui.setVisible(true);
        });
    }
}