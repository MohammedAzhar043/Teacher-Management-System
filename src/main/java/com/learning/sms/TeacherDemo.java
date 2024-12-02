package com.learning.sms;

import java.util.List;

public interface TeacherDemo {

	public Teacher getTeacherDetails(int id);
	public void addTeacher(Teacher teacher);
	public void deleteTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
	List<Teacher> getAllTeacher();
}