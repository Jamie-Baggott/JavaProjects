//Jamie Baggott R00149982



public class Person{
	//Nested class Name
	//abstract or interface Person?
	private Name name;
	private String phone;
	private String id;

	public Person(){
		this.name = new Name();
		this.phone = "";
		this.id = "";
	}

	public Person(Name name, String phone, String id){
		this.name = name;
		this.phone = phone;
		this.id = id;

	}

	public Name getName(){
		return this.name;
	}
	public String getPhone(){
		return this.phone;
	}
	public String getId(){
		return this.id;
	}
	public void setName(Name name){
		this.name = name;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setId(String id){
		this.id = id;
	}



}