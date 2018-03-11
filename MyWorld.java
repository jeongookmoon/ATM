import java.util.HashMap;

/**
 * <h1>MyWorld class</h1>
 * MyWorld holds data of atm and cash cards existing in this world
 *  * 
 * @author Jeong Ook Moon
 * @version 1.0
 * @since 2017-09-30
 */
public class MyWorld 
{
	private HashMap<String, MyATM> atms;
	private HashMap<String, MyCashCard> cards;
	/**
	  * The constructor is to set initial values for attributes
	 */
	public MyWorld()
	{
		atms = new HashMap<String, MyATM>();
		cards = new HashMap<String, MyCashCard>();
	}
	/**
	 * access to data of existing ATMs in this world
	 * @return data of existing ATMs
	 */
	public HashMap<String, MyATM> getAtms() 
	{
		return atms;
	}
	/**
	 * updates data of existing ATMs in this world
	 * @param atms data of ATMs
	 */
	public void setAtms(HashMap<String, MyATM> atms) 
	{
		this.atms = atms;
	}
	/**
	 * access to data of existing cash cards in this world
	 * @return data of existing cash cards
	 */
	public HashMap<String, MyCashCard> getCards() 
	{
		return cards;
	}
	/**
	 * updates data of existing cash cards in this world
	 * @param cards data of cash cards
	 */
	public void setCards(HashMap<String, MyCashCard> cards) 
	{
		this.cards = cards;
	}
    /**
     * add new atm to this world
     * @param r_name name of atm
     * @param r_atm atm information
     */
	public void addAtms(String r_name, MyATM r_atm)
	{
		atms.put(r_name, r_atm);
	}
	/**
	 * checks if the atm exists in the data
	 * @param r_atm atm information
	 * @return true if it exists, false if it doesn't
	 */
	public boolean containsAtms(MyATM r_atm)
	{
		if(atms.containsValue(r_atm))
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * updates a particular atm in the data
	 * @param r_name atm's name
	 * @param r_atm atm information
	 */
	public void updateAtms(String r_name, MyATM r_atm)
	{
		atms.replace(r_name, r_atm);
	}
	/**
	 * add a card to data of existing cards in this world
	 * @param r_name name of card
	 * @param r_card card information
	 */
	public void addCards(String r_name, MyCashCard r_card)
	{
		cards.put(r_name, r_card);
	}
	/**
	 * checks if card exists in data of existing cards in this world
	 * @param r_card card information
	 * @return true if it exists, false if it doesn't
	 */
	public boolean containsCards(MyCashCard r_card)
	{
		if(cards.containsValue(r_card))
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * updates a particular card's information
	 * @param r_name name of the card
	 * @param r_card card information
	 */
	public void updateCards(String r_name, MyCashCard r_card)
	{
		cards.replace(r_name, r_card);
	}
}
