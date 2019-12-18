package lab08_DAOPattern_5;

import java.util.List;

public interface PersonDao {
    public void insert(Person p);
    public List<Person> findAll();
    public Person findById(int id);
    public void update(Person p, int id);
    public void delete(int id);
    public void delete(Person p);
}
