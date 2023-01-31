import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ManageShopItems {
	public static void ManageShopMenu(String user,String pass,String url)throws IOException, InterruptedException{
		boolean mainMenu= true;
		boolean ShopSettingMenu= true;
		boolean ManageShopMenu1=true;
		Scanner sa = new Scanner(System.in);
		while (ManageShopMenu1) {
			for(String x:ManageShopMenu. ManageShopMenuArray()) {
				System.out.println(x);
		}
			
			int option = sa.nextInt();
			switch (option) {
			case 1:
				ManageShopItems.addItems();
				break;

			case 2:
				ManageShopItems.deleteItems();
				break;
			case 3:
				ManageShopItems.ChangeItemPrice();
				break;
			case 4:
				ManageShopItems.ReportAllItems();
				break;
			case 5:
				ManageShopMenu1=false;
				ShopSettingMenu=false;
				mainMenu=false;
			}

		}
	}
	

	 public static void addItems() throws IOException, InterruptedException{
 		
 		 String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
         String user = "sa";
         String pass = "root";
         
         Scanner sa=new Scanner(System.in);
         BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
         
         System.out.println("...Enter ITEMS Details...:");
         System.out.println("...How Many Rows You Want To Add...:");
         int rows=sa.nextInt();
         for(int i=0; i<=rows;i++) {
         System.out.println("Enter Item Name:");
         String Item_Name =bf.readLine();
         System.out.println("Enter Unit price:");
         float Unit_price=sa.nextFloat();
         System.out.println("Enter Quantity:");
         int Quantity=sa.nextInt();
         System.out.println("Enter Quantity Amount:");
         float Quantity_Amount=sa.nextFloat();
         
         
         
         String sql="insert into ITEMS(Item_Name, Unit_price, Quantity, Quantity_Amount)VALUES(?,?,?,?)";
         
         Connection con = null;

         try {

             Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
             DriverManager.registerDriver(driver);

             con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps=con.prepareStatement(sql);
             
             ps.setString(1, Item_Name);
             ps.setFloat(2, Unit_price);
             ps.setInt(3, Quantity);
             ps.setFloat(4, Quantity_Amount);
             ps.executeUpdate();

                 System.out.println( "insert data successfully");
         }

         catch (Exception ex) {
             System.err.println(ex);
         }
         }
	 }
	 
         // delete items
         public static void deleteItems() throws IOException, InterruptedException{
         	
         	String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
             String user = "sa";
             String pass = "root";
             
             Connection con = null;

             try {

                 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                 DriverManager.registerDriver(driver);

                 con = DriverManager.getConnection(url, user, pass);

                 Statement st = con.createStatement();
                
                 Scanner sa=new Scanner(System.in);
             	
            
                 System.out.println("Enter Item id: ");
                 int idinput =sa.nextInt();
                 String sql ="DELETE FROM ITEMS WHERE Item_Id = '"+idinput+"'";
                 ResultSet rs=st.executeQuery(sql);
              
                 
                      
                 }
           
             

             catch (Exception ex) {
                 System.err.println(ex);
             }	}

            //Change Item Price
           public static void ChangeItemPrice() throws IOException, InterruptedException{
              	
            	 String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
                 String user = "sa";
                 String pass = "root";
                 
                 Connection con = null;

                 try {

                     Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                     DriverManager.registerDriver(driver);

                     con = DriverManager.getConnection(url, user, pass);
                     Statement st = con.createStatement();
                    
                     Scanner sa=new Scanner(System.in);
                 	 System.out.println("Enter id: ");
                     int idinput =sa.nextInt();
                     System.out.println("Enter new Unit price :");
                     float Unit_price=sa.nextFloat();
              
                     String sql = "UPDATE ITEMS SET Unit_price = '"+Unit_price+"' WHERE Item_Id = '"+idinput+"'";
                     ResultSet rs=st.executeQuery(sql);
                     
                          
                    
                     }
               
                 

                 catch (Exception ex) {
                     System.err.println(ex);
                 }	}
                
           
                 //Report All Items
        public static void ReportAllItems() throws IOException, InterruptedException{
                   	
        	String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "root";
            
            Connection con = null;

            try {

                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                DriverManager.registerDriver(driver);

                con = DriverManager.getConnection(url, user, pass);

                Statement st = con.createStatement();
               
                Scanner sa=new Scanner(System.in);
            	System.out.println("How many Items you want to read: ");
                int read =sa.nextInt();
                int count=0;
                String sql="select * from ITEMS";
                ResultSet rs=st.executeQuery(sql);
                
                while (rs.next()&&count<=read) {
                	 int Item_Id=rs.getInt("Item_Id");
                     String Item_Name=rs.getString("Item_Name");
                     float Unit_price= rs.getFloat("Unit_price");
                     int Quantity=rs.getInt("Quantity");
                     float Quantity_Amount= rs.getFloat("Quantity_Amount");
                     int Shop_Id=rs.getInt("Shop_Id");
                     System.out.println("...Report Items...");
                     System.out.println("Item_Id:"+Item_Id +" \n "+"Item_Name:"+Item_Name+" \n "+"Unit_price:"+Unit_price+" \n"+"Quantity:"+Quantity+" \n"+"Quantity_Amount:"+Quantity_Amount+"\n " +"Shop_Id:"+Shop_Id );
                     count++;
                     
               
                }}
          
            

            catch (Exception ex) {
                System.err.println(ex);
            }	
    		
    		
                 
                 
             	
     		
     	}   }
	 
       
	 


