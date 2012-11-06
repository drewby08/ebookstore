package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EBOOK database table.
 * 
 */
@Entity
public class Ebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	private String author;

	private String downloadlink;

	private BigDecimal price;

	private String title;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="ebook")
	private List<Review> reviews;

	public Ebook() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDownloadlink() {
		return this.downloadlink;
	}

	public void setDownloadlink(String downloadlink) {
		this.downloadlink = downloadlink;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}