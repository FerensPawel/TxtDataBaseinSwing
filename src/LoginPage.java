import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JPanel mainPanel;
    private JButton zalogujButton;
    private JPasswordField passwordField1;

    public LoginPage(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        setLocationRelativeTo(null);
        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (passwordField1.getText().equals("haslo")) {
                    try {
                        Menu window = new Menu("Menu");
                        window.setVisible(true);
                        dispose();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Podaj prawidłowe hasło!!!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new LoginPage("Login");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
