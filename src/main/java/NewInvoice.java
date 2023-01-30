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

public class NewInvoice{

		public static void createNewInvoice() throws IOException, InterruptedException{
			String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
			String user = "sa";
			String pass = "root";
			Connection con;

			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);

				con = DriverManager.getConnection(url, user, pass);

				Statement st = con.createStatement();

				String sql = "select * from CUSTOMER_INVOICE INNER JOIN ITEMS ON ITEMS.Item_Id=CUSTOMER_INVOICE.Item_Id INNER JOIN Shop ON Shop.Shop_Id=ITEMS.Shop_Id INNER JOIN InvoiceHeader ON InvoiceHeader.Header_id=Shop.Header_id  where CUSTOMER_INVOICE.Customer_Id=1";
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					String Customer_Full_Name = rs.getString("Customer_Full_Name");
					int Phone_Number= rs.getInt("Phone_Number");
					String Invoice_Date=rs.getString("Invoice_Date");
					float Total_Amount=rs.getFloat("Total_Amount");
					String Item_Name=rs.getString("Item_Name");
					int Quantity=rs.getInt("Quantity");
					String Shop_Name =rs.getString("Shop_Name");
					int Tel=rs.getInt("Tel");
					int Fax=rs.getInt("Fax");
					String Email=rs.getString("Email");
					String Website=rs.getString("Website");
					
					System.out.println(Customer_Full_Name,Phone_Number,Invoice_Date,Total_Amount,Item_Name,Quantity,Shop_Name,Tel,Fax,Email,Website);
				}

			} catch (Exception ex) {
				
				System.err.println(ex);
			}
	 		
	}}


