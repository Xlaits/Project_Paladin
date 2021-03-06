import java.time.LocalDateTime;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args){
		//Runtime.getRuntime().addShutdownHook(new Thread()){
			LocalDateTime ldt = LocalDateTime.now();
			//System.out.println(ldt);
			Scanner input = new Scanner(System.in);
			String choice = "f", usrID, pCardStore = "NULL";
			long pCard = 0;
			boolean running = true;
			String database = "database";
			String logfile = ldt.toLocalDate().toString() + " logfile";
			//System.out.println(logfile);
			FileHandler.FileCheck(database); // Checking to see if Database exists, if not, create it.
			FileHandler.FileCheck(logfile); // Checking to see if Logfile exists, if not, create it.
		
			try{
				while(running) {
					System.out.print("Please swipe card or m for StudentID entry: ");
					input.reset();
					choice = input.next();
					//System.out.println(choice);
					if(choice.toLowerCase().contains("m") == true) {
						System.out.print("Enter Student ID: ");
						usrID = input.next();
						FileHandler.readFile(database, logfile, usrID);
					}
					else if(choice.toLowerCase().contains("e") == true) {
						running = false;
					}
					else {
						pCardStore = choice;
						pCardStore = pCardStore.replace(";", "");
						pCardStore = pCardStore.replace("?", "");
						pCard = Long.parseLong(pCardStore);
						FileHandler.readFile(database, logfile, pCard);
					}
				}
			}
			finally {
				input.close();
			}
		}
	}
//}