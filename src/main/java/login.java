import javax.swing.*;
import java.awt.*;

public class login {
    private JPanel login;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JButton resetButton;
    private JFrame frame;

    public login(){
        frame = new JFrame("Login Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);

        frame.add(login);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
