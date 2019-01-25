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
					choice = input.next();
					//System.out.println(choice);
					if(choice.toLowerCase() == "m") {
						System.out.print("Enter Student ID: ");
						usrID = input.next();
						FileHandler.readFile(database, logfile, usrID);
					}
					else if(choice.toLowerCase() == "e") {
						running = false;
					}
					else {
						//System.out.println("Else");
						pCardStore = choice;
						//System.out.println(pCardStore);
						pCardStore = pCardStore.replace(";", "");
						//System.out.println(pCardStore);
						pCardStore = pCardStore.replace("?", "");
						//System.out.println(pCardStore);
						pCard = Long.parseLong(pCardStore);
						//System.out.println(pCardStore);
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