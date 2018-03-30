package models;

public class Book {

	int id;
	double price;
	String title;
	String isbn;
	String authorFirst;
	String authorLast;
	String subject;
	String course;
	String state;

	public Book(int id, double price, String title, String isbn, String authorFirst, String authorLast, String subject,
			String course, String state) {

		this.id = id;
		this.price = price;
		this.title = title;
		this.isbn = isbn;
		this.authorFirst = authorFirst;
		this.authorLast = authorLast;
		this.subject = subject;
		this.course = course;
		this.state = state;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorFirst() {
		return authorFirst;
	}

	public void setAuthorFirst(String authorFirst) {
		this.authorFirst = authorFirst;
	}

	public String getAuthorLast() {
		return authorLast;
	}

	public void setAuthorLast(String authorLast) {
		this.authorLast = authorLast;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
