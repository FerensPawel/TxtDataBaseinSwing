import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class PokazWybrany extends JFrame {

    private JPanel mainPanel;
    private JTextField textPesel;
    private JButton pokazButton;
    private JButton wrocButton;

    public PokazWybrany(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        setLocationRelativeTo(null);
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Menu window = new Menu("Menu");
                    dispose();
                    window.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        pokazButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileHelper fileHelper = new FileHelper();
                LinkedList<String> dane = null;
                String temp;
                Boolean status = true;
                try {
                    dane = fileHelper.readFromFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < dane.size(); i++) {
                    temp = dane.get(i);

                    if (temp.contains(textPesel.getText())) {

                        String[] source = temp.split(";");
                        JOptionPane.showMessageDialog(null, "Pesel: " + source[0] + "\n" +
                                "Imie: " + cezarwroc(source[1]) + "\n"
                                + "Nazwisko: " + cezarwroc(source[2]) + "\n"
                                + "Wiek: " + cezarwroc(source[3]) + "\n"
                                + "Zawod: " + cezarwroc(source[4]) + "\n"
                                + "Miasto: " + cezarwroc(source[5]));
                        status = false;
                    }
                }
                if (status == true) {
                    JOptionPane.showMessageDialog(null, "Nie ma takiego numeru pesel");
                }
            }
        });
    }

    public static String cezarwroc(String str) {
        char x[] = str.toCharArray();
        for (int i = 0; i != x.length; i++) {
            int n = x[i];
            n -= 5;
            x[i] = (char) n;
        }
        return new String(x);
    }
}
