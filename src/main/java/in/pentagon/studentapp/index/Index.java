package in.pentagon.studentapp.index;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("Welcone to MyStudent Application...!");
		
		do {
			System.out.println("1. SIGNUP");
			System.out.println("2. LOGIN");
			System.out.println("3. FORGOT PASSWORD");
			System.out.println("4. EXIT");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: Signup.signup();
			break;
			case 2: LogIn.login();
			break;
			case 3: Password.forgot();
			break;
			case 4: System.out.println("Application closed...!");
			break;
			default: System.out.println("Invalid choice");
			}
		}while(choice!=4);
	}

}
