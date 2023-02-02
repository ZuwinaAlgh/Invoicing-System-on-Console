
public class Customer {

	int id;
	String Customer_Full_Name;
	int Phone_Number;
	String Invoice_Date;
	int Number_Of_Items;
	float Total_Amount;
	float Paid_Amount;
	float Balance;
	
	Item [] Item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_Full_Name() {
		return Customer_Full_Name;
	}

	public void setCustomer_Full_Name(String customer_Full_Name) {
		Customer_Full_Name = customer_Full_Name;
	}

	public int getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(int phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getInvoice_Date() {
		return Invoice_Date;
	}

	public void setInvoice_Date(String invoice_Date) {
		Invoice_Date = invoice_Date;
	}

	public int getNumber_Of_Items() {
		return Number_Of_Items;
	}

	public void setNumber_Of_Items(int number_Of_Items) {
		Number_Of_Items = number_Of_Items;
	}

	public float getTotal_Amount() {
		return Total_Amount;
	}

	public void setTotal_Amount(float total_Amount) {
		Total_Amount = total_Amount;
	}

	public float getPaid_Amount() {
		return Paid_Amount;
	}

	public void setPaid_Amount(float paid_Amount) {
		Paid_Amount = paid_Amount;
	}

	public float getBalance() {
		return Balance;
	}

	public void setBalance(float balance) {
		Balance = balance;
	}

}
