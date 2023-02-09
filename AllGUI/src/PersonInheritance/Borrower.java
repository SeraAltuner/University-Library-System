package PersonInheritance;


import java.util.ArrayList;
import java.util.Scanner;

import BookInheritance.*;
import PersonInterface.PersonInterface;

public abstract class  Borrower extends Person implements PersonInterface{
	
	protected String borrowDate;
	protected static int numOfPeople = 0;
	protected static int demeritP;
	protected static Hardcopy ownedBook = null;
	protected double fee;

	
	public Borrower() {
		super();
		numOfPeople++;
	}
	
	public Borrower(String nameSurname, int personId, String phoneNo, String email) {
		super(nameSurname, personId, phoneNo, email);
		this.borrowDate = borrowDate;
		this.demeritP = demeritP;
		// TODO Auto-generated constructor stub
	}

	public double getFee() {
		return fee;
	}
	

	public void setFee(double fee) {
		this.fee = fee;
	}

	public static void addBook(Hardcopy hc) {
		ownedBook = hc;
	}

	
	public static Hardcopy getOwnedBook() {
		return ownedBook;
	}

	public String toStringWithBook() {
		String book ="\nBorrowed Book Info:\n";
		book += ownedBook.toString();
		return "Borrower"+ super.toString()
				+"\nBorrow Date = "+borrowDate+ book + "\n";
	}
	
	public String toString() { //without book
		return "Borrower"+ super.toString()
				+"\nBorrow Date = "+borrowDate+ "\n";
	}
	
	public abstract double calculateFee();
}
