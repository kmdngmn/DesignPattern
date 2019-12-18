package lab08_DAOPattern_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoSQLImpl implements PersonDao {

	final static String DB_FILE_NAME = "addressbook.db";
	final static String DB_TABLE_NAME = "persons";
	Connection connection = null;
	ResultSet rs = null;
	Statement statement = null;

	final String table = " (ID INTEGER PRIMARY KEY AUTOINCREMENT, name text, address text)";

	public PersonDaoSQLImpl() {

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
			statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			// create table
			statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
			statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insert(Person p) {
		try {
			statement.execute("INSERT INTO " + DB_TABLE_NAME + "(id, name, address) VALUES(" + p.getId() + ",'"
					+ p.getName() + "','" + p.getAddress() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Person> findAll() {

		List<Person> persons = new ArrayList<Person>();

		try {
			rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
			while (rs.next()) {
				persons.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}

	public Person findById(int id) {

		Person person = null;

		try {

			rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id = " + id);
			person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}

	public void update(Person p, int id) {
		Person person = findById(id);
		if (person != null) {
			try {
				statement.execute("UPDATE " + DB_TABLE_NAME + " SET name = '" + p.getName() + "' WHERE id = " + id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void delete(int id) {
		Person person = findById(id);
		if (person != null) {
			try {
				statement.execute("DELETE FROM " + DB_TABLE_NAME + " WHERE id = " + id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(Person p) {
		delete(p.getId());
	}
}
