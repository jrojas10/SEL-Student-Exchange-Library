package models;

import java.sql.Date;

public class BookTable {
	String title;
	String price;
	Date postDate;
	Date expDate;
	
	public BookTable (String title, String price, Date postDate, Date expDate) {
		this.title = title;
		this.price = price;
		this.postDate = postDate;
		this.expDate = expDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
}
