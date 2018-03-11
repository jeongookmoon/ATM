/**
 * <h1>MyAccount class</h1>
 * MyAccount holds necessary attributes for bank account information
 * such as account number, amount of deposit, customer information and card information
 *  * 
 * @author Jeong Ook Moon
 * @version 1.0
 * @since 2017-09-30
 */
public class MyAccount 
{
	private String account_number;
	private MyCashCard card_info;
	private MyCustomer customer_info;
	private int deposit;
	/**
	  * The constructor is to set initial values for attributes
	 */
	public MyAccount()
	{
		this.account_number = "";
		this.card_info = new MyCashCard();
		this.customer_info = new MyCustomer();
		this.deposit = 0;
	}
	/**
	 * access to account number
	 * @return account number
	 */
	public String getAccountNumber()
	{
		return account_number;
	}
	/**
	 * updates account number
	 * @param r_acct_no account number
	 */
	public void setAccountNumber(String r_acct_no)
	{
		this.account_number = r_acct_no;
	}
	/**
	 * access to card information
	 * @return card information
	 */
	public MyCashCard getCardInfo()
	{
		return card_info;
	}
	/**
	 * updates card information
	 * @param r_card_info card information
	 */
	public void setCard(MyCashCard r_card_info)
	{
		this.card_info = r_card_info;
	}
	/**
	 * access to customer information
	 * @return customer information
	 */
	public MyCustomer getCustomerInfo()
	{
		return customer_info;
	}
	/**
	 * updates customer information
	 * @param r_customer_info customer information
	 */
	public void setCustomerInfo(MyCustomer r_customer_info)
	{
		this.customer_info = r_customer_info;
	} 
	/**
	 * access to amount of deposit
	 * @return amount of deposit
	 */
	public int getDeposit()
	{
		return deposit;
	}
	/**
	 * updates amount of deposit
	 * @param r_amount amount of deposit
	 */
	public void setDeposit(int r_amount)
	{
		this.deposit = r_amount;
	}
	/**
	 * makes deposit
	 * @param r_amount amount of deposit
	 */
	public void makeDeposit(int r_amount)
	{
		this.deposit = getDeposit() + r_amount;
	}
	/**
	 * withdraws money
	 * @param r_amount amount of money
	 */
	public void withdraw(int r_amount)
	{
		this.deposit = getDeposit() - r_amount;
	}
	/**
	 * checks if amount of money exceeds the amount of deposit
	 * @param r_amount amount of money
	 * @return true if no exceed false if exceed
	 */
	public boolean withdrawCheck(int r_amount)
	{
		if(getDeposit()-r_amount>=0)
		{
			return true;
		}
		else
			return false;
	}
}
