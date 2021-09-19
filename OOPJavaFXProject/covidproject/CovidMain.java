//Jamie Baggott R00149982

package covidproject;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

//Delcares all of the labels and buttons for use
public class CovidMain extends Application {
    private Label entercontactFirstName;
    private Label entercontactLastName;
    private Label entercontactUniqueID;
    private Label entercontactPhoneNum;
    private Label enterclosecontactDate;
    private Label Date;
    private TextField contactFirstName;
    private TextField contactLastName;
    private TextField contactUniqueID;
    private TextField contactPhoneNum;
    private TextField closecontactDate;
    private Button addButton, listButton, exitButton, removeButton, saveButton, loadButton, fillButton, submitButton, confirmContactButton, submitAgainButton;
    private TextArea contactsAll;
    private TextArea closecontactsAll;
    private TextArea potentialclosecontacts;

    //Sets the drop down boxes to use for close contacts
    public ComboBox<String> comboBox1;
    public ComboBox<String> comboBox2;
    public ComboBox<String> comboBox3;

    //Sets the date implementation
    public DatePicker DateCalendar = new DatePicker();




    private static CovidController covidControl = new CovidController();
    private static File file = new File("C:\\Users\\Jamie\\IdeaProjects\\JavaFX\\src\\covidproject\\contacts.txt");
    private Object LocalDate;


    @Override
    public void start(Stage primaryStage) {
        try {
            //Implements the buttons and labels and what their values are
            entercontactFirstName = new Label("Enter first name");
            entercontactLastName = new Label("Enter second name");
            contactFirstName = new TextField();
            contactLastName = new TextField();
            entercontactUniqueID = new Label("Enter ID Number");
            contactUniqueID = new TextField();
            entercontactPhoneNum = new Label("Enter Phone Number");
            contactPhoneNum = new TextField();

            Date = new Label("No Date Selected");

            enterclosecontactDate = new Label("Enter a date of the close contact in a dd/mm/yyyy format");
            closecontactDate = new TextField();

            contactsAll = new TextArea("People to be displayed");
            closecontactsAll = new TextArea("Display People's close contacts \n");
            potentialclosecontacts = new TextArea("This will display possible close contacts\n");


            addButton = new Button("Add");
            listButton = new Button("List");
            removeButton = new Button("Remove");
            exitButton = new Button("Exit");
            saveButton = new Button("Save");
            loadButton = new Button("Load");
            fillButton = new Button("Add Contacts to Dropdown Menus");
            submitButton = new Button("Submit details");
            confirmContactButton = new Button("Confirm contact");
            submitAgainButton = new Button("Confirm");


            BorderPane mainPane = new BorderPane();
            Group root = new Group();
            Scene scene = new Scene(root, 600, 300);

            TabPane tp = new TabPane();

            tp.getTabs().add(getBoxPanel1());
            tp.getTabs().add(getBoxPanel2());
            tp.getTabs().add(getBoxPanel3());

            mainPane.setCenter(tp);

            mainPane.prefHeightProperty().bind(scene.heightProperty());

            mainPane.prefWidthProperty().bind(scene.widthProperty());

            root.getChildren().add(mainPane);
            primaryStage.setScene(scene);
            primaryStage.show();


            addButton.setOnAction(e ->
                    covidControl.addContactToList(contactFirstName.getText(), contactLastName.getText(), contactUniqueID.getText(), contactPhoneNum.getText())

            );

            listButton.setOnAction(e -> {
                String allContacts = covidControl.getListContacts();
                contactsAll.setText(allContacts);
            });

            fillButton.setOnAction(event -> {
                String[] eachContact = covidControl.getEachContact();
                comboBox1.getItems().addAll(eachContact);
                comboBox2.getItems().addAll(eachContact);
                comboBox3.getItems().addAll(eachContact);
            });


            exitButton.setOnAction(e ->

                    System.exit(0)


            );
            removeButton.setOnAction(e ->
                    covidControl.removeContactFromList(contactFirstName.getText(), contactLastName.getText(), contactUniqueID.getText(), contactPhoneNum.getText())
            );
            saveButton.setOnAction(e ->
                    covidControl.saveDataToFile(file)
            );
            loadButton.setOnAction(e ->
                    covidControl.loadDataFromFile(file)

            );
            submitButton.setOnAction(e ->
                    getCloseContactInfo()
            );
            confirmContactButton.setOnAction(e ->
                    getCloseContact()
            );
            DateCalendar.setOnAction(e ->
                    LocalDate = DateCalendar.getValue());
            Date.setText("Date: " + LocalDate);


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    //Implements the first tab
    public Tab getBoxPanel1() {

        //Sets the layout of the buttons and text boxes for the design

        HBox r1 = new HBox(10);
        r1.getChildren().addAll(entercontactFirstName, contactFirstName);

        HBox r2 = new HBox(10);
        r2.getChildren().addAll(entercontactLastName, contactLastName);

        HBox r3 = new HBox(10);
        r3.getChildren().addAll(entercontactUniqueID, contactUniqueID);

        HBox r4 = new HBox(10);
        r4.getChildren().addAll(entercontactPhoneNum, contactPhoneNum);

        HBox r5 = new HBox(10);
        r5.getChildren().addAll(addButton, listButton, removeButton);

        HBox r6 = new HBox(10);
        r6.getChildren().addAll(saveButton, loadButton);

        HBox r7 = new HBox();
        r7.setAlignment(Pos.BOTTOM_RIGHT);
        r7.getChildren().addAll(exitButton);


        Tab t = new Tab();
        t.setText("Intro for Contact Details");
        VBox v1 = new VBox();

        v1.getChildren().addAll(r1, r2, r3, r4, r5, contactsAll, r6, r7);


        t.setContent(v1);

        return t;
    }


    //Implements the second tab
    public Tab getBoxPanel2() {


        comboBox1 = new ComboBox<>();
        comboBox2 = new ComboBox<>();


        comboBox1.setPromptText("Choose a name");


        comboBox2.setPromptText("Choose a name");


        Tab t = new Tab();
        t.setText("Close Contact Entry");
        VBox v2 = new VBox();

        HBox r1 = new HBox(10);
        r1.getChildren().addAll(comboBox1);

        HBox r2 = new HBox(10);
        r2.getChildren().addAll(comboBox2);

        HBox r3 = new HBox(10);
        r3.getChildren().addAll(DateCalendar, Date);

        HBox r4 = new HBox(10);
        r4.getChildren().addAll(submitButton);


        HBox r5 = new HBox(10);
        r5.getChildren().addAll(closecontactsAll);

        HBox r6 = new HBox(10);
        r6.setAlignment(Pos.BOTTOM_RIGHT);
        r6.getChildren().addAll(fillButton);


        v2.getChildren().addAll(r1, r2, r3, r4, r5, r6);

        t.setContent(v2);

        return t;

    }
    //Implements the third tab
    public Tab getBoxPanel3() {

        comboBox3 = new ComboBox<>();


        comboBox3.setPromptText("Choose a name");

        Tab t = new Tab();
        t.setText("Details for a person's close contact");
        VBox v3 = new VBox();

        HBox r1 = new HBox(10);
        r1.getChildren().addAll(comboBox3);

        HBox r2 = new HBox(10);
        r2.getChildren().addAll(confirmContactButton);

        HBox r3 = new HBox(10);
        r3.getChildren().addAll(potentialclosecontacts);

        v3.getChildren().addAll(r1, r2, r3);

        t.setContent(v3);


        return t;

    }
    //Gets the information to determine a close contact between two people
    private void getCloseContactInfo() {

        String person1 = (comboBox1.getValue());
        String person2 = (comboBox2.getValue());
        String[] words1 = person1.split(" ");
        String[] words2 = person2.split(" ");

        String name1 = (words1[3] + " " + words1[4]);
        String name2 = (words2[3] + " " + words2[4]);
        String s = ("Close Contact: " + name1 + " had close contact with " + name2 + " at the date of " + LocalDate + "\n");
        closecontactsAll.appendText(s);

        try {

            String fileName = ("C:\\Users\\Jamie\\IdeaProjects\\JavaFX\\src\\covidproject\\closecontacts.txt");
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(s);
            fw.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


    //Gets the instances where one person may have been in close contact with someone else and displays it
    public void getCloseContact() {

        String person1 = (comboBox3.getValue());
        String[] words1 = person1.split(" ");

        String name1 = (words1[3] + " " + words1[4]);

        File file = new File("C:\\Users\\Jamie\\IdeaProjects\\JavaFX\\src\\covidproject\\closecontacts.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            while (in.hasNext()) {
                String line = in.nextLine();
                while (!line.contains(name1))
                    if (!line.contains(name1)){
                     line = in.nextLine();

                }
                if (line.contains(name1)) {
                    for (int a = 0; in.hasNextLine() && a < 1; a++) {

                        potentialclosecontacts.appendText("\nThese are the close contacts for " + name1 + " as they have tested positive for COVID-19. \n");
                        potentialclosecontacts.appendText(line + "\n");
                        line = in.nextLine();
                    }

                   return;
                }


            }
        } catch (Exception ignored) {


        }
    }
}







