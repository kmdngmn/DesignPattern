// POJO; VO
public class Person {
    private static int counter = 1;
    private int id;
    private String name;
    private String address;
    
    Person(String name, String address) {
        this.name = name;
        this.address = address;
        id = counter;
        counter++;
    }

    Person(int id, String name, String address) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "" + id + ", " + name + ", " + address;
    }
}
