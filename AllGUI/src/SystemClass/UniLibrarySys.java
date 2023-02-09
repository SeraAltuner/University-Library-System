package SystemClass;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


import BookInheritance.*;
import PersonInheritance.*;

public class UniLibrarySys {
	public static Set<Book> bookSet = new HashSet();
	public static ArrayList<Borrower> personList = new  ArrayList();
	public static ArrayList<Employee> employeeList = new ArrayList();
	
	public static boolean checkPersonId(int id) { //returns true if id already exists 
		for(int i = 0; i < personList.size(); i++) {
			if(personList.get(i).getPersonId() == id)
				return true;
		}
		return false;
	}
	
	public static String displayFee(int id) {
		double fee = 0;
		for(int i=0;i<personList.size();i++) {
			if(personList.get(i).getPersonId() == id)
				fee = personList.get(i).calculateFee();
		}
		return fee +"";
	}
	
	public static void addPerson(String nameSurname, int personId, String borrowDate, String phoneNo, String email, String memberType) {
		Borrower p;
		//double fee= PersonInheritance.Borrower.calculateFee();
		//double fee;
			if(memberType.equalsIgnoreCase("Guest")) {
				personId = generateGuestId();
				//fee = Guest.calculateFee();
				//we generate random id for Guests because they aren't registered in the university so we cannot keep track of them
				while(checkPersonId(personId)) {
					personId = generateGuestId();
				}
				p = new Guest(nameSurname, personId, phoneNo, email);
				personList.add(p);
				
			}else if (memberType.equalsIgnoreCase("UniMember")) {
				//we don't generate a UniMember id because they already have a registered id in the university as student or employee
				p = new UniMember(nameSurname, personId, phoneNo, email);
				personList.add(p);
			}else
				System.out.println("Member type does not exist!"); //we won't include this message in GUI 
		}
	
	public static Book searchBook(int bookId) {
		Iterator<Book> it = bookSet.iterator();
		while(it.hasNext()) {
			Book b = it.next();
			if(b.getBookId() == bookId) {
				return b;
			}
		}
		return null;
	}
	
	
	
	public static boolean readBookFromFile() {
		Scanner sc = null;
		int bookId;
		String bookName, author, genre, publishDate;
		Book b;
		File file1 = new File("Books.txt");
		
		try {
			sc = new Scanner(file1);
			while (sc.hasNext()) {
				String str = sc.nextLine();
				String[] newStr = str.split("\\,");
				String type = newStr[0];
	            bookName = newStr[1];
	            genre = newStr[2];
	            author = newStr[3];
	            publishDate = newStr[4];
	            int id = generateBookId(); 
	            
	            if(type.equalsIgnoreCase("hardcopy")) {
	            	double bookPrice = Double.parseDouble(newStr[5]);
	            	b = new Hardcopy(id, bookName, author, genre, publishDate, bookPrice);
	            }
	            else
	            	b = new Electronic(id,bookName,genre,author,publishDate);
	            
	            bookSet.add(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        
		sc.close(); 
		return true;
		
	}
	
	public static void readEmployeeFromFile() {
		Scanner sc = null;
		String nameSurname, phoneNo, email;
		int personId ;
		Employee emp;
		File file2 = new File("Employee.txt");
		
		try {
			sc = new Scanner(file2);
			while (sc.hasNext()) {
				String str = sc.nextLine();
				String[] newStr = str.split("\\,");
				nameSurname= newStr[0];
	            personId = Integer.parseInt(newStr[1]);
	            phoneNo = newStr[2];
	            email = newStr[3];
	            int id = generateBookId();
	            //double fee = PersonInheritance.Borrower.calculateFee();
	            emp = new Employee(nameSurname, personId, phoneNo, email);
	            employeeList.add(emp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		sc.close(); 
		
	}
	
	public static boolean checkEmployeeId(int id) { 
		for(Employee emp:employeeList) {
			if(id == emp.getPersonId())
				return true; //if the id exists in employeeList, employee will be able to login
		}
		return false;
	}
	
	
	public static boolean removePerson(int personId) {
		for(int i = 0; i < personList.size(); i++) {
			if(personList.get(i).getPersonId()==personId)
				personList.remove(i);
				return true;
		}
		return false;
	}
	
	public static String displayPerson() {
		String out = "University Library System\n";
		for(int i = 0 ; i < personList.size(); i++) {
			out += personList.get(i).toString();
		}
		return out;
	}
	
	public static String displayPersonWithBook() {
		String out = "University Library System\n";
		for(int i = 0 ; i < personList.size(); i++) {
			out += personList.get(i).toStringWithBook();
		}
		return out;
	}
	
	public static String displaySelectedBorrower(int id) {
		String out = null;
		for(int i = 0 ; i < personList.size(); i++) {
			if(personList.get(i).getPersonId()==id)
				out = personList.get(i).toString();
		}
		return out;
	}
	
	public static String displayBook(){
		String out = "";
		for(Book b:bookSet) {
			out += b.toString();
		}
		return out;
	}
	
	public static String displaySelectedBook(int bookId) {
		String out = "";
		for(Book b:bookSet) {
			if(b.getBookId() == bookId) {
				out += b.toString();
			}
		}
		return out;
	}
	
	public static int generateBookId() {
		int randomId = (int) (Math.random() * 150);
		Iterator<Book> it = bookSet.iterator();
		while(it.hasNext()) { 
			Book b = it.next();
			while(b.checkId(randomId)) {
				randomId = (int) (Math.random() * 150);
			}
		}
		return randomId;
	} 
	
	public static int generateGuestId() {
		int randomId = (int) (Math.random() * 150)+100;
		Iterator<Borrower> it = personList.iterator();
		while(it.hasNext()) {  
			Borrower p = it.next();
			while(p.getPersonId() == randomId) {
				randomId = (int) (Math.random() * 150);
			}
		}
		return randomId;
	} 
	
	public static Hardcopy getHardcopy(int bookId) {
		Iterator<Book> it = bookSet.iterator();
		while(it.hasNext()) {
			Book b = it.next();
			if(b instanceof Hardcopy && b.getBookId() == bookId) {
				return (Hardcopy) b;
			}
		}
		return null;
	}
	
	public static void addOwnedBook(int bookId) {
		
		Borrower.addBook(getHardcopy(bookId));
		

	}
	
	public static ArrayList employeeId() {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i = 0; i<employeeList.size();i++) {
			res.add(employeeList.get(i).getPersonId());
		}
		
		return res;
	}
}
