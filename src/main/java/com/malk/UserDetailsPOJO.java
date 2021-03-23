package com.malk;

public class UserDetailsPOJO {

	
	
	private String Name;
	
	private int Age;
	private String Place;
	private String Email;
	private String Address;
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "UserDetailsPOJO [Name=" + Name + ", Age=" + Age + ", Place=" + Place + ", Email=" + Email + ", Address="
				+ Address + "]";
	}
	
}
