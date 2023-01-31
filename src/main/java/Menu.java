import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu{
	public static void main(String[] args)throws IOException, InterruptedException{
	boolean mainMenu= true;
	boolean ShopSettingMenu= true;
	boolean ManageShopMenu= true;
	Scanner sa = new Scanner(System.in);
	
	
	
	//Main menu
	
		while (mainMenu) {
			System.out.println("###WELCOME TO GROCERIES shop SYSTEM###");
			System.out.println("###Please choose one option........###");
			System.out.println("1.--Shop Settings--");
			System.out.println("2.--Manage Shop Items--");
			System.out.println("3.--Create New Invoice--");
			System.out.println("4.--Statistics Report--");
			System.out.println("5.--Report All Invoices--");
			System.out.println("6.--Search One Invoice--");
			System.out.println("7.--Program Statistics--");
			System.out.println("8.--Exit--");
			System.out.println("###............THANK YOU............###");
			String menu = sa.next();
			int option = Integer.parseInt(menu);
			switch (option) {
			case 1:
				ShopSetting.ShopSettingMenu();
				break;

			case 2:
				ManageShopItems.ManageShopMenu();
				break;
			case 3:
				NewInvoice.createNewInvoice();
				break;
			case 4:
				ReportInvoice.statisticsReport();
				break;

			case 5:
				ReportInvoice.reportAllInvoice();
				break;
			case 6:
				ReportInvoice.searchById();
				break;
			case 7:
				break;
			case 8:
				mainMenu=false;
				ShopSettingMenu=false;
				ManageShopMenu=false;
			}

		}
	
	}}
    	 
 
	

