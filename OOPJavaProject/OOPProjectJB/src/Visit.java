import java.util.Date;


//Jamie Baggott R00149982


public class Visit{
	private String date;
	private Consultant consultant;
	private String note;

	public Visit(String date, Consultant consultant, String note) {
		this.date = date;
		this.consultant = consultant;
		this.note = note;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public String getDate() {
		return date;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public void setDate(Date date) {

	}
	public String getNote() {return note; }

	@Override
	public String toString() {
		return  "Visit - " + this.date + " - " + note;
	}
}
