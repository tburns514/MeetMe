package backend;

import java.io.File;
import java.io.IOException;

public class Driver {

	public static void setUp(){
		File dir = new File("MeetMeDatabase");
		File Profiles = new File("MeetMeDatabase/Profiles");
		
		dir.mkdir();
		Profiles.mkdir();
        System.out.println(dir.getPath());

		return;
	}
	
//	public static boolean setCurrentDirectory(String directory_name) {
//        boolean result = false;  // Boolean indicating whether directory was set
//        File    directory;       // Desired current working directory
//
//        directory = new File(directory_name).getAbsoluteFile();
//        if (directory.exists() || directory.mkdirs())
//        {
//            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
//        }
//        return result;
//	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		setUp();
		Main run = new Main();
		run.run();
	}

}
