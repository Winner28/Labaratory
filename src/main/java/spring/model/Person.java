package spring.model;

public interface  Person {
    String getFirstName();

    String getLastName();

    Country getCountry();

    boolean isProgrammer();

    java.util.List<Contact> getContacts();

    default String getName() {
        return getFirstName() + " " + getLastName();
    }

    boolean isBroke();

}
