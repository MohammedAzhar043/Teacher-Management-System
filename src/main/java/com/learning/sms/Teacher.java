package com.learning.sms;

public class Teacher {

	private int id;
	private int age;
	private String name;
	private String subject;
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public Teacher(int id ,int age,String name,String subject) {
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.age = age;
		
	}
	public Teacher() {
		
	}
}
