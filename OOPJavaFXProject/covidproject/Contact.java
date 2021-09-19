//Jamie Baggott R00149982

package covidproject;

public class Contact {
    private String firstName;
    private String lastName;
    private String uniqueId;
    private int phoneNum;

    //Declares the variables for the contacts
    public Contact (String f, String l, String u, int p){
        firstName = f ;
        lastName = l;
        uniqueId = u;
        phoneNum = p;
    }

    public Contact(){}

    public String getName() {
        return firstName+" "+lastName;
    }

    public void setName(String n1, String n2){
        firstName = n1;
        lastName = n2;
    }

    //The string that displays all the information to the application
    public String toString ()
    {
        String s = "The name is " + firstName + " " + lastName + " .Their ID number is " + uniqueId + " and their phone number is " + phoneNum + "\n";
        return s;
    }


}
