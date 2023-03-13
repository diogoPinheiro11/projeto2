import javax.swing.*;
import java.awt.*;

public class admin {
    private JButton createUserButton;
    private JPanel admin;
    private JButton editUserButton;
    private JButton deleteUserButton;
    private JButton listUsersButton;
    private JButton listSeedsButton;
    private JButton listStockButton;
    private JButton logoutButton;
    private JFrame frame;

    public admin(){
        frame = new JFrame("Admin Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);

        frame.add(admin);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
