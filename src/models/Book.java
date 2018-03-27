package models;

public class Book {

	int id;
	String name;
	String author;
	String isbn;
	String category;
	String course;
	String condition;
	int price;
	

	public Book(int id, String name, String author, String isbn, String category, String condition, String course, int price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.isbn = isbn;
		this.category = category;
		this.condition = condition;
		this.course = course;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
