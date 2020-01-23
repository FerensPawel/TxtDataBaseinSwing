import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PokazBaze extends JFrame {
    private JPanel mainPanel;
    private JButton otworzBazeButton;
    private JButton wrocButton;

    public PokazBaze(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        setLocationRelativeTo(null);
        otworzBazeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File plik = new File("baza.txt");
                try {
                    Desktop.getDesktop().open(plik);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
    }


}
