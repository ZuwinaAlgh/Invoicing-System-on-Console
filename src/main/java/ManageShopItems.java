import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ManageShopItems {

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
                 }	
             	
     		
     	}   
	 
             }
	 


