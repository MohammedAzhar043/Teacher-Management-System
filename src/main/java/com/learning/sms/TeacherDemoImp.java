package com.learning.sms;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDemoImp implements TeacherDemo {

	private final String url = "jdbc:mysql://localhost:3306/azhar";
	private final String name ="root";
	private final String password ="root";
	private  Connection con;
	
	public  TeacherDemoImp() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Teacher getTeacherDetails(int  id) {
		
		Teacher teacher = null;
		try {
			String sql = "select * from Teacher where id ="+id;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				teacher = new Teacher(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		return teacher;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		try {
			String sql = "insert into teacher(id,age,name,subject) values (?,?,?,?)";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1, teacher.getId());
			pr.setInt(2, teacher.getAge());
			pr.setString(3, teacher.getName());
			pr.setString(4, teacher.getSubject());
			
			int row = pr.executeUpdate();
			System.out.println(row +" no of rows inserted");
			pr.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
	
		try {
			String sql = "delete from teacher where id =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, teacher.getId());
			int row =st.executeUpdate();
			System.out.println(row +" no of row's deleted");
			st.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		try {
			String sql = "update teacher set age=?,name=?,subject=? where id =?";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1, teacher.getAge());
			pr.setString(2, teacher.getName());
			pr.setString(3, teacher.getSubject());
			pr.setInt(4, teacher.getId());
			int row = pr.executeUpdate();
			System.out.println(row +" no of row updated");
			pr.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Teacher> getAllTeacher() {
		Teacher teacher = null;
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			String sql = "select * from teacher";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				teacher = new Teacher(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4)
						);
				teachers.add(teacher);
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return teachers;
	}

}
