package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table (name = "Users")
public class Users {
	@Id
	private String id;
	private String password;
	private String fullname;
	private String email;
	private boolean admin;

	public Users() {
		super();
	}

	public Users(String id, String password, String fullname, String email, boolean admin) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
