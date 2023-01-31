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
        	
        	 int NumberOfItems=rs.getInt("Number_Of_Items");
        	 int NO_OF_INVOICE=rs.getInt("Customer_Id");
        	 float Total_Sale=rs.getFloat("Total_Amount");
             
       System.out.println(NumberOfItems+NO_OF_INVOICE+Total_Sale);
       
        }}
  
    

    catch (Exception ex) {
        System.err.println(ex);
    }}

}
