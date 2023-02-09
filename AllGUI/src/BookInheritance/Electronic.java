package BookInheritance;


public class Electronic extends Book{
	private String link;
	
	public Electronic() {
		super();
	}
	
	public Electronic(int bookId, String bookName,  String genre,String author, String publishDate) {
		super(bookId, bookName,  genre, author,publishDate);
		String name;
		name = super.getBookName();
		link = "www.ourunilibrary.com/";
		link += name; 
	}
	
	public void getInput() {
		super.getInput();
	}
	
	public String getLink() {
		return link;
	}

	public String toString() {
		return "\n\nElectronic" + super.toString() 
		+"\nLink = "+ link.toString();
	}
	
}
