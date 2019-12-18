public class AddressBook {
    public static void main(String[] args) {
        Person p;
        PersonDao personDao = new PersonDaoImpl();

        System.out.println("--- inserting...");
        p = new Person("Seonyoung Kim", "1 Hongji Dong");
        personDao.insert(p);
        p = new Person("Jangkwon Lee", "2 Hongji Dong");
        personDao.insert(p);

        System.out.println("--- finding all...");
        for (Person pi : personDao.findAll()) {
            System.out.println("reading... " + pi);
        }

        System.out.println("--- updating...");
        p = personDao.findAll().get(0);
        p.setName("Sooyoung Lim");
        personDao.update(p, p.getId());

        System.out.println("--- see if updated...");
        p = personDao.findById(1);
        if (p != null) {
            System.out.println(p);
        }

        System.out.println("--- deleting...");
        personDao.delete(1);  // or personDao.delete(p);

        System.out.println("--- finding all after deleting...");
        for (Person pi : personDao.findAll()) {
            System.out.println("reading... " + pi);
        }
    }
}
