import java.util.ArrayList;
import java.util.Date;


//Jamie Baggott R00149982

class Patient extends Person{
	private String illness;
	private Integer severity;
	private ArrayList<Visit> collectionOfVisits = new ArrayList<Visit>();

	public Patient(Name name, String phone, String id, String illness, int severity){
		super(name, phone , id);

		if ( severity < 1){
			System.out.println("Severity is too low");
			System.out.println("Severity set to 1");
			severity = 1;
		} else if( severity > 5){
			System.out.println("Severity is too high");
			System.out.println("severity set to 5");
			severity = 5;
		}

		this.illness = illness;
		this.severity = severity;


	}
	//Getters
	public String getIllness(){
		return this.illness;
	}

	public int getSeverity(){
		return this.severity;
	}

	public ArrayList<Visit> getCollectionOfVisits(){
		return this.collectionOfVisits;
	}
	//Setters
	public void setIllness(String illness){
		this.illness = illness;
	}

	public void setSeverity(int severity){
		this.severity = severity;
	}

	public void setCollectionOfVisits(ArrayList<Visit> collectionOfVisits){
		this.collectionOfVisits = collectionOfVisits;
	}

	public void addVisit(Visit visit){
		this.collectionOfVisits.add(visit);
	}

	public void removeVisit(Date date){
		for (int i = 0; i < this.getCollectionOfVisits().size(); i++){

				this.collectionOfVisits.remove(i);
				break;
			}
		}


	@Override
	public String toString() {
		return "Patient - " + this.getName().toString() + ". Illness - " + this.getIllness() +  ". Severity - " + this.getSeverity();
	}
}