package aula13.av2;

import java.io.FileNotFoundException;

public interface ContactManagerInterface {
    void load(String filePath) throws FileNotFoundException;

    void save(String filePath) throws FileNotFoundException;

    boolean validateEmail(String email);

    boolean validatePhoneNumber(String phoneNumber);

    boolean addContact(Contact person);

    boolean removeContact(Contact person);

    Contact searchContactByname(String name);

    Contact searchContactByEmail(String email);

    Contact searchContactByPhoneNumber(int phoneNumber);

    void listAllContacts();

    void listContactsByName();

    void listContactsByPhoneNumber();

    void listContactsByBirthDate();
}
