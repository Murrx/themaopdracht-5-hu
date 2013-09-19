package com.th5.domain.model;

public class User implements Comparable<User>{
	
	private String username;
	private String password;
	
	public User(String username){
		this.username = username;
	}
	public User(String username,String password){
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		System.out.println(!(obj instanceof User));
		User otherUser = (User)obj;
		boolean equals = true;
		equals = equals && username.equals(otherUser.username);
		equals = equals && password.equals(otherUser.password);
		System.out.println(equals);
		return equals;
	}
	@Override
	public int compareTo(User user) {
		return username.compareTo(user.username);
	}
	@Override
	public String toString() {
		return username;
	}
}
