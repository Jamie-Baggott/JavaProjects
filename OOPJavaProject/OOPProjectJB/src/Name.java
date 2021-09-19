//Jamie Baggott R00149982


public class Name{
	//protected , rest of code besides person doesn't need to know to know
	private String firstName;

	private String lastName;

	public Name(){
		this.firstName = "";

		this.lastName = "";
	}

	public Name(String firstName, String lastName){
		this.firstName = firstName;

		this.lastName = lastName;
	}


	public String getFirstName(){
		return this.firstName;
	}

	public String getLastName(){
		return this.lastName;
	}


	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

}