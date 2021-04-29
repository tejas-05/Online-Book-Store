package com.app.pojo;

import java.io.InputStream;

public class Book {

	private int bookId,bookPrice,noOfCopies;
	private String bookName,bookCategory,authorName,rating;
	private InputStream bookImage;
	
	public Book() {
		
	}
	
	public Book(int bookId, int bookPrice, int noOfCopies, String rating, String bookName, String bookCategory,
			String authorName, InputStream bookImage) {
		super();
		this.bookId = bookId;
		this.bookPrice = bookPrice;
		this.noOfCopies = noOfCopies;
		this.rating = rating;
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.authorName = authorName;
		this.bookImage = bookImage;
	}

	public Book(int bookPrice, int noOfCopies, String bookName, String bookCategory, String authorName, String rating,
			InputStream bookImage) {
		super();
		this.bookPrice = bookPrice;
		this.noOfCopies = noOfCopies;
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.authorName = authorName;
		this.rating = rating;
		this.bookImage = bookImage;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public InputStream getBookImage() {
		return bookImage;
	}

	public void setBookImage(InputStream bookImage) {
		this.bookImage = bookImage;
	}

	@Override
	public String toString() {
		return "Book [bookPrice=" + bookPrice + ", noOfCopies=" + noOfCopies + ", bookName=" + bookName
				+ ", bookCategory=" + bookCategory + ", authorName=" + authorName + ", rating=" + rating + "]";
	}
	
	
}
