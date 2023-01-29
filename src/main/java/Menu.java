import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
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
				ShopSetting.insertdata();
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
		mainMenu = false;
		
		//shop menu
		while (ShopSettingMenu) {
			System.out.println("###..........SHOP SETTING..........###");
			System.out.println("###Please choose one option........###");
			System.out.println("1.--ShopMenu--");
			System.out.println("2.--Set Shop Name--");
			System.out.println("3.--Set Invoice Header--");
			System.out.println("4.--Go Back To MAIN MENU--");
			System.out.println("###............THANK YOU............###");
			String ShopSettingMenu1 = sa.next();
			int option = Integer.parseInt(ShopSettingMenu1);
			switch (option) {
			case 1:
				
				break;

			case 2:

				break;
			case 3:
				
				break;
			case 4:
					
			}

		}
		ShopSettingMenu = false;
		
		// MANAGE MENU
		while (ManageShopMenu) {
			System.out.println("###..........MANAGE SHOP..........###");
			System.out.println("###Please choose one option........###");
			System.out.println("1.--Add Items--");
			System.out.println("2.--Delete Items--");
			System.out.println("3.--Change Item Price --");
			System.out.println("4.--Report All Items--");
			System.out.println("5.--Go Back TO MAIN MENU--");
			System.out.println("###............THANK YOU............###");
			String ManageShopMenu1 = sa.next();
			int option = Integer.parseInt(ManageShopMenu1);
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
					
			}

		}
		ManageShopMenu = false;
		
	}
	
	
	
	
	}
    	 
 
	

