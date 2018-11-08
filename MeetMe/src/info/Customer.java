package info;
import java.io.*;
import java.util.*;
 public class Customer extends User{
	 Profile user_profile = new Profile();
	 ArrayList<String> matches = new ArrayList<String>();
	 
	 public Customer(String username,String password) throws IOException{
		 this.username = username;
		 this.password = password;
		 File profile = new File("MeetMeDatabase/Profiles/"+username);
		 File matches = new File("MeetMeDatabase/Profiles/" + username + "/Matches");
		 File recieved = new File("MeetMeDatabase/Profiles/" + username + "/Matches/recieved.txt");
		 File sent = new File("MeetMeDatabase/Profiles/" + username + "/Matches/sent.txt");
		 BufferedWriter writer = new BufferedWriter(new FileWriter("MeetMeDatabase/userInfo.txt", true));
		 profile.mkdir();
		 matches.mkdir();
		 try {
			 recieved.createNewFile();
			 sent.createNewFile();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 writer.append(username + " " + password + " customer\n");
		 writer.close();
	 }
	 
	 public void create_profile() {
		 return;
	 }
}
