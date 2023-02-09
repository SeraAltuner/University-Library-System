package BookInheritance;

import java.util.Scanner;

public class Hardcopy extends Book{
	private double bookPrice;
	private String locationId;
	
	public Hardcopy() {
		super();
	}
	
	public Hardcopy(int bookId, String bookName, String genre, String author,String publishDate, double bookPrice) {
		super(bookId, bookName,  genre,author, publishDate);
		this.bookPrice = bookPrice;
		locationId = "";
		locationId = locationId.concat(genre);
		String firstletter = bookName.substring(0, 1);
		locationId = locationId.concat(firstletter);
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	public String toString() {
		return  "\n\nHardcopy" + super.toString()
				+ "\tBook Price = " + bookPrice
				+ "\n\tLocation Id = " + locationId;
	}
}
