import java.io.File; 
import java.io.IOException;
import java.io.FileWriter;

public class FileHandler {
	
	public static void FileCheck(String filename) {
		File database = new File(filename + ".txt");
		try{
			if(database.exists() == false) {
				database.createNewFile();
			}
		}
		catch(IOException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		}
	}
	

	public static void writeFile(String filename) {
		try {
			FileWriter database = new FileWriter(filename + ".txt");
			database.write("To be added later.");
			database.close();
			System.out.println("Entries added.");
		}
		catch(IOException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		}
	}
}