package in.pentagon.studentapp.dao;

import java.util.ArrayList;

import in.pentagon.studentapp.dto.Student;

public interface StudentDAO {
	//JDBC declaration
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(int id);
	public Student getStudent(String mail, String password);
	public Student getStudent(long phone, String mail);
	public ArrayList<Student>getStudent(String name);		//<student> genrics
	public ArrayList<Student>getStudent();

}
