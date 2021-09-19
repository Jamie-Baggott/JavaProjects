//Jamie Baggott R00149982

package covidproject;

import java.io.*;
import java.util.Scanner;

//The Controller Class for the project
public class CovidController {
    private CovidList cl;

    public CovidController() {
        cl = new CovidList();
    }

    //Method to add Contact to the List
    public void addContactToList(String firstName, String lastName, String uniqueID, String phoneNum) {
        int num = Integer.parseInt(phoneNum);
        Contact c = new Contact(firstName, lastName, uniqueID, num);
        cl.addContact(c);

    }

    //Method to return all the contacts so far
    public String getListContacts() {
        String allContacts = "\0";
        for (int i = 0; i < cl.getSize(); i++) {
            allContacts = allContacts + cl.getContact(i);
        }
        return allContacts;
    }

    public String[] getEachContact() {
        StringBuilder allContacts = new StringBuilder("\0");
        for (int i = 0; i < cl.getSize(); i++) {
            allContacts.append(cl.getContact(i));
        }

        //return allContacts.toString();
        String eachContact[] = allContacts.toString().split("\n");

        return eachContact;
    }




    //Method to remove a contact from the list
    public void removeContactFromList(String firstName, String lastName, String uniqueID, String phoneNum) {

        cl.remContactByName(firstName, lastName, uniqueID, phoneNum);
    }


    //Method to save the list to a file "contacts.txt"
    public void saveDataToFile(File file) {
        String allContacts = "\0";
        for (int i = 0; i < cl.getSize(); i++) {
            allContacts = allContacts + cl.getContact(i);

        }

        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Jamie\\IdeaProjects\\JavaFX\\src\\covidproject\\contacts.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allContacts);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    //Method to load data from the saved file Contacts.txt
    public void loadDataFromFile(File file) {
        String allContacts = "\0";
        for (int i = 0; i < cl.getSize(); i++) {
            allContacts = allContacts + cl.getContact(i);

        }
        try {
            FileInputStream in;
            String l;
            StringBuffer buf = new StringBuffer();
            String filename = "C:\\Users\\Jamie\\IdeaProjects\\JavaFX\\src\\covidproject\\contacts.txt";
            in = new FileInputStream(filename);
            Scanner sc = new Scanner(in);
            do {
                l = sc.nextLine();
                String delimiter = " ";
                String[] words;

                words = l.split(delimiter);
                String firstName = words[3];
                String lastName = words[4];
                String uniqueID = words[9];
                String phoneNum = words[15];
                int num = Integer.parseInt(phoneNum);
                Contact c = new Contact(firstName, lastName, uniqueID, num);


                cl.addContact(c);
            } while (!l.equals("  "));


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

