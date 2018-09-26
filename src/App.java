import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Asia", 20));
        persons.add(new Person("Asia", 15));
        persons.add(new Person("Maciek", 18));
        persons.add(new Person("Jacek", 22));
        persons.add(new Person("Artur", 16));
        persons.add(new Person("Maciek", 22));
        persons.add(new Person("Asia", 24));
        for (Person person : app.transform(persons)){
            System.out.println(person.getName() + " " + person.getAge());
        }
    }

    public List<Person> transform(List<Person> input){
        List<Person> transformed = new ArrayList<>();
        for (Person person : input){
            if (!checkIfPersonInListByName(person.getName(), transformed)){
                transformed.add(person);
            } else {
                findPersonByName(person.getName(), transformed).setAge(person.getAge());
            }
        }
        return transformed;
    }

    private boolean checkIfPersonInListByName(String name, List<Person> list){
        for (Person person : list){
            if (person.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private Person findPersonByName(String name, List<Person> list){
        for (Person person : list){
            if (person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
}
