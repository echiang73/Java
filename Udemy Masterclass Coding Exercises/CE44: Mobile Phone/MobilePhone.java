// Basic solution
import java.util.ArrayList;
 
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;
 
    public MobilePhone(String number) {
        myNumber = number;
        myContacts = new ArrayList<>();
    }
 
    public boolean addNewContact(Contact contact) {
        for (Contact myContact : myContacts) {
            if (myContact.getName().equals(contact.getName())) {
                return false;
            }
        }
        myContacts.add(contact);
        return true;
    }
 
    public boolean updateContact(Contact oldContact, Contact newContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(oldContact.getName())) {
                myContacts.set(i, newContact);
                return true;
            }
        }
        return false;
    }
 
    public boolean removeContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contact.getName())) {
                myContacts.remove(i);
                return true;
            }
        }
        return false;
    }
 
    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
 
    private int findContact(Contact contact) {
        return findContact(contact.getName());
    }
 
    public Contact queryContact(String name) {
        if (findContact(name) >= 0) {
            return myContacts.get(findContact(name));
        }
        return null;
    }
 
    public void printContacts(){
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            String name = myContacts.get(i).getName();
            String phoneNumber = myContacts.get(i).getPhoneNumber();
            System.out.println((i + 1) + ". " + name + " -> " + phoneNumber);
        }
    }
}


 // Alternative queryContact() method using ternary operator
    public Contact queryContact(String name) {
        return (findContact(name) >= 0) ? myContacts.get(findContact(name)) : null;
    }


// Alternative updateContact() method by calling removeContact() and addNewContact() if order of myContacts doesn't matter, i.e. more like "replace" Contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(oldContact.getName())) {
                boolean isRemoved = removeContact(oldContact);
                if (isRemoved) {
                    return addNewContact(newContact);
                }
                return false;
            }
        }
        return false;
    }