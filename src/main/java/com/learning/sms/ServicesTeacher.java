package com.learning.sms;

import java.util.List;

public class ServicesTeacher {
	
	private final TeacherDemo std;
	
	public  ServicesTeacher(){
		this.std = new TeacherDemoImp();
	}
	
	public Teacher getTeacherDetails(int id) {
	 return std.getTeacherDetails(id);
	}

	public void addTeacher(Teacher teacher) {
		std.addTeacher(teacher);
	}
	public void deleteTeacher(Teacher teacher) {
		std.deleteTeacher(teacher);
	}
	
	public void updateTeacher(Teacher teacher) {
		std.updateTeacher(teacher);
	}
	List<Teacher> getAllTeacher(){
		return std.getAllTeacher();
	}
}
