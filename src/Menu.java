import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel mainPanel;
    private JButton pokazBazeButton;
    private JButton usunWybranyZBazyButton;
    private JButton wyczyscBazeButton;
    private JButton dodajDoBazyButton;
    private JButton pokazWybranyRekordButton;

    public Menu(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        setLocationRelativeTo(null);
        dodajDoBazyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    DodajDoBazy window = new DodajDoBazy("Dodaj do bazy");
                    dispose();
                    window.setVisible(true);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        wyczyscBazeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    WyczyscBaze window = new WyczyscBaze("Wyczysc baze");
                    window.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        usunWybranyZBazyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    UsunWybrany window = new UsunWybrany("Usun wybrany");
                    window.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        pokazBazeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    PokazBaze window = new PokazBaze("Pokaz baze");
                    window.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        pokazWybranyRekordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    PokazWybrany window = new PokazWybrany("Pokaz wybrany");
                    window.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
