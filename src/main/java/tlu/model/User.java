package tlu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="`users`")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="userId", scope=User.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID",  nullable = true)
	private long userId;
	
	@Column(name = "USERNAME", length = 30,  nullable = true)
	private String username;
	
	@Column(name = "PASSWORD", length = 100,  nullable = true)
	@JsonIgnore
	private String password;
	
	@Column(name = "FULLNAME", length = 50,  nullable = true)
	private String fullname;
	
	@Column(name = "EMAIL", length = 50,  nullable = true)
	private String email;
	
	@Column(name = "PHONE", length = 15, nullable = true)
	private String phone;
	
	@Column(name = "ROLE", length = 30, nullable = true)
	private String role;
	
	@Column(name= "LOCKED", nullable = true)
	private boolean locked = false;

	
	public User() {	}
	
	public User(String username  ,String password ) {
		this.username=username;
		this.password=password;
	}
	
	

	public User(long userId, String username, String password, String fullname, String email, String phone, String role,
			boolean locked) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.locked = locked;
	}

	public User(String username, String password, String fullname, String email, String phone, String role,
			boolean locked) {
		
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.locked = locked;
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