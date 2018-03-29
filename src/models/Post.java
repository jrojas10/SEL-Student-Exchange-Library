package models;

import java.sql.Date;

public class Post {
int id;
Date postDate;
int userId;
int bookId;
Date expDate;

public Post(int id, Date postDate, int userId,int bookId, Date expDate) {
	this.id= id;
	this.postDate = postDate;
	this.userId = userId;
	this.expDate = expDate;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getPostDate() {
	return postDate;
}

public void setPostDate(Date postDate) {
	this.postDate = postDate;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getBookId() {
	return bookId;
}

public void setBookId(int bookId) {
	this.bookId = bookId;
}

public Date getExpDate() {
	return expDate;
}

public void setExpDate(Date expDate) {
	this.expDate = expDate;
}
}
