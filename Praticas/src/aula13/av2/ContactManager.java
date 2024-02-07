package aula13.av2;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactManager implements ContactManagerInterface{

    Set<Contact> allContacts = new LinkedHashSet<>();

    @Override
    public void load(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader(filePath));

        String[] data;
        String name;
        int phone;
        String email;
        LocalDate date;
        while(input.hasNextLine()){
            data = input.nextLine().split("[\\s]+");
            // Nao sao adicionados contactos iguais por causa do HashCode
            if(validateEmail(data[3]) && validatePhoneNumber(data[2])){
                name = data[0] + " " + data[1];
                phone = Integer.parseInt(data[2]);
                email = data[3];
                date = LocalDate.of(Integer.parseInt(data[4].split("-")[0]),Integer.parseInt(data[4].split("-")[1]),Integer.parseInt(data[4].split("-")[2]));
                allContacts.add(new Contact(name, phone, email, date));
            }
        }
    }

    @Override
    public void save(String filePath) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filePath);

        for( Contact contact : allContacts ){
            out.append(contact.getName()).append("\t")
               .append(String.valueOf(contact.getPhoneNumber())).append("\t")
               .append(contact.getEmail()).append("\t")
               .append(contact.getBirthDate().toString()).append("\t")
               .append("\n");
        }


        out.close();
    }

    @Override
    public boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$");
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{9}");
    }

    @Override
    public boolean addContact(Contact person) {
        return person != null && allContacts.add(person);
    }

    @Override
    public boolean removeContact(Contact person) {
        return allContacts.removeIf(contact -> contact.equals(person));
    }

    public Contact searchContactById(int id) {
        return allContacts.stream()
                .filter((contact) -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public Contact searchContactByname(String name) {
        return allContacts.stream()
                .filter((contact -> contact.getName().equals(name)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Contact searchContactByEmail(String email) {
        return allContacts.stream()
                .filter((contact -> contact.getEmail().equals(email)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Contact searchContactByPhoneNumber(int phoneNumber) {
        return allContacts.stream()
                .filter((contact -> contact.getPhoneNumber() == phoneNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void listAllContacts() {
        allContacts.forEach(System.out::println);
    }

    @Override
    public void listContactsByName() {
        allContacts.stream()
                    .sorted(Comparator.comparing(Contact::getName))
                    .forEach(System.out::println);
    }

    @Override
    public void listContactsByPhoneNumber() {
        allContacts.stream()
                .sorted(Comparator.comparing(Contact::getPhoneNumber))
                .forEach(System.out::println);
    }

    public void listContactsByEmail() {
        allContacts.stream()
                .sorted(Comparator.comparing(Contact::getEmail))
                .forEach(System.out::println);
    }

    @Override
    public void listContactsByBirthDate() {
        allContacts.stream()
                .sorted(Comparator.comparing(Contact::getBirthDate))
                .forEach(System.out::println);
    }
}
