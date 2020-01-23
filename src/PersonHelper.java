import java.util.LinkedList;

public class PersonHelper {

    public LinkedList<Person> convertListOfStringsToListOfPeople(LinkedList<String> list) {
        LinkedList<Person> resultList = new LinkedList<>();
        for (String line : list) {
            resultList.add(convertStringToPerson(line));
        }
        return resultList;
    }

    public Person convertStringToPerson(String data) {
        Person person = new Person();
        String[] source = data.split(";");
        person.setImie(source[0]);
        person.setNazwisko(source[1]);
        person.setWiek(source[2]);
        person.setZawod(source[3]);
        person.setMiasto(source[4]);
        return person;
    }
}
