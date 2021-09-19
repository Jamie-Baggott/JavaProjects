//Jamie Baggott R00149982

package covidproject;


import java.io.File;
import java.util.ArrayList;

public class CovidList {
    File filename = new File("contacts.txt");
    public ArrayList<Contact> contacts;
    String contact = " ";

    //Start the list
    public CovidList() {

        contacts = new ArrayList<Contact>();
    }

    //Shows the list
    public ArrayList<Contact> getList() {

        return contacts;
    }

    //Adds Contacts to the list
    public void addContact(Contact c) {

        contacts.add(c);
    }

    //Method to remove a person from the list by their name
    public void remContactByName(String firstName, String lastName, String phoneNum, String uniqueId) {
        for (int i = 0; i < contacts.size(); i++)
            if (getContact(i).getName().equals(firstName + " " + lastName))
                contacts.remove(i);
    }

    public Contact getContact(int i) {
        if ((i > -1) && (i < contacts.size()))
            return contacts.get(i);
        return null;
    }


    public int getSize() {
        return contacts.size();
    }

}
