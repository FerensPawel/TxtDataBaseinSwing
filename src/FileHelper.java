import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileHelper {

    public String personToString(Person osoba) {
        StringBuilder build = new StringBuilder();
        build.append(osoba.getPesel());
        build.append(";");
        build.append(osoba.getImie());
        build.append(";");
        build.append(osoba.getNazwisko());
        build.append(";");
        build.append(osoba.getWiek());
        build.append(";");
        build.append(osoba.getZawod());
        build.append(";");
        build.append(osoba.getMiasto());
        return build.toString();
    }


    public void savePersonToFile(Person person) {
        try {
            File file = new File("baza.txt");
            if (!file.exists())
                file.createNewFile();
            FileWriter pisz = new FileWriter(file, true);
            pisz.write(personToString(person));
            pisz.write("\n");

            pisz.close();
        } catch (IOException ioe) {
        }
    }

    public void saveListToFile(List<Person> list) {
        try {
            File file = new File("baza.txt");
            if (!file.exists())
                file.createNewFile();
            FileWriter pisz = new FileWriter(file, true);
            for (int i = 0; i < list.size(); i++) {
                pisz.write(personToString(list.get(i)));
                pisz.write("\n");
            }
            pisz.close();
        } catch (IOException ioe) {
        }
    }

    public LinkedList<String> readFromFile() throws IOException {
        LinkedList<String> lines = new LinkedList<>();
        File file = new File("baza.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String row;
        while ((row = bufferedReader.readLine()) != null) {
            lines.add(row);
        }
        return lines;
    }
}