package in.pentagon.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;
import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class LogIn {
	public static void login() {
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAOImpl();
		int choice = 0;
		System.out.println("<------------Login Page---------->");
		System.out.println("Enter your MailId: ");
		String mail = sc.next();
		System.out.println("Enter your Password: ");
		String pass = sc.next();
		Student a = sdao.getStudent(mail,pass);
		if(a!=null) {
			System.out.println("Login Successful: Welcone!! "+a.getName());
			do {
				System.out.println("1. View Data");
				System.out.println("2. Search user");
				System.out.println("3.Update account");
				System.out.println("4. Reset password");
				System.out.println("5. Back to main menu");
				if(a.getId()==2) {
					System.out.println("6. View all Users");
					System.out.println("7. Delete all users");
				}
				choice = sc.nextInt();
				switch(choice) {
				case 1: System.out.println(a);
				break;
				case 2: //search user logic
					System.out.println("Enter the student name to search:");
					String name = sc.next();
					ArrayList<Student> students = sdao.getStudent(name);
					if(!students.isEmpty()) {
						for(Student sl : students) {
							//System.out.println(sl);
							System.out.println("Student ID: "+sl.getId());
							System.out.println("Student Name: "+sl.getName());
							System.out.println("Student Branch: "+sl.getBranch());
							System.out.println("Student Location: "+sl.getLoc());
						}
					}else {
						System.out.println("No such user present...!");
					}
				break;
				case 3: Update.update(a);
				break;
				case 4: Password.reset(a);
				break;
				case 5: System.out.println("Going back to menu");
				break;
				case 6: System.out.println("Our users...");
						ArrayList<Student> StudentList =sdao.getStudent();
						for(Student s1 : StudentList) {
							System.out.println(s1);
						}
				break;
				case 7: //delete all user logic
					System.out.println("Enter the Student Id to delete:");
					boolean deleteCheck = sdao.deleteStudent(sc.nextInt());
					if(deleteCheck) {
						System.out.println("Deleted the data successfully.");
					}
					else {
						System.out.println("Unable to delete...!,No such Id present...!");
					}
				break;
				default: System.out.println("wrong choice");
				break;
				}
			}while(choice !=5);
		}
		else {
			System.out.println("Failed to login!");
		}
	}

}
