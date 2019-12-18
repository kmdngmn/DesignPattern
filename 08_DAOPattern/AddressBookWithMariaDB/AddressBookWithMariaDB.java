import java.sql.*;

public class AddressBookMariaDB {
    static final String MARIA_DB_JDBC_DRIVER = "org.mariadb.jdbc.Driver"; // MariaDB driver
    static final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver"; // MySQL driver
    static final String DB_FILE_NAME = "addressbook.db";
    static final String DB_TABLE_NAME = "persons";

    static final String USERNAME = "addruser";
    static final String PASSWORD = "addrpw";

    public static void main (String[] args){
        Connection connection = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            Class.forName(MARIA_DB_JDBC_DRIVER); // loading a JDBC driver
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/AddressBook", USERNAME,  PASSWORD);
            //connection = DriverManager.getConnection("jdbc:mysql://localhost", USERNAME,  PASSWORD);  // MySQL
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            final String table = " (id int(64) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, address varchar(255) NOT NULL, UNIQUE(id))";
            // create table
            statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);

            System.out.println("--- inserting...");
            statement.execute("INSERT INTO persons(name, address) VALUES('Seonyoung Kim','1 Hongji Dong')");
            statement.execute("INSERT INTO persons(name, address) VALUES('Jangkwon Lee','2 Hongji Dong')");

            System.out.println("--- finding all...");
            rs = statement.executeQuery("SELECT * FROM persons WHERE id < 4 ORDER BY id");
            while (rs.next()) {
                System.out.println("" + rs.getInt("ID") + ", " + rs.getString("name") + ", " + rs.getString("address"));
            }

            System.out.println("--- updating...");
            statement.execute("UPDATE persons SET name = 'Sooyoung Lim' WHERE id = 1");

            System.out.println("--- see if updated...");
            rs = statement.executeQuery("SELECT * FROM persons WHERE id = 1");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("address"));
            }

            System.out.println("--- deleting...");
            statement.execute("DELETE FROM persons WHERE id = 1");

            System.out.println("--- finding all after deleting...");
            rs = statement.executeQuery("SELECT * FROM persons WHERE id < 4 ORDER BY id");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("address"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}