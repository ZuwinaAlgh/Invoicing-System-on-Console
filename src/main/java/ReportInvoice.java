import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReportInvoice {
	public static void statisticsReport(String user,String pass,String url) throws IOException, InterruptedException {

    Connection con = null;

    try {

        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        DriverManager.registerDriver(driver);

        con = DriverManager.getConnection(url, user, pass);

        Statement st = con.createStatement();
       
    
        String sql="select SUM (Number_Of_Items) AS NumberOfItems, COUNT (Customer_Id) AS NO_OF_INVOICE, SUM (Total_Amount) AS  Total_Sale from CUSTOMER_INVOICE  " ;
        ResultSet rs=st.executeQuery(sql);
        
        while (rs.next()) {
        	System.out.println("Number Of Items :   "+rs.getString("NumberOfItems"));
         	System.out.println("NO OF INVOICE :   "+rs.getString("NO_OF_INVOICE"));
         	System.out.println("Total Sale :    "+rs.getString("Total_Sale"));
        	
   
       
        }}
  
    

    catch (Exception ex) {
        System.err.println(ex);
    }}

	
	public static void reportAllInvoice(String user,String pass,String url) throws IOException, InterruptedException {
	
	    
	    Connection con = null;

	    try {

	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);

	        con = DriverManager.getConnection(url, user, pass);

	        Statement st = con.createStatement();
	       
	    
	        String sql="select Invoice_Date  , Customer_Full_Name, Number_Of_Items ,Total_Amount, Balance , Shop_Name, Tel, Fax, Email, Website from CUSTOMER_INVOICE INNER JOIN  ITEMS ON ITEMS.Item_Id=CUSTOMER_INVOICE.Item_Id INNER JOIN Shop ON Shop.Shop_Id=ITEMS.Shop_Id INNER JOIN InvoiceHeader ON InvoiceHeader.Header_id=Shop.Header_id";
	        ResultSet rs=st.executeQuery(sql);
	        
	        while (rs.next()) {
	        	System.out.println("Invoice_Date :   "+rs.getString("Invoice_Date"));
	         	System.out.println("Customer Full Name :   "+rs.getString("Customer_Full_Name"));
	         	System.out.println("Number Of Items :    "+rs.getInt("Number_Of_Items"));
	         	System.out.println("Total Amount :    "+rs.getFloat("Total_Amount"));
	         	System.out.println("Balance:    "+rs.getFloat("Balance"));
	         	System.out.println("Shop Name :    "+rs.getString("Shop_Name"));
	         	System.out.println("Tel Number :    "+rs.getInt("Tel"));
	         	System.out.println("Fax Number :    "+rs.getInt("Fax"));
	         	System.out.println("Email :    "+rs.getString("Email"));
	         	System.out.println("Website :    "+rs.getString("Website"));
	        	
	   
	       
	        }}
	  
	    

	    catch (Exception ex) {
	        System.err.println(ex);
	    }}
	
	public static void searchById(	String user, String pass, String url) throws IOException, InterruptedException {

    
    Connection con = null;

    try {

        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        DriverManager.registerDriver(driver);

        con = DriverManager.getConnection(url, user, pass);

        Statement st = con.createStatement();
       
        Scanner sa=new Scanner(System.in);
    	System.out.println("Enter Invoice Number: ");
        int InvoiceNO =sa.nextInt();
        int count=0;
        String sql="select * from CUSTOMER_INVOICE INNER JOIN  ITEMS ON ITEMS.Item_Id=CUSTOMER_INVOICE.Item_Id INNER JOIN Shop ON Shop.Shop_Id=ITEMS.Shop_Id INNER JOIN InvoiceHeader ON InvoiceHeader.Header_id=Shop.Header_id where Customer_Id='"+InvoiceNO+"'";
        ResultSet rs=st.executeQuery(sql);
        
        while (rs.next()&&count<=InvoiceNO) {
  
        	System.out.println("Customer Id :   "+rs.getInt("Customer_Id"));
         	System.out.println("Customer Full Name :   "+rs.getString("Customer_Full_Name"));
         	System.out.println("Phone Number:   "+rs.getInt("Phone_Number"));
         	System.out.println("Invoice Date:   "+rs.getString("Invoice_Date"));
         	System.out.println("Number Of Items :    "+rs.getInt("Number_Of_Items"));
         	System.out.println("Total Amount :    "+rs.getFloat("Total_Amount"));
         	System.out.println("Paid Amount :    "+rs.getFloat("Paid_Amount"));
         	System.out.println("Balance:    "+rs.getFloat("Balance"));
         	System.out.println("Item Id :    "+rs.getInt("Item_Id"));
         	System.out.println("Item Name :    "+rs.getString("Item_Name"));
         	System.out.println("Unit Price :    "+rs.getFloat("Unit_Price"));
         	System.out.println("Quantity  :    "+rs.getInt("Quantity"));
         	System.out.println("Quantity Amount :    "+rs.getFloat("Quantity_Amount"));
         	System.out.println("Quantity Amount :    "+rs.getFloat("Quantity_Amount"));
         	System.out.println("Shop Id :    "+rs.getInt("Shop_Id"));
         	System.out.println("Shop Name :    "+rs.getString("Shop_Name"));
         	System.out.println("Tel Number :    "+rs.getInt("Tel"));
         	System.out.println("Fax Number :    "+rs.getInt("Fax"));
         	System.out.println("Email :    "+rs.getString("Email"));
         	System.out.println("Website :    "+rs.getString("Website"));
             count++;
             
       
        }}
  
    

    catch (Exception ex) {
        System.err.println(ex);
    }	}

}
