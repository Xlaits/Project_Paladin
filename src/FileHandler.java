import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.FileWriter;

public class FileHandler {
	
	public static void FileCheck(String filename) {
		File database = new File(filename + ".txt");
		try{
			if(database.exists() == false) {
				System.out.println(filename +" missing, creating file.");
				database.createNewFile();
				
			}
		}
		catch(IOException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		}
	}
	
	public static void writeFile(String filename, String data){
		try {
			BufferedWriter database = new BufferedWriter(new FileWriter(filename + ".txt", true));
			database.write(data);
			database.close();
			System.out.println("Entries added to " + filename + ".txt.");
		}
		catch(IOException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		}
	}
	
	public static void writeFile(String filename, Account account){
		try {
			FileWriter database = new FileWriter(filename + ".txt");
			database.write(account.toString());
			database.close();
			System.out.println("Entries added.");
		}
		catch(IOException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		}
	}
	
	public static void accountCheck(Account account, String filename) {
		//add code here.
	}
	
	public static void readFile(String db, String out, String search) {
		try(BufferedReader br = new BufferedReader(new FileReader(db + ".txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        if(line.contains(search) == true) {
		        	writeFile(out, LocalDateTime.now().toLocalTime() + " " + line + "\n");
		        	break;
		        }
		        else{
		        	Scanner dataEntry = new Scanner(System.in);
		    		Account newUsr = new Account();
		        	System.out.print("Enter Full Name: ");
		    		newUsr.setNameFirst(dataEntry.next());
		    		newUsr.setNameLast(dataEntry.next());
		    		System.out.print("Enter school email: ");
		    		newUsr.setEmail(dataEntry.next());
		    		System.out.print("Enter student ID: ");
		    		newUsr.setStudentID(dataEntry.next());
		    		System.out.print("Swipe PantherCard now (y/n)? ");
		    		String choice = dataEntry.next();
		    		if(choice.toLowerCase() == "y") {
		    			System.out.print("Swipe PantherCard now: ");
		    			String pCardStore = dataEntry.next();
		    			pCardStore = pCardStore.replace(";", "");
						pCardStore = pCardStore.replace("?", "");
						long pCard = Long.parseLong(pCardStore);
		    			newUsr.setPantherCard(pCard);
		    		}
		    		//Add account check here.
		    		writeFile(db, newUsr.toString());
		    		dataEntry.close();
		    		writeFile(out, LocalDateTime.now().toLocalTime() + " " + newUsr.toString());
		        }
		    }
		} catch (FileNotFoundException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		}
	}
	
	public static void readFile(String db, String out, long pCardSearch) {
		try(BufferedReader br = new BufferedReader(new FileReader(db + ".txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        if(line.contains(Long.toString(pCardSearch)) == true) {
		        	writeFile(out, LocalDateTime.now().toLocalTime() + " " + line + "\n");
		        	break;
		        }
		        else {
		        	Scanner dataEntry = new Scanner(System.in);
		    		Account newUsr = new Account();
		        	System.out.print("Enter Full Name (First and Last): ");
		    		newUsr.setNameFirst(dataEntry.next());
		    		newUsr.setNameLast(dataEntry.next());
		    		System.out.print("Enter school email: ");
		    		newUsr.setEmail(dataEntry.next());
		    		System.out.print("Enter student ID: ");
		    		newUsr.setStudentID(dataEntry.next());
		    		newUsr.setPantherCard(pCardSearch);
		    		writeFile(db, newUsr.toString());
		    		dataEntry.close();
		    		writeFile(out, LocalDateTime.now().toLocalTime() +" " + newUsr.toString());
		        }
		    }
		    // line is not visible here.
		} catch (FileNotFoundException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occoured");
			e.printStackTrace();
		}
	}
}