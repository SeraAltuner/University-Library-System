	package PersonInheritance;

import java.util.Iterator;

import BookInheritance.Book;

public class UniMember extends Borrower{
	
	public UniMember() {
		super();
	}
	
	public UniMember(String nameSurname, int personId, String phoneNo, String email) {
		super(nameSurname, personId, phoneNo, email);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		
		return "\nUniversity Member\n"+super.toString();
	}

	
	public double calculateFee() {
		double fee = 0;
		demeritP = 2;
		fee = ownedBook.getBookPrice() * demeritP;
		return fee;
		
	}

	@Override
	public int demeritPoint() {
		return 2;
	}
}