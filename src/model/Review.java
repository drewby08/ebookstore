package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REVIEW database table.
 * 
 */
@Entity
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewid;

	private String description;

	private int stars;

	//bi-directional many-to-one association to Ebook
	@ManyToOne
	@JoinColumn(name="ISBN")
	private Ebook ebook;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;

	public Review() {
	}

	public int getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStars() {
		return this.stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Ebook getEbook() {
		return this.ebook;
	}

	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}