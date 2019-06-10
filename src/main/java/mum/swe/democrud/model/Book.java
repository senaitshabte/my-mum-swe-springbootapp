package mum.swe.democrud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookid")
	private int bookId;
	
	private String title;
	private float fee;
	
	@Column(name="datepublished")
	private Date datePublished;
	
	public Book() {
	}
	
	public Book(String title, float fee, Date datePublished) {
		this.title = title;
		this.fee = fee;
		this.datePublished = datePublished;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", fee=" + fee + ", datePublished=" + datePublished
				+ "]";
	}
	
}
