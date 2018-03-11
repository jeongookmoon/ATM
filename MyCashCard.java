/**
 * <h1>MyCashCard class</h1>
 * MyCashCard holds necessary attributes that cash card needs
 * such as card number, bank id, expiration date, password
 *  * 
 * @author Jeong Ook Moon
 * @version 1.0
 * @since 2017-09-30
 */
public class MyCashCard 
{
	private String card_number;
	private String bank_id;
	private int exp_date;
	private String password;
	/**
	  * The constructor is to set initial values for attributes
	 */
	public MyCashCard()
	{
		this.card_number = "";
		this.bank_id = "";
		this.exp_date = 0;
		this.password = "";
	}
	/**
	 * access to card number
	 * @return card number
	 */
	public String getCardNumber()
	{
		return card_number;
	}
	/**
	 * updates card number
	 * @param r_c_number card number
	 */
	public void setCardNumber(String r_c_number)
	{
		this.card_number = r_c_number;
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
	 * access to expiration date
	 * @return expiration date
	 */
	public int getExpDate()
	{
		return exp_date;
	}
	/**
	 * updates expiration date
	 * @param r_exp_date expiration date
	 */
	public void setExpDate(int r_exp_date)
	{
		this.exp_date = r_exp_date;
	}
	/**
	 * access to password
	 * @return password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * updates password
	 * @param r_password password
	 */
	public void setPassword(String r_password)
	{
		this.password = r_password;
	}
	
}
