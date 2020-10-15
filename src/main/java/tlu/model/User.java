package tlu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`users`")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "USER_NAME", length = 30)
	private String username;
	
	@Column(name = "PASSWORD", length = 100)
	private String password;
	
	@Column(name = "FULLNAME", length = 50)
	private String fullname;
	
	@Column(name = "EMAIL", length = 50)
	private String email;
	
	@Column(name = "PHONE", length = 15)
	private String phone;
	
	@Column(name = "ROLE", length = 30)
	private String role;
	
	@Column(name= "LOCKED")
	private boolean locked = false;

	
	public User() {	}
	
	public User(String username  ,String password ) {
		this.username=username;
		this.password=password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	
}