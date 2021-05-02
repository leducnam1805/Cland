package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {

	private int id;
	
	@NotEmpty
	@Length(min = 4, max = 255)
	private String username;
	
	@NotEmpty
	private String fullname;
	
	private String remember_token;
	
	@NotEmpty
	private String password;
	
	private Roles role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRemember_token() {
		return remember_token;
	}

	public void setRemember_token(String remember_token) {
		this.remember_token = remember_token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public User(int id, @NotEmpty @Length(min = 4, max = 255) String username, @NotEmpty String fullname,
			String remember_token, @NotEmpty String password, Roles role) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.remember_token = remember_token;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

}
