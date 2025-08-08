package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {
	
	public static void forgot() {
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAOImpl();
		System.out.println("<----Forgot Password---->");
		System.out.println("Enter your Phone number: ");
		long phone = sc.nextLong();
		System.out.println("Enter your EmailId: ");
		String mail = sc.next();
		Student a = sdao.getStudent(phone,mail);
		if(a!=null) {
			System.out.println("Enter the new password: ");
			String password = sc.next();
			
			System.out.println("Confirn your Password: ");
			String confirm = sc.next();
				if(password.equals(confirm)) {
					a.setPassword(password);
					boolean res = sdao.updateStudent(a);
					
					if(res) {
						System.out.println("Password resetted successfully.");
					}
					else {
						System.out.println("Failed to reset the password..!");
					}
					
				}
				else {
					System.out.println("Password mismatch");
				}
		}
		else {
			System.out.println("Invalid phone number or mail Id");
		}
		
			
}
		
	
	
	public static void reset(Student s) {
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAOImpl();
		System.out.println("<----Reset Password---->");
		System.out.println("Enter your Phone number: ");
		long phone = sc.nextLong();
		System.out.println("Enter your EmailId: ");
		String mail = sc.next();
		
		if(s.getPhone()==phone && s.getMail().equals(mail))
		{
		System.out.println("Enter the new password: ");
		String password = sc.next();
		
		System.out.println("Confirn your Password: ");
		String confirm = sc.next();
			if(password.equals(confirm)) {
				s.setPassword(password);
				boolean res = sdao.updateStudent(s);
				
				if(res) {
					System.out.println("Password resetted successfully.");
				}
				else {
					System.out.println("Failed to reset the password..!");
				}
				
			}
			else {
				System.out.println("Password mismatch");
			}
		
		}
		else {
			System.out.println("Invalid phone number or mail Id");
		}
		
		
		
	}
}
