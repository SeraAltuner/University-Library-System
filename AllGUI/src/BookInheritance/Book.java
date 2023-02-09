package BookInheritance;

import java.util.Objects;
import java.util.Scanner;

public class Book {
	protected int bookId;
	protected String bookName,genre,author,publishdate;

	public Book() {
		super();
	}
	
	public Book(int bookId, String bookName, String genre, String author, String publishdate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.genre = genre;
		this.author = author;
		this.publishdate = publishdate;
	}

	public void getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Book Name: ");
		bookName = sc.nextLine();
		System.out.println("Enter the author: ");
		author = sc.nextLine();
		System.out.println("Enter the genre: ");
		genre = sc.nextLine();
		System.out.println("Enter the publish date: ");
		publishdate = sc.next();
	}
	
	public boolean checkId(int bookId) {
		if(this.bookId == bookId)
			return true; //book exists
		return false;
	}

	@Override
	public String toString() {
		return "\n\tBookId = " + bookId + 
				"\n\tBook Name = " + bookName + 
				"\n\tGenre = " + genre + 
				"\n\tAuthor = " + author + 
				"\n\tPublish date = " + publishdate + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookId, bookName, genre, publishdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && bookId == other.bookId
				&& Objects.equals(bookName, other.bookName) && Objects.equals(genre, other.genre)
				&& Objects.equals(publishdate, other.publishdate);
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getGenre() {
		return genre;
	}
}
