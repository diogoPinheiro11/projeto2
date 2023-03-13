import javax.swing.*;
import java.awt.*;

public class register {
    private JPanel register;
    private JTextField username;
    private JPasswordField password;
    private JTextField name;
    private JTextField email;
    private JComboBox role;
    private JButton registerButton;
    private JButton returnButton;
    private JFrame frame;

    public register(){
        frame = new JFrame("Register Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);

        frame.add(register);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
