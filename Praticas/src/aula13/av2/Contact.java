package aula13.av2;

import java.time.LocalDate;

public class Contact {
    private static int idCounter = 0;
    private final int id;
    private String name;
    private int phoneNumber;
    private String email;
    private LocalDate birthDate;

    public Contact(String name, int phoneNumber, String email, LocalDate birthDate) {
        this.id = idCounter++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;

        if (getPhoneNumber() != contact.getPhoneNumber()) return false;
        if (getName() != null ? !getName().equals(contact.getName()) : contact.getName() != null) return false;
        return getEmail() != null ? getEmail().equals(contact.getEmail()) : contact.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getPhoneNumber();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    // Getters

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
