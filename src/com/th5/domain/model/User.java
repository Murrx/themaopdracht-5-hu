package com.th5.domain.model;

public class User implements Comparable<User>{
	
	private String email;
	private String password;
	private String displayName;
	private int userId;
	private UserRights rights;

	
	public User(String email){
		this.email = email;
	}
	public User(String email,String password, String displayName, UserRights rights){
		this.email = email;
		this.password = password;
		this.displayName = displayName;
		this.rights = rights;
	}
	public User(int userId, String email, String password, String displayName, UserRights rights){
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.displayName = displayName;
		this.rights = rights;
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
	
	@Override
	public boolean equals(Object obj) {
		User otherUser = (User)obj;
		boolean equals = true;
		equals = equals && email.equals(otherUser.email);
		equals = equals && password.equals(otherUser.password);
		System.out.println(equals);
		return equals;
	}
	@Override
	public int compareTo(User user) {
		return email.compareTo(user.email);
	}
	@Override
	public String toString() {
		return userId+ " " + email + " " + password + " " + displayName + " " + rights;
	}
	public String getDisplayName(){
		return displayName;
	}
	public UserRights getRights(){
		return rights;
	}
}
