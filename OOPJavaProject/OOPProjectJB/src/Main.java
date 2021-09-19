import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


//Jamie Baggott R00149982

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		{
			// todo see if practice exists in file
			Practice practice = new Practice();

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


			//System objects
			Scanner in = new Scanner(System.in);
			
			//Variables
			boolean running = true;

			String months[] = 
				{
						"Jan","Feb","Mar","Apr","May","Jun",
						"Jul","Aug","Sep","Oct","Nov","Dec"         
				};
			//Create Calendar for display of Date + Time
			Calendar calendar = Calendar.getInstance();

			//Welcome Banner
			System.out.println("==========================================================");
			System.out.println("----------------------------------------------------------");
			System.out.println("\t" + "Welcome To The Hospital Consultancy Application");
			System.out.println("----------------------------------------------------------");
			System.out.println("==========================================================");
			//Date and time function
			System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] 
					+ " " + calendar.get(Calendar.DATE) 
					+ " " + calendar.get(Calendar.YEAR));
			System.out.println("\t\t\t\tTime: " + calendar.get(Calendar.HOUR) 
			+ ":" + calendar.get(Calendar.MINUTE));
			System.out.println("----------------------------------------------------------");

			Consultant consultant1 = new Consultant(
					new Name("Harry", "Walsh"),
					"hw@x.com",
					"812",
					"Cardiology"
			);

			Consultant consultant2 = new Consultant(
					new Name("Adam", "Walsh"),
					"hw@x.com",
					"912",
					"Cancer"
			);

			Patient patient1 = new Patient(
					new Name("Annie",  "Murphy"),
					"hw@x,com",
					"1223",
					"Angina",
					4

			);
			Patient patient2 = new Patient(
					new Name("Danny",  "Murphy"),
					"hw@x,com",
					"7213",
					"Arithmyia",
					2

			);
			Patient patient3 = new Patient(
					new Name("Tommy",  "Murphy"),
					"hw@x,com",
					"3412",
					"Skin",
					4

			);

			Visit visit1 = new Visit("01/12/2020", consultant1, "Initial Consult");
			patient1.addVisit(visit1);

			Visit visit2 = new Visit("01/12/2020", consultant1, "Pacemaker");
			patient1.addVisit(visit2);

			Visit visit3 = new Visit("01/12/2020", consultant1, "ECG Work");
			patient2.addVisit(visit3);

			practice.addConsultant(consultant1);
			practice.addConsultant(consultant2);

			consultant1.addPatient(patient1);
			consultant1.addPatient(patient2);
			consultant2.addPatient(patient3);

			APPLICATION:
				while(running){


					System.out.println("----------------------------------------------------------");

					//Choose an option from menu
					System.out.println("\n\t" + "Select an option from the menu below:" + "\n");

					//List of options
					System.out.println("\t" + "1.	Record a Patient's visit with their Consultant. ");
					System.out.println("\t" + "2.	Display all Patients of a particular Consultant.");
					System.out.println("\t" + "3.	Display all Consultants followed by their Patients followed by their visits.");
					System.out.println("\t" + "4.	Load information on Consultants and Patients. ");
					System.out.println("\t" + "5.	Quit");
					System.out.println("\t" +"----------------------------------------------------------");
					//(EXTRA IF NOT NEEDED)	System.out.println("\t" + "6.	Create a new Consultant");
					//(EXTRA IF NOT NEEDED)	System.out.println("\t" + "7.	Create a new Patient linked to a Consultant");
					//(EXTRA IF NOT NEEDED)	System.out.println("\t" + "8.	Display all visits by a Patient given the Patients name.");

					//Get user input option.
					int userChoice = in.nextInt();
					
					switch (userChoice){

					case 1:{
						System.out.println("Enter Patients ID");
						String patientsId = br.readLine();

						System.out.println("Enter Consultants ID");
						String consultantsId = br.readLine();

						Patient patient = practice.getPatient(patientsId);
						Consultant consultant = practice.getConsultant(patientsId);

						System.out.println("Enter Visit in the format DD/MM/YYYY");
						String date_string = br.readLine();
						Date date = new SimpleDateFormat("dd/MM/yyyy").parse(date_string);

						System.out.println("Enter notes for the visit");
						String note = br.readLine();

						Visit visit = new Visit(date_string, consultant, note );
						patient.addVisit(visit);

						continue APPLICATION;

					}

					case 2:{
						System.out.println("Enter Consultant's First Name");
						String firstName = br.readLine();

						System.out.println("Enter Consultant's Last Name");
						String lastName = br.readLine();

						Name name = new Name(firstName, lastName);
						ArrayList<Consultant> matching = practice.getConsultantsByName(name);

						for (int i = 0; i < matching.size(); i++) {
							Consultant consultant = matching.get(i);
							System.out.println(consultant.toString());

							for (int j = 0; j < consultant.getCollectionOfPatients().size(); j++) {
								Patient patient = consultant.getCollectionOfPatients().get(j);
								System.out.println(patient.toString());
							}
							System.out.println();
						}

						continue APPLICATION;
					}
					case 3:{
						for (int i = 0; i < practice.getCollectionOfConsultants().size(); i++){
							Consultant consultant = practice.getCollectionOfConsultants().get(i);
							System.out.println(consultant.toString());

							for (int j = 0; j < consultant.getCollectionOfPatients().size(); j++){
								Patient patient = consultant.getCollectionOfPatients().get(j);
								System.out.println(patient.toString());

								for (int x = 0; x < patient.getCollectionOfVisits().size(); x++){
									Visit visit_temp = patient.getCollectionOfVisits().get(x);
									System.out.println(visit_temp.toString());
								}
							}
							System.out.println();
						}
						continue APPLICATION;

					}
					case 4:{

								try {
									File myObj = new File("OOPProjectJB/src/Practice.txt");
									Scanner myReader = new Scanner(myObj);
									while (myReader.hasNextLine()) {
										String data = myReader.nextLine();
										System.out.println(data);
									}
									myReader.close();
								} catch (FileNotFoundException e) {
									System.out.println("An error occurred.");
									e.printStackTrace();
								}



						continue APPLICATION;

					}
					case 5:{
						System.out.println("\n" + "----------------------------------------------------------" + "\n");
						
						//Set while(running) to false
						running = false;
						
						//Exit message
						System.out.println("#######################################################");
						System.out.println(" THANKS FOR USING THE HOSPITAL CONSULTANCY APPLICATION");
						System.out.println("#######################################################");

						break;
					}

					/* THESE CASES AREN'T REQUIRED BUT CAN ADD CONSULTANTS AND PATIENTS USING THE USER ITSELF
						IF YOU NEED TO ADD USERS TO TEST OR ANYTHING THESE CAN BE USED OTHERWISE THEY'RE NOT NECESSARY



					case 6:{
						System.out.println("Enter First Name");
						String firstName = br.readLine();

						System.out.println("Enter Last Name");
						String lastName = br.readLine();

						System.out.println("Enter Phone Number");
						String phoneNumber = br.readLine();

						System.out.println("Enter id");
						String id = br.readLine();

						System.out.println("Enter Expertise");
						String expertise = br.readLine();

						Consultant consultant = new Consultant(
								new Name(firstName, lastName),
								phoneNumber,
								id,
								expertise

						);


						practice.addConsultant(consultant);


						continue APPLICATION;
					}
					case 7:{
						System.out.println("Enter First Name");
						String firstName = br.readLine();

						System.out.println("Enter Last Name");
						String lastName = br.readLine();

						System.out.println("Enter Phone Number");
						String phoneNumber = br.readLine();

						System.out.println("Enter ID");
						String id = br.readLine();

						System.out.println("Enter Illness");
						String illness = br.readLine();

						System.out.println("Enter Severity between 1 to 5");
						int severity = Integer.parseInt(br.readLine());

						Patient patient = new Patient(
								new Name(firstName, lastName),
								phoneNumber,
								id,
								illness,
								severity
						);

						System.out.println("Enter Consultants ID");
						String consultant_id = br.readLine();

						Consultant consultant = practice.getConsultant(consultant_id);
						consultant.addPatient(patient);

						continue APPLICATION;

					}



					case 8:{
						System.out.println("Enter First Name");
						String firstName = br.readLine();

						System.out.println("Enter Last Name");
						String lastName = br.readLine();

						Name name = new Name(firstName, lastName);
						ArrayList<Patient> matching = practice.getPatientsByName(name);
						for (int i = 0; i < matching.size(); i++){
							Patient patient = matching.get(i);
							for (int x = 0; x < patient.getCollectionOfVisits().size(); x++){
								Visit visit_temp = patient.getCollectionOfVisits().get(x);
								System.out.println(visit_temp.toString());
							}
						}
						continue APPLICATION;
					}*/




					
					default:{ //Display error message for invalid input
						System.out.println("Invalid command!");
					}

					}

				}
		}
	}

}
