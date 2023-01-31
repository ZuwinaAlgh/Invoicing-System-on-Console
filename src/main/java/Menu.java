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

	
    System.out.println("Enter User Name:");
    String user=sa.next();
    System.out.println("Enter Password:");
    String pass=sa.next();
    System.out.println("Enter url:");
    String url=sa.next();
    
	    	 
	    	//calling main menu 
		while (mainMenu) {
			for(String m:MainMenu.mainMenuArray()) {
				System.out.println(m);
			}
			
			int option = sa.nextInt();
			switch (option) {
			case 1:
				ShopSetting.ShopSettingMenu(user,pass,url);
				break;

			case 2:
				ManageShopItems.ManageShopMenu(user,pass,url);
				break;
			case 3:
				NewInvoice.createNewInvoice(user,pass,url);
				break;
			case 4:
				ReportInvoice.statisticsReport(user,pass,url);
				break;

			case 5:
				ReportInvoice.reportAllInvoice(user,pass,url);
				break;
			case 6:
				ReportInvoice.searchById(user,pass,url );
				break;
			case 7:
				break;
			case 8:
				System.out.println(" (Are you sure you want to exit? If yes press 0 (program ends), if No press 1 (then main menu reprinted again))");
				option=sa.nextInt();
				if(option==0) {
				mainMenu=false;
				ShopSettingMenu=false;
				ManageShopMenu=false;
				}
				else if(option==1) {
					mainMenu=true;
					ShopSettingMenu=false;
					ManageShopMenu=false;
				}
			
			
			}}}}
 
	

