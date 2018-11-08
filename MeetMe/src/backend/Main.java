package backend;
import info.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


//This contains the main processes of the program, the driver is simply going to run this, it may also create profiles depending
//on how we decide to test the processes
public class Main {
	public String filePath = "";
	private HashMap<String,ArrayList<String>> user_map = new HashMap<>();

	public Main() {
//		Scanner getFile = new Scanner(System.in);
//		System.out.println("Enter Full File Path for the MeetMe DataBase (Enter Desired Path if The DataBase Doesn't Exsist");
//		filePath = getFile.nextLine();
//		getFile.close();
		File users = new File("MeetMeDatabase/userInfo.txt");
		if (!users.exists()) {
			try{
				users.createNewFile();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
	//login
	public String login(String username, String password) throws IOException {
		if (user_map.containsKey(username)){
			if (user_map.get(username).get(0) == password){
				return user_map.get(username).get(1);
			}
			else {
				System.out.println("Incorrect Password for user "+ username);
			}
		}
		else {
			String answer = "";
			Scanner textscan = new Scanner(System.in);
			while (!answer.equals("no") && !answer.equals("yes") && !answer.equals("admimn")) {
				System.out.println("User name does not exsist, would you like to create an accout?");
				answer = textscan.next();
			}
			if (answer.equals("yes")) {
				create_customer(username,password);
				textscan.close();
				return "customer";
			}
			else if (answer.equals("admin")) {
				create_admin();
				textscan.close();
				return "administrator";
			}
			textscan.close();
		}
		
		return "error";
	}
	
	
	//running program
	public void run() throws IOException {
		//user login
		Scanner textscan = new Scanner(System.in);
		String username = "";
		String password = "";
		String permission = "error";
		
		while (permission.equals("error")){
			System.out.println("Enter Username:\nEnter Password:");
			username = textscan.nextLine();
			password = textscan.nextLine();
			permission = login(username,password);
		}
		
		if (permission == "customer") {
			run_customer(username);
		}
		else if(permission == "administrator") {
			run_admin(username);
		}
		textscan.close();
		return;
	}
	
	public void run_customer(String username) {
		//put screen to profile queue for the username
		//allow them to go to settings
		//allow them to go to matches
			//allow them to message
		return;
	}
	
	public void run_admin(String username) {
		return;
	}
	
	public void create_customer(String new_username, String password) throws IOException {
		Scanner textscan = new Scanner(System.in);
		boolean username_exsists = true;
		//because the username has to not exsist for the code to get here we don't need to recheck
		//however eventually you will be able to create an account at the same time meaning you could use an already exsisting username
		//therefore this is necessary
//		while (username_exsists) {
//			System.out.println("Enter desired username");
//			new_username = textscan.nextLine();
//			if (!user_map.containsKey(new_username)) {
//				username_exsists = false;
//			}
//			else {
//				System.out.println("Username taken");
//			}
//		}
		while(!check_password(password)) {
				System.out.println("Enter Password");
				password = textscan.nextLine();
		}

		Customer new_customer = new Customer(new_username,password);
		new_customer.create_profile();
		textscan.close();
	}
	public boolean check_password(String password) {
		boolean password_criteria = false;	
		if (password.length() < 8) {
			System.out.println("Password needs to be at least 8 characters");
			System.out.println("Please enter a new password");
		}
		else {
			for (char cx:password.toCharArray()) {
				if (Character.isDigit(cx)) {
					password_criteria = true;
				}
				else if(!Character.isAlphabetic(cx)){
					password_criteria = false;
					break;
				}
			}
		}
		if(!password_criteria) {

			System.out.println("Password must contain a number.\nPassword can only be a letter/number");
		}
		return password_criteria;
	}
	
	public void create_admin() {
		return;
	}
	
	
	
	
	
}
