package aula06.ex2;

import aula06.ex1.Person;

import java.util.ArrayList;

public class ListOfContacts {
    public ArrayList<Contact> allContacts = new ArrayList<>();

    @Override
    public String toString(){
        String result = "";
        for(Contact contact : allContacts){
            result += contact + "\n";
        }
        return result;
    }

    public ArrayList<Contact> searchByPhoneNumber(int phoneNumber){
        ArrayList<Contact> filterByPhoneNumber = new ArrayList<>();

        for(Contact contact : this.allContacts){
            if(contact.getCellPhoneNumber() == phoneNumber)
                filterByPhoneNumber.add(contact);
        }

        return filterByPhoneNumber;
    }

    public ArrayList<Contact> searchByName(String name){
        ArrayList<Contact> filterByName = new ArrayList<>();

        for(Contact contact : this.allContacts){
            if(contact.getContactPerson().getName().equals(name))
                filterByName.add(contact);
        }

        return filterByName;
    }

    public void insertContact(Contact contact){
        this.allContacts.add(contact);
    }

    public void deleteById(int ID){
        this.allContacts.remove(ID-1);
        for(int i = ID-1; i < this.allContacts.size(); i++){
            // reduce the ID of elements above of the deleted
            this.allContacts.get(i).setID(i + 1);
        }
        Contact.counterID--;
    }

    public void changeContactByID(int inputID, Person contactPerson, int contactPhoneNumber, String contactEmailAddress){
        this.allContacts.get(inputID-1).setContactPerson(contactPerson);
        this.allContacts.get(inputID-1).setCellPhoneNumber(contactPhoneNumber);
        this.allContacts.get(inputID-1).setEmailAddress(contactEmailAddress);
    }

}
