//Jamie Baggott R00149982


import java.util.ArrayList;

public class Practice{
	ArrayList<Consultant> collectionOfConsultants = new ArrayList<Consultant>();

	public Practice(){

	}

	public Practice(ArrayList<Consultant> collectionOfConsultants){
		this.collectionOfConsultants = collectionOfConsultants;
	}

	//Getters
	public ArrayList<Consultant> getCollectionOfConsultants(){

		return this.collectionOfConsultants;
	}
	//Setters
	public void setCollectionOfConsultants(ArrayList<Consultant> collectionOfConsultants){
		this.collectionOfConsultants = collectionOfConsultants;
	}

	public void addConsultant(Consultant consultant){
		this.collectionOfConsultants.add(consultant);
	}

	public void removeConsultant(String phone_number){
		// phone number for removing consultant as it is unique
		for (int i = 0; i < this.getCollectionOfConsultants().size(); i++){
			if (this.getCollectionOfConsultants().get(i).getPhone().equals(phone_number)){
				this.collectionOfConsultants.remove(i);
				break;
			}
		}

	}

	public Consultant getConsultant(String id){
		for (int i = 0; i < this.getCollectionOfConsultants().size(); i++){
			if (this.getCollectionOfConsultants().get(i).getId().equals(id)){
				return this.getCollectionOfConsultants().get(i);
			}
		}
		return null;
	}

	public Patient getPatient(String id){
		for (int i = 0; i < this.getCollectionOfConsultants().size(); i++){
			Consultant consultant = this.getCollectionOfConsultants().get(i);

			for (int j = 0; j < consultant.getCollectionOfPatients().size(); j++){
				if (consultant.getCollectionOfPatients().get(j).getId().equals(id)){
					return consultant.getCollectionOfPatients().get(j);
				}

			}
		}
		return null;
	}

	public ArrayList<Patient> getPatientsByName(Name name){
		/*
		Creates an empty array list of patients

		Searches through all the patients. If a patient matches the name given then it is added to the matching arrayList

		At the end the matching ArrayList is returned
		 */
		ArrayList<Patient> matching = new ArrayList<Patient>();

		for (int i = 0; i < this.getCollectionOfConsultants().size(); i++){
			Consultant consultant = this.getCollectionOfConsultants().get(i);

			for (int j = 0; j < consultant.getCollectionOfPatients().size(); j++){
				Patient tempPatient = consultant.getCollectionOfPatients().get(j);
				Name patientName = tempPatient.getName();
				if (name.getFirstName().equals(patientName.getFirstName()) &&

						name.getLastName().equals(patientName.getLastName())){

					matching.add(tempPatient);
				}

			}
		}
		return matching;
	}

	public ArrayList<Consultant> getConsultantsByName(Name name){
		/*
		Creates an empty array list of patients

		Searches through all the patients. If a patient matches the name given then it is added to the matching arrayList

		At the end the matching ArrayList is returned
		 */
		ArrayList<Consultant> matching = new ArrayList<Consultant>();

		for (int i = 0; i < this.getCollectionOfConsultants().size(); i++){
			Consultant consultant = this.getCollectionOfConsultants().get(i);
			Name consultantName = consultant.getName();

				if (name.getFirstName().equals(consultantName.getFirstName()) &&

						name.getLastName().equals(consultantName.getLastName())){

					matching.add(consultant);
				}

		}
		return matching;
	}
}