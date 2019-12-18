import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    List<Person> persons;

    public PersonDaoImpl() {
        persons = new ArrayList<Person>();
    }

    public void insert(Person p) {
        persons.add(p);
    }

    public List<Person> findAll() {
        return persons;
    }

    public Person findById(int id) {
        int n = 0;
        for (Person pi : persons) {
            if (pi.getId() == id) {
                break;
            }
            n++;
        }
        if (n >= persons.size()) {
            return null;
        }
        return persons.get(n);
    }

    public void update(Person p, int id) {
        Person person = findById(id);
        if (person != null) {
            person.setName(p.getName());
            person.setAddress(p.getAddress());
        }
    }

    public void delete(int id) {
        Person person = findById(id);
        if (person != null) {
            persons.remove(person);
        }
    }

    public void delete(Person p) {
        int id = p.getId();
        persons.remove(p);
    }
}
