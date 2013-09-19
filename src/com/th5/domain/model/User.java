package com.th5.domain.model;

public class User implements Comparable<User>{
	
	private String email;
	private String password;
	
	public User(String email){
		this.email = email;
	}
	public User(String email,String password){
		this.email = email;
		this.password = password;
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
		
		System.out.println(!(obj instanceof User));
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
		return email;
	}
}
