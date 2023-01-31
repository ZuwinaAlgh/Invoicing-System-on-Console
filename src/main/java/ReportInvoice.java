import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportInvoice {
	public static void statisticsReport() throws IOException, InterruptedException {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
    String user = "sa";
    String pass = "root";
    
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

	
	public static void reportAllInvoice() throws IOException, InterruptedException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
	    String user = "sa";
	    String pass = "root";
	    
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

}
