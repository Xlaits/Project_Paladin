import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int usrID = 0;
		boolean running = true;
		String database = "database";
		
		//try{
			while(running) {
				System.out.println("Please swipe card: ");
				usrID = input.nextInt();
			}
		//}
			FileHandler.FileCheck(database);
	}

}
