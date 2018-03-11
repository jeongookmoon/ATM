/**
 * <h1>MyATM class</h1>
 * MyATM holds necessary attributes that ATM needs
 * such as maximum withdraw value and access to bank
 *  * 
 * @author Jeong Ook Moon
 * @version 1.0
 * @since 2017-09-30
 */
public class MyATM 
{
	private int max_withdraw;
	private MyBank bank_access;
	/**
	  * The constructor is to set initial values for attributes
	 */
	public MyATM()
	{
		this.max_withdraw = 0;
		this.bank_access = new MyBank();
	}
	/**
	 * access to maximum withdraw value
	 * @return maximum withdraw value
	 */
	public int getMaxWithdraw()
	{
		return max_withdraw;
	}
	/**
	 * updates maximum withdraw value
	 * @param r_max_withdraw withdraw value
	 */
	public void setMaxWithdraw(int r_max_withdraw)
	{
		this.max_withdraw = r_max_withdraw;
	}
	public boolean checkViolateMaxWithdraw(int r_amount)
	{
		if(r_amount > max_withdraw)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * access to existing bank access
	 * @return existing bank access
	 */
	public MyBank getBankAccess()
	{
		return bank_access;
	}
	/**
	 * assigns new bank access
	 * @param r_bank new bank access
	 */
	public void setBankAccess(MyBank r_bank)
	{
		this.bank_access = r_bank;
	}
	/**
	 * checks if the card belongs to the bank
	 * @param r_card card information
	 * @return true if it belongs to the bank, false if it doesn't
	 */
	public boolean checkCardtoBank(MyCashCard r_card)
	{
		if(this.bank_access.getBankId() == r_card.getBankId())
			return true;
		else
			return false;
	}
}
