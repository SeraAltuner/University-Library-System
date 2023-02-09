package PersonInheritance;

public class Employee extends Person{

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String nameSurname, int personId, String phoneNo, String email) {
		super(nameSurname, personId, phoneNo, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  super.toString();
	}
}
