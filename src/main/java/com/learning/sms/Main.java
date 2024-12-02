package com.learning.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {


		ServicesTeacher obj = new ServicesTeacher();
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("1 for inserting or adding the teacher");
		System.out.println("2 for getting the details of the teacher");
		System.out.println("3 for deleting the row from teacher table");
		System.out.println("4 for updating the row from teacher table");
		System.out.println("5 for getting all the data ");
		System.out.println("6 for exit");
		System.out.println("enter the choice..");
		int choice = Integer.parseInt(buf.readLine());
		int id,age;
		Teacher teacher;
		switch (choice) {
		case 1:
			
			System.out.println("Enter the teacher id:");
			id = Integer.parseInt(buf.readLine());
			System.out.println("Enter the teacher age:");
			age = Integer.parseInt(buf.readLine());
			System.out.println("Enter the teacher name:");
			String name  = buf.readLine();
			System.out.println("Enter the subject name:");
			String subject  = buf.readLine();
			Teacher teach = new Teacher(id,age,name,subject);
			obj.addTeacher(teach);
			
			
			break;

		case 2 : 
		
			System.out.println("Enter the teacher id:");
       		id = Integer.parseInt(buf.readLine());
       		teacher = obj.getTeacherDetails(id);
			System.out.println(teacher.getId() + " " + teacher.getAge() + " " + teacher.getName()+ " "+ teacher.getSubject());
			break;
			
		case 3 :
			
			System.out.println("Enter the teacher id which you want to delete:");			id = Integer.parseInt(buf.readLine());
			teacher = obj.getTeacherDetails(id);
			if(teacher!=null) {
				obj.deleteTeacher(teacher);			}
			else {
				System.out.println("selected id don't exists");
			}
			break;
			
		case 4 :
			
			System.out.println("Enter the teacher id which you want to update:");
			id = Integer.parseInt(buf.readLine());
			teacher = obj.getTeacherDetails(id);
			if(teacher!=null) {
				System.out.println("enter the age ");
				age = Integer.parseInt(buf.readLine());
				System.out.println("Enter the teacher name:");
				name  = buf.readLine();
				System.out.println("Enter the subject name:");
				subject  = buf.readLine();
				teacher = new Teacher(id,age,name,subject);
				obj.updateTeacher(teacher);
			}
			else {
				System.out.println("selected id don't exists");
			}
			break;
			
		case 5:
			List<Teacher> teachers = obj.getAllTeacher();
			for(Teacher t : teachers) {
				System.out.println(t.getId()+ " "+ t.getAge() +" "+ t.getName() + t.getSubject());
			}
			break;
			
		case 6 :
			System.out.println("exiting..");
		break;
		
		default:
			System.out.println("please enter a proper data");
			break;
		}

		
	}

}
