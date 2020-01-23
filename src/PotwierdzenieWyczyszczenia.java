import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PotwierdzenieWyczyszczenia extends JFrame {
    private JPanel mainPanel;
    private JButton takButton;
    private JButton nieButton;

    public PotwierdzenieWyczyszczenia(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        setLocationRelativeTo(null);


        takButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PrintWriter pw = null;
                try {
                    pw = new PrintWriter("baza.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                pw.close();
                JOptionPane.showMessageDialog(null, "Baza została wyczyszczona");
                try {
                    Menu window = new Menu("Menu");
                    dispose();
                    window.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        nieButton.addActionListener(new ActionListener() {
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
    }
}
