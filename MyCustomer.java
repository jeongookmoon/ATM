/**
 * <h1>MyCustomer class</h1>
 * MyCustomer holds necessary attributes for customer information
 * such as customer's name, phone number
 *  * 
 * @author Jeong Ook Moon
 * @version 1.0
 * @since 2017-09-30
 */
public class MyCustomer 
{
	private String name;
	private String ponumber;
	/**
	  * The constructor is to set initial values for attributes
	 */
	public MyCustomer()
	{
		this.name ="";
		this.ponumber = "";
	}
	/**
	 * access to customer name
	 * @return customer name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * updates customer's name
	 * @param r_name customer's name
	 */
	public void setName(String r_name)
	{
		this.name = r_name;
	}
	/**
	 * access to customer's phone number
	 * @return customer's phone number
	 */
	public String getPoNumber()
	{
		return ponumber;
	}
	/**
	 * updates customer's phone number
	 * @param r_ponumber customer's phone number
	 */
	public void setPoNumber(String r_ponumber)
	{
		this.ponumber = r_ponumber;
	}
}
