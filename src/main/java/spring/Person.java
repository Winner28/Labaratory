package spring;

public interface  Person {
    String getFirstName();

    String getLastName();

    Country getCountry();

    boolean isProgrammer();

    java.util.List<Contact> getContacts();
}
