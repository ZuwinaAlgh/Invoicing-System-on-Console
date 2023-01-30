import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class ShopSetting {

	//insert data into Customer invoice
	public static void insertdata() throws IOException, InterruptedException{
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Scanner sa=new Scanner(System.in);
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("...Enter Customer Details...:");
        System.out.println("...How Many Rows You Want To Enter...:");
        int rows=sa.nextInt();
        for(int i=0; i<=rows;i++) {
        System.out.println("Enter Customer_Full_Name:");
        String Customer_Full_Name =bf.readLine();
        System.out.println("Enter Customer_Phone_Number:");
        int Phone_Number=sa.nextInt();
        System.out.println("Enter Invoice_Date:");
        String Invoice_Date=sa.next();
        System.out.println("Enter Number_Of_Items:");
        int Number_Of_Items=sa.nextInt();
        System.out.println("Enter Total_Amount:");
        float Total_Amount=sa.nextFloat();
        System.out.println("Enter Paid_Amount:");
        float Paid_Amount=sa.nextFloat();
        System.out.println("Enter Balance:");
        float Balance=sa.nextFloat();
        
        
        
        String sql="insert into CUSTOMER_INVOICE(Customer_Full_Name,Phone_Number,Invoice_Date,Number_Of_Items,Total_Amount,Paid_Amount,Balance)VALUES(?,?,?,?,?,?,?)";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1, Customer_Full_Name);
            ps.setInt(2, Phone_Number);
            ps.setString(3, Invoice_Date);
            ps.setInt(4, Number_Of_Items);
            ps.setFloat(5, Total_Amount);
            ps.setFloat(6, Paid_Amount);
            ps.setFloat(7, Balance);
            ps.executeUpdate();

                System.out.println( "insert data successfully");
        }

        catch (Exception ex) {
            System.err.println(ex);
        }}}
        
        
        //insert data into ITEMS table
        public static void insertItemdata() throws IOException, InterruptedException{
    		
    		String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "root";
            
            Scanner sa=new Scanner(System.in);
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("...Enter ITEMS Details...:");
            System.out.println("...How Many Rows You Want To Enter...:");
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
            }}
            //insert shop data
            public static void insertShopdata() throws IOException, InterruptedException{
        		
        		String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
                String user = "sa";
                String pass = "root";
                
                Scanner sa=new Scanner(System.in);
                BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
                
                System.out.println("...Enter Shop Details...:");
                System.out.println("...How Many Rows You Want To Enter...:");
                int rows=sa.nextInt();
                for(int i=0; i<=rows;i++) {
                System.out.println("Enter Shop Name:");
                String Shop_Name =bf.readLine();
            
                
                
                
                String sql="insert into Shop(Shop_Name)VALUES(?)";
                
                Connection con = null;

                try {

                    Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    DriverManager.registerDriver(driver);

                    con = DriverManager.getConnection(url, user, pass);
                    PreparedStatement ps=con.prepareStatement(sql);
                    
                    ps.setString(1, Shop_Name);
                    ps.executeUpdate();

                        System.out.println( "insert data successfully");
                }

                catch (Exception ex) {
                    System.err.println(ex);
                }
                }}
            //insert header data
                public static void insertInvoiceHeaderdata() throws IOException, InterruptedException{
            		
            		String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
                    String user = "sa";
                    String pass = "root";
                    
                    Scanner sa=new Scanner(System.in);
                    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
                    
                    System.out.println("...Enter Invoice Header Details...:");
                    System.out.println("...How Many Rows You Want To Enter...:");
                    int rows=sa.nextInt();
                    for(int i=0; i<=rows;i++) {
                    System.out.println("Enter Tel Number:");
                    int Tel=sa.nextInt();
                    System.out.println("Enter Fax Number:");
                    int Fax=sa.nextInt();
                    System.out.println("Enter Email Number:");
                    String Email=bf.readLine();
                    System.out.println("Enter Website:");
                    String Website=bf.readLine();
                    
                
                    
                    
                    
                    String sql="insert into InvoiceHeader(Tel,Fax,Email,Website)VALUES(?,?,?,?)";
                    
                    Connection con = null;

                    try {

                        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                        DriverManager.registerDriver(driver);

                        con = DriverManager.getConnection(url, user, pass);
                        PreparedStatement ps=con.prepareStatement(sql);
                        
                        ps.setInt(1, Tel);
                        ps.setInt(2, Fax);
                        ps.setString(3, Email);
                        ps.setString(4, Website);
                        ps.executeUpdate();

                            System.out.println( "insert data successfully");
                    }

                    catch (Exception ex) {
                        System.err.println(ex);
                    }
                    }
	}

	}


