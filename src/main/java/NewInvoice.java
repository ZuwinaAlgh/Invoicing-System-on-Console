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
import java.util.Random;
import java.util.Scanner;

public class NewInvoice {

	public static void createNewInvoice(String user, String pass, String url) throws IOException, InterruptedException {
//			String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
//	        String user = "sa";
//	        String pass = "root";

		Scanner sa = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("...Create New Invoice...:");
		System.out.println("...How Many Invoice You Want To Enter...:");
		int rows = sa.nextInt();
		for (int i = 0; i <= rows; i++) {
			System.out.println("Enter Customer_Full_Name:");
			String Customer_Full_Name = bf.readLine();
			System.out.println("Enter Customer_Phone_Number:");
			int Phone_Number = sa.nextInt();
			System.out.println("Enter Invoice_Date:");
			String Invoice_Date = sa.next();
			System.out.println("Enter Number_Of_Items:");
			int Number_Of_Items = sa.nextInt();
			System.out.println("Enter Total_Amount:");
			float Total_Amount = sa.nextFloat();
			System.out.println("Enter Paid_Amount:");
			float Paid_Amount = sa.nextFloat();
			System.out.println("Enter Balance:");
			float Balance = sa.nextFloat();

			String sql = "insert into CUSTOMER_INVOICE(Customer_Full_Name,Phone_Number,Invoice_Date,Number_Of_Items,Total_Amount,Paid_Amount,Balance)VALUES(?,?,?,?,?,?,?)";

			Connection con = null;

			try {

				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);

				con = DriverManager.getConnection(url, user, pass);
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, Customer_Full_Name);
				ps.setInt(2, Phone_Number);
				ps.setString(3, Invoice_Date);
				ps.setInt(4, Number_Of_Items);
				ps.setFloat(5, Total_Amount);
				ps.setFloat(6, Paid_Amount);
				ps.setFloat(7, Balance);
				ps.executeUpdate();

				System.out.println("insert data successfully");
			}

			catch (Exception ex) {
				System.err.println(ex);
			}

		}
	}
}
