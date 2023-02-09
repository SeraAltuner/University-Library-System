package PersonInheritance;

public class Person {
	protected String nameSurname;
	protected int personId;
	protected String phoneNo;
	protected String email;
	//protected double fee;
	
	public Person() {
		super();
	}


	public Person(String nameSurname, int personId, String phoneNo, String email) {
		super();
		this.nameSurname = nameSurname;
		this.personId = personId;
		this.phoneNo = phoneNo;
		this.email = email;
		//this.fee = fee;
	}

	public String getNameSurname() {
		return nameSurname;
	}


	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nName Surname = " + nameSurname + "\nPersonId = " + personId 
				+ "\nPhoneNo = " + phoneNo + "\nemail="
				+ email;
	}
	
	
}
