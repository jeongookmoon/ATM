import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

/**
 * <h1>MyBank class</h1>
 * MyAccount holds necessary attributes that bank needs
 * such as bank id and data of accounts
 *  * 
 * @author Jeong Ook Moon
 * @version 1.0
 * @since 2017-09-30
 */
public class MyBank 
{
	private String bank_id;
	private ArrayList<MyAccount> arraylist_account;
	/**
	  * The constructor is to set initial values for attributes
	 */
	public MyBank()
	{
		this.bank_id = "";
		this.arraylist_account = new ArrayList<MyAccount>();
	}
	/**
	 * access to bank id
	 * @return bank id
	 */
	public String getBankId()
	{
		return bank_id;
	}
	/**
	 * updates bank id
	 * @param r_bank_id bank id
	 */
	public void setBankId(String r_bank_id)
	{
		this.bank_id = r_bank_id;
	}
	/**
	 * access to data of accounts
	 * @return data of accounts
	 */
	public ArrayList<MyAccount> getAccounts()
	{
		return arraylist_account;
	}
	/**
	 * updates data of accounts
	 * @param r_arraylist_account data of accounts
	 */
	public void setAccounts(ArrayList<MyAccount> r_arraylist_account)
	{
		this.arraylist_account = r_arraylist_account;
	}

	/**
	 * Checks if the customer has already account with the bank
	 * @param r_cust customer info
	 * @return true if there is, false if there is not
	 */
	public boolean checkDuplicateCustomer(MyCustomer r_cust)
	{
		boolean duplicate = false;
		if(arraylist_account == null)
		{
			return false;
		}
		else
		{
			for(int i=0; i < arraylist_account.size(); i++)
			{
				if(r_cust == arraylist_account.get(i).getCustomerInfo())
				{
					duplicate = true;
				}
			}
			if(duplicate==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * Checks if the account number duplicates with existing one
	 * @param r_acct_no account number
	 * @return true if there is false if there isn't
	 */
	public boolean checkDuplicateAccount(int r_acct_no)
	{
		boolean duplicate = false;
		if(arraylist_account == null)
		{
			return false;
		}
		else
		{
			for(int i=0; i < arraylist_account.size(); i++)
			{
				if(r_acct_no == Integer.valueOf(arraylist_account.get(i).getAccountNumber()))
				{
					duplicate = true;
				}
			}
			if(duplicate==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * checks if the card number duplicates with existing one
	 * @param r_card_no card number
	 * @return true if there is, false if there isn't
	 */
	public boolean checkDuplicateCardNo(int r_card_no)
	{
		boolean duplicate = false;
		if(arraylist_account == null)
		{
			return false;
		}
		else
		{
			for(int i=0; i < arraylist_account.size(); i++)
			{
				if(r_card_no == Integer.valueOf(arraylist_account.get(i).getCardInfo().getCardNumber()))
				{
					duplicate = true;
				}
			}
			if(duplicate==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * checks if expiration date duplicated with existing one
	 * @param r_exp_date expiration date
	 * @return true if there is, false if there is not
	 */
	public boolean checkDuplicateExpDate(int r_exp_date)
	{
		boolean duplicate = false;
		if(arraylist_account == null)
		{
			return false;
		}
		else
		{
			for(int i=0; i < arraylist_account.size(); i++)
			{
				if(r_exp_date == arraylist_account.get(i).getCardInfo().getExpDate())
				{
					duplicate = true;
				}
			}
			if(duplicate==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * add new account
	 * @param r_account account information
	 */
	public void addAccount(MyAccount r_account)
	{
		ArrayList<MyAccount> temp = getAccounts();
		temp.add(r_account);
		setAccounts(temp);
	}
	/**
	 * opening a new account for customer
	 * @param r_cust customer information
	 * @param r_amount amount of deposit
	 * @param r_password password
	 */
	public void openAccount(MyCustomer r_cust, int r_amount, String r_password)
	{
		MyAccount acct = new MyAccount();
		acct.setCustomerInfo(r_cust);
		boolean terminator = false;
		// checking if the generated account number is duplicate
		while(terminator==false)
		{
			int temp = generateAcctNumber();
			if(checkDuplicateAccount(temp) == false)
			{
				acct.setAccountNumber(String.valueOf(temp));
				terminator = true;
			}
		}
		// checking if the generated card number is duplicate
		terminator = false;
		int temp = generateCardNumber();
		while(terminator==false)
		{
			if(checkDuplicateCardNo(temp) == false)
			{
				terminator = true;
			}
			else
				temp = generateCardNumber();
		}
		terminator = false;
		// checking if the generated exp date is duplicate
		int tempExp = generateExpDate();
		while(terminator==false)
		{
			if(checkDuplicateAccount(temp) == false)
			{
				terminator = true;
			}
			else
				temp = generateCardNumber();
		}
		// update both card and account information and at the end add the account to data of accounts
		MyCashCard card = new MyCashCard();
		card.setBankId(getBankId());
		card.setCardNumber(String.valueOf(temp));
		card.setExpDate(tempExp);
		card.setPassword(r_password);
		acct.setCard(card);
		acct.setDeposit(r_amount);
		addAccount(acct);
	}
	/**
	 * generates account number
	 * @return generated account number
	 */
	public int generateAcctNumber()
	{
		Random rand = new Random();
		int num = 1000000 + rand.nextInt(9000000);
		return num;
	}
	/**
	 * generates card number
	 * @return generated card number
	 */
	public int generateCardNumber()
	{
		Random rand = new Random();
		int num = 10000000 + rand.nextInt(90000000);
		return num;
	}
	/**
	 * generates expiration date
	 * @return generated expiration date
	 */
	public int generateExpDate()
	{
		GregorianCalendar cal = new GregorianCalendar();
		Random rand = new Random();
		int expdate  = (cal.get(Calendar.YEAR)+rand.nextInt(5))*100+(1+rand.nextInt(12));
		return expdate;
	}
	/**
	 * finds card information based on customer's information
	 * @param r_cust_info customer's information
	 * @return card information
	 */
	public MyCashCard cardToCustomer(MyCustomer r_cust_info)
	{
		int index = 0;
		for(int i=0; i<arraylist_account.size();i++)
		{
			if(arraylist_account.get(i).getCustomerInfo() == r_cust_info)
			{
				index = i;
			}
		}
		return arraylist_account.get(index).getCardInfo();
	}
	/**
	 * finds account information based on card information
	 * @param r_card card information
	 * @return account information
	 */
	public MyAccount getAccount(MyCashCard r_card)
	{
		int index = 0;
		for(int i=0; i<arraylist_account.size();i++)
		{
			if(arraylist_account.get(i).getCardInfo() == r_card)
			{
				index = i;
			}
		}
		return arraylist_account.get(index);
	}
	/**
	 * checks if the card's password is equal to the password saved in account
	 * @param r_card card information
	 * @param r_password password
	 * @return true if they are identical, false if they are not
	 */
	public boolean checkPassword(MyCashCard r_card, String r_password)
	{
		if(arraylist_account == null)
		{
			return false;
		}
		else
		{
			for(int i=0; i<arraylist_account.size();i++)
			{
				if(arraylist_account.get(i).getCardInfo() == r_card)
				{
					if(arraylist_account.get(i).getCardInfo().getPassword().equals(r_password))
					{
						return true;	
					}
				}
			}
			return false;
		}
		
	}
}
