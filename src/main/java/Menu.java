import java.io.IOException;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) throws IOException, InterruptedException {
	boolean menuExit = true;
	Scanner sa = new Scanner(System.in);
	while (menuExit) {
		System.out.println("###WELCOME TO GROCERIES shop SYSTEM###");
		System.out.println("1.Shop Settings");
		System.out.println("2.Manage Shop Items");
		System.out.println("3.Create New Invoice");
		System.out.println("4.Statistics Report");
		System.out.println("5.Report All Invoices ");
		System.out.println("6.Search (1) Invoice");
		System.out.println("7.Program Statistics");
		System.out.println("8.Exit ");
		System.out.println("####################");
		String menu = sa.next();
		int option = Integer.parseInt(menu);
		switch (option) {
		case 1:
			
			break;

		case 2:

			break;
		case 3:
			
			break;
		case 4:
			
			break;

		case 5:
			
			break;
		case 6:

			break;
		case 7:
			break;
		case 8:
			
		}

	}
	menuExit = false;

}

}
