public class Account {
	String nameFirst, nameLast, studentID, email;
	long pantherCard;
	
	Account(){
		this.nameFirst = "NULL";
		this.nameLast = "NULL";
		this.studentID = "NULL";
		this.email = "NULL";
		this.pantherCard = 0;
	}
	
	Account(String nameFirst, String nameLast, String studentID, String email, long pantherCard){
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.studentID = studentID;
		this.email = email;
		this.pantherCard = pantherCard;
	}
	
	Account(String nameFirst, String nameLast, String studentID, String email){
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.studentID = studentID;
		this.email = email;
		this.pantherCard = 0;
	}
	
	public String toString() {
		return this.nameLast + ", " + this.nameFirst + ": "+ this.email + ", " + this.studentID + ", " + this.pantherCard + "\n";
	}
	
	//Getters and Setters
	public String getNameFirst() {
		return nameFirst;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public long getPantherCard() {
		return pantherCard;
	}

	public void setPantherCard(long pantherCard) {
		this.pantherCard = pantherCard;
	}
	
}
