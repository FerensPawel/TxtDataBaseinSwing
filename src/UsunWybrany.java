import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class UsunWybrany extends JFrame {
    private JPanel mainPanel;
    private JTextField textPesel;
    private JButton usunButton;
    private JButton wrocButton;

    public UsunWybrany(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        setLocationRelativeTo(null);
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileHelper fileHelper = new FileHelper();
                PersonHelper personHelper = new PersonHelper();
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
                        dane.remove(i);
                        status = false;
                    }
                }
                PrintWriter pw = null;
                try {
                    pw = new PrintWriter("baza.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                pw.close();
                LinkedList<Person> noweDane = new LinkedList<>();
                noweDane = personHelper.convertListOfStringsToListOfPeople(dane);
                fileHelper.saveListToFile(noweDane);
                if (!status) {
                    JOptionPane.showMessageDialog(null, "Uzytkownik o peselu: " + textPesel.getText() + " został usunięty.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nie ma takiego peselu w bazie");
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
