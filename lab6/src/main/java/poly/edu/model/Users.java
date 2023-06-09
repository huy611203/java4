package poly.edu.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private boolean admin;

	private String email;

	private String fullname;

	private String password;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="user")
	private List<Favorites> favorites;

	public Users() {
	}
    
	public Users(String id, boolean admin, String email, String fullname, String password) {
		super();
		this.id = id;
		this.admin = admin;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favorites> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}

	public Favorites addFavorite(Favorites favorite) {
		getFavorites().add(favorite);
		favorite.setUser(this);

		return favorite;
	}

	public Favorites removeFavorite(Favorites favorite) {
		getFavorites().remove(favorite);
		favorite.setUser(null);

		return favorite;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", admin=" + admin + ", email=" + email + ", fullname=" + fullname + ", password="
				+ password + "]";
	}
    
}