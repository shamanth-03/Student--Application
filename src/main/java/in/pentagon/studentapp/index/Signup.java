package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc = new Scanner(System.in);
		//Engine e = new Petrol();
		StudentDAO sdao = new StudentDAOImpl();
		//creating POJO class object
		
		Student s = new Student();
		System.out.println("<-----Student Signup----->");
		System.out.println("Enter your name: ");
		s.setName(sc.next());
		System.out.println("Enter your mob number: ");
		s.setPhone(sc.nextLong());
		System.out.println("Enter your EmialId: ");
		s.setMail(sc.next());
		System.out.println("Enter your branch: ");
		s.setBranch(sc.next());
		System.out.println("Enter your Location: ");
		s.setLoc(sc.next());
		System.out.println("Enter your password: ");
		String Password = sc.next();
		System.out.println("Confirm your password: ");
		String ConfirmPassword =  sc.next();
		if(Password.equals(ConfirmPassword)) {
			s.setPassword(ConfirmPassword);
			boolean res = sdao.insertStudent(s);
			if(res) {
				System.out.println("Data added successfully");
			}
			else {
				System.out.println("Failed to create account!");
			}
		}
		else {
			System.out.println("Password Missmatch");
		}
	}

}
