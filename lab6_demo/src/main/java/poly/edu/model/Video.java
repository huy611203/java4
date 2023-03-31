package poly.edu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Videos")
public class Video {
    @Id
    String id;
    String title;
    String poster;
    String description;
    Integer views = 0;
    Boolean active = true;
    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
    List<Favorites> favorites;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<Favorites> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}
	public Video(String id, String title, String poster, String description, Integer views, Boolean active,
			List<Favorites> favorites) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.description = description;
		this.views = views;
		this.active = active;
		this.favorites = favorites;
	}
    
}