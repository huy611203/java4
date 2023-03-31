package poly.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
	@Id
	Serializable grop;
	long likes;
	Date newest;
	Date oldest;

	public Report(Serializable grop, long likes, Date newest, Date oldest) {
		super();
		this.grop = grop;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}

	public Serializable getGroup() {
		return grop;
	}

	public Serializable getGrop() {
		return grop;
	}

	public void setGrop(Serializable grop) {
		this.grop = grop;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}
