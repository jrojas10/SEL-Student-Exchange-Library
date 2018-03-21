package models;

public class Book {
	int count = 0;
	int id;
	String name;
	String author;
	int isbn;
	String category;
	
public Book(String name, String author, int isbn, String category) {
	this.id = count++;
	this.name = name;
	this.author = author;
	this.isbn= isbn;
	this.category = category;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
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

public int getIsbn() {
	return isbn;
}

public void setIsbn(int isbn) {
	this.isbn = isbn;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}
}
