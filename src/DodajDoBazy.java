import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class DodajDoBazy extends JFrame {
    private JPanel mainPanel;
    private JTextField textMiasto;
    private JTextField textZawod;
    private JButton dodajButton;
    private JTextField textWiek;
    private JTextField textNazwisko;
    private JTextField textImie;
    private JButton wrocButton;
    private JTextField textPesel;

    public DodajDoBazy(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        setLocationRelativeTo(null);
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileHelper fileHelper = new FileHelper();
                LinkedList<String> dane = null;
                String temp;
                String imie;
                String nazwisko;
                String wiek;
                String zawod;
                String miasto;
                Boolean status = false;

                if (textPesel.getText().length() == 11) {
                    try {
                        dane = fileHelper.readFromFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < dane.size(); i++) {
                        temp = dane.get(i);
                        if (temp.contains(textPesel.getText())) {
                            JOptionPane.showMessageDialog(null, "Osoba już istnieje w bazie proszę podać inne dane!");
                            status = true;
                        }
                    }
                    if (!status) {
                        imie = cezar(textImie.getText());
                        nazwisko = cezar(textNazwisko.getText());
                        wiek = cezar(textWiek.getText());
                        zawod = cezar(textZawod.getText());
                        miasto = cezar(textMiasto.getText());
                        Person person = new Person(textPesel.getText(), imie, nazwisko, wiek, zawod, miasto);
                        fileHelper.savePersonToFile(person);
                        JOptionPane.showMessageDialog(null, "Osoba została dodana do bazy");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pesel musi posiadać 11 znaków!");
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

    public static String cezar(String str) {
        char x[] = str.toCharArray();

        for (int i = 0; i != x.length; i++) {
            int n = x[i];
            n += 5;
            x[i] = (char) n;
        }
        return new String(x);
    }




}