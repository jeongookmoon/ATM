import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * <h1>ATMSystem class</h1>
 * ATMSystem test other classes' methods via 3 menu(Open account, Atm, Quit)
 * It can open an bank account through [O]pen bank account option,
 * let user use Atm with a card via [A]tm option and quit with [Q]uit option
 * 
 * @author Jeong Ook Moon
 * @version 1.0
 * @since 2017-09-30
 */
public class ATMSystem 
{
	/**
	 * this is main method of ATMSystem where it runs whole tests
	 * @param args unused
	 */
	public static void main(String[] args) 
	{
		//initializing pre-conditions
		MyWorld thisWorld = new MyWorld();
		// initializing two MyBank objects
		MyBank bankA = new MyBank();
		bankA.setBankId("bankA");
		MyBank bankB = new MyBank();
		bankB.setBankId("bankB");
		// initializing four MyATM objects
		MyATM atmA = new MyATM();
		MyATM atmB = new MyATM();
		MyATM atmC = new MyATM();
		MyATM atmD = new MyATM();
		
		// setting withdrawal limit on ATMs
		atmA.setMaxWithdraw(100);
		atmB.setMaxWithdraw(50);
		atmC.setMaxWithdraw(100);
		atmD.setMaxWithdraw(50);
		
		// adding atms to real world so atms are accessible
		thisWorld.addAtms("atmA", atmA);
		thisWorld.addAtms("atmB", atmB);
		thisWorld.addAtms("atmC", atmC);
		thisWorld.addAtms("atmD", atmD);
		
		// 7 cards created
		MyCashCard card1 = new MyCashCard();
		card1.setBankId("bankA");
		card1.setCardNumber("11111111");
		card1.setExpDate(201603);
		card1.setPassword("1111");
		
		MyCashCard card2 = new MyCashCard();
		card2.setBankId("bankA");
		card2.setCardNumber("22222222");
		card2.setExpDate(201811);
		card2.setPassword("2222");

		MyCashCard card3 = new MyCashCard();
		card3.setBankId("bankA");
		card3.setCardNumber("33333333");
		card3.setExpDate(201907);
		card3.setPassword("3333");

		MyCashCard card4 = new MyCashCard();
		card4.setBankId("bankB");
		card4.setCardNumber("44444444");
		card4.setExpDate(201102);
		card4.setPassword("4444");
		
		MyCashCard card5 = new MyCashCard();
		card5.setBankId("bankB");
		card5.setCardNumber("55555555");
		card5.setExpDate(201801);
		card5.setPassword("5555");
		
		MyCashCard card6 = new MyCashCard();
		card6.setBankId("0");
		card6.setCardNumber("0");
		card6.setExpDate(0);
		card6.setPassword("");
		
		MyCashCard card7 = new MyCashCard();
		card7.setBankId("0");
		card7.setCardNumber("0");
		card7.setExpDate(0);
		card7.setPassword("0");
		
		// created cards are available in this world
		thisWorld.addCards("card1", card1);
		thisWorld.addCards("card2", card2);
		thisWorld.addCards("card3", card3);
		thisWorld.addCards("card4", card4);
		thisWorld.addCards("card5", card5);
		thisWorld.addCards("card6", card6);
		thisWorld.addCards("card7", card7);
		
		// creating accounts with customer information
		MyCustomer cust1 = new MyCustomer();
		cust1.setName("Jay Park");
		cust1.setPoNumber("1111111");
		
		MyCustomer cust2 = new MyCustomer();
		cust2.setName("Ray Bey");
		cust2.setPoNumber("2222222");
		
		MyCustomer cust3 = new MyCustomer();
		cust3.setName("Oscar Fiji");
		cust3.setPoNumber("3333333");
		
		MyCustomer cust4 = new MyCustomer();
		cust4.setName("Geo Fan");
		cust4.setPoNumber("444444");
		
		MyCustomer cust5 = new MyCustomer();
		cust5.setName("Henry Simpson");
		cust5.setPoNumber("555555");
		
		MyCustomer cust6 = new MyCustomer();
		cust6.setName("0");
		cust6.setPoNumber("0");
		
		MyCustomer cust7 = new MyCustomer();
		cust7.setName("0");
		cust7.setPoNumber("0");
		
		MyAccount acct1 = new MyAccount();
		acct1.setAccountNumber("1111111");
		acct1.setCard(card1);
		acct1.setCustomerInfo(cust1);
		acct1.setDeposit(90);
		bankA.addAccount(acct1);
		
		MyAccount acct2 = new MyAccount();
		acct2.setAccountNumber("2222222");
		acct2.setCard(card2);
		acct2.setCustomerInfo(cust2);
		acct2.setDeposit(90);
		bankA.addAccount(acct2);
		
		MyAccount acct3 = new MyAccount();
		acct3.setAccountNumber("3333333");
		acct3.setCard(card3);
		acct3.setCustomerInfo(cust3);
		acct3.setDeposit(90);
		bankA.addAccount(acct3);
		
		MyAccount acct4 = new MyAccount();
		acct4.setAccountNumber("4444444");
		acct4.setCard(card4);
		acct4.setCustomerInfo(cust4);
		acct4.setDeposit(90);
		bankB.addAccount(acct4);
		
		MyAccount acct5 = new MyAccount();
		acct5.setAccountNumber("5555555");
		acct5.setCard(card5);
		acct5.setCustomerInfo(cust5);
		acct5.setDeposit(90);
		bankB.addAccount(acct5);
		
		MyAccount acct6 = new MyAccount();
		acct6.setAccountNumber("0");
		acct6.setCard(card6);
		acct6.setCustomerInfo(cust6);
		acct6.setDeposit(0);
		bankA.addAccount(acct6);
		
		MyAccount acct7 = new MyAccount();
		acct7.setAccountNumber("0");
		acct7.setCard(card7);
		acct7.setCustomerInfo(cust7);
		acct7.setDeposit(0);
		bankB.addAccount(acct7);
		
		// giving atms access to banks
		atmA.setBankAccess(bankA);
		atmB.setBankAccess(bankA);
		atmC.setBankAccess(bankB);
		atmD.setBankAccess(bankB);

		// explanation of precondition
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		System.out.println("States of two Banks:");
		System.out.println();
		System.out.println("All accounts have $90");
		System.out.println();
		System.out.println("BankA ( three customers ):");
		System.out.println("Jay Park with card1 (bankid: bankA, account number (#1111111), expires on 201603, password (#1111))");
		System.out.println("Rey Bey with card2 (bankid: bankA, account number (#2222222), expires on 201811, password (#2222))");
		System.out.println("Oscar Fiji with card3 (bankid: bankA, account number (#3333333), expires on 201907, password (#3333))");
		System.out.println();
		System.out.println("BankB ( two customers ):");
		System.out.println("Geo Fan with card4 (bankid: bankB, account number (#4444444), expires on 201102, password (#4444))");
		System.out.println("Henry Simpson with card5 (bankid: bankB, account number (#5555555), expires on 201801, password (#5555))");
		System.out.println();
		System.out.println("States of four ATMs:");
		System.out.println("atmA: (ATM1 from bankA)");
		System.out.println("\t"+"The maximum amount of withdraw using a cash card per transaction: $100");
		System.out.println("atmB: (ATM2 from bankA)");
		System.out.println("\t"+"The maximum amount of withdraw using a cash card per transaction: $50");
		System.out.println("atmC: (ATM1 from bankB)");
		System.out.println("\t"+"The maximum amount of withdraw using a cash card per transaction: $100");
		System.out.println("atmD: (ATM2 from bankB)");
		System.out.println("\t"+"The maximum amount of withdraw using a cash card per transaction: $50");
		System.out.println();
		System.out.println("Both bankA and bankB have one empty accounts with empty cash cards:");
		System.out.println("If someone opens a new bank account at bankA, card6 will belong to that person");
		System.out.println("If someone opens a new bank account at bankB, card7 will belong to that person");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		
		// starting main menu
		Scanner sc = new Scanner(System.in);
		boolean terminator = false;
		while(terminator == false)
		{
			System.out.println();
			System.out.println("[M]ain menu");
			System.out.println();
			System.out.println("[O]pen bank account, [A]TM, [Q]uit");
			String answer = sc.nextLine();
			answer = answer.toLowerCase();
			switch(answer)
			{
				case "o": 
					boolean innerloop = false;
					String bank_a = "";
					while(innerloop == false)
					{
						boolean innerloop2 = false;
						while(innerloop2 == false)
						{
							System.out.println();
							System.out.println("[O]pen bank account");
							System.out.println();
							System.out.println("Which bank? [bankA or bankB]");
							bank_a = sc.nextLine();
							switch(bank_a)
							{
								case "bankA":
									innerloop2 = true;
									break;
								case "bankB":
									innerloop2 = true;
									break;
								default :
									System.out.println("Please choose a bank between bankA and bankB");								
							}
						}
						System.out.println("What's your name?");
						MyCustomer cust = new MyCustomer();
						String name = sc.nextLine();
						System.out.println("What's your phone number?");
						String ponum = sc.nextLine();
						cust.setName(name);
						cust.setPoNumber(ponum);
						System.out.println("Please enter the amount of deposit you'd like to make");
						int deposit = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter password");
						String pw = sc.nextLine();
						if(bank_a.equals("bankA"))
						{
							if(bankA.checkDuplicateCustomer(cust) == true)
							{
								System.out.println("Error: Existing account found, each customer can have only 1 account");
							}
							else
							{
								// updated bankaccess and card in thisWorld after creating a bank account
								bankA.openAccount(cust, deposit, pw);
								atmA.setBankAccess(bankA);
								atmB.setBankAccess(bankA);
								card6 = bankA.cardToCustomer(cust);
								thisWorld.updateCards("card6", card6);
								System.out.println("You've successfully opened your bank account at bankA! Here is your card, [card6]!");
								innerloop = true;
							}
						}
						else
						{
							if(bankB.checkDuplicateCustomer(cust) == true)
							{
								System.out.println("Error: Existing account found, each customer can have only 1 account");
							}
							else
							{
								// updated bankaccess and card in thisWorld after creating a bank account
								bankB.openAccount(cust, deposit, pw);
								atmC.setBankAccess(bankB);
								atmD.setBankAccess(bankB);
								card7 = bankB.cardToCustomer(cust);
								thisWorld.updateCards("card7", card7);
								System.out.println("You've successfully opened your bank account at bankB! Here is your card, [card7]!");
								innerloop = true;
							}
						}
					}							
					break;
				case "a": 
					innerloop = false;
					while(innerloop == false)
					{
						boolean innerloop2 = false;
						String atm = "";
						String cardc = "";
						System.out.println();
						System.out.println("[A]TM");
						System.out.println();
						System.out.println("Choose ATM among [atmA, atmB, atmC, atmD] or press[M]ain menu");
						atm = sc.nextLine();
						if(atm.equals("atmA")||atm.equals("atmB")||atm.equals("atmC")||atm.equals("atmD"))
						{
							while(innerloop2 == false)
							{
								System.out.println();
								System.out.println("Please enter insert card [card1, card2, card3, card4, card5, card6, card7]");
								System.out.println("If you opened an account, [card6] for bankA, [card7] for bankB");
								cardc = sc.nextLine();
								if(cardc.equals("card1")||cardc.equals("card2")||cardc.equals("card3")||cardc.equals("card4")||cardc.equals("card5")||cardc.equals("card6")||cardc.equals("card7"))
								{
									if(thisWorld.getAtms().get(atm).getBankAccess().getBankId().equals(thisWorld.getCards().get(cardc).getBankId()))
									{
										// saving today's year and month
										GregorianCalendar cal = new GregorianCalendar();
										int today = cal.get(Calendar.YEAR)*100+cal.get(Calendar.MONTH)+1;
										// checking if exp date is expired yet
										if(+thisWorld.getCards().get(cardc).getExpDate()>today)
										{
											System.out.println("The card is accepted");
											innerloop2 = true;
										}
										else
										{
											System.out.println(cardc+" is expired");
											System.out.println("Today's yearmonth is "+today+" and the card's expiration date is "+thisWorld.getCards().get(cardc).getExpDate());
										}
									}
									else
									{
										System.out.println(atm+" doesn't support your card, please insert other card");
									}
								}
								else
								{
									System.out.println("Please enter choose a correct card");
								}
							}
							innerloop2 = false;
							while(innerloop2 == false)
							{
								System.out.println();
								System.out.println("Please enter the password of the credit card");
								String password = sc.nextLine();
								//checking if the password input is same as the password saved in account
								if(thisWorld.getAtms().get(atm).getBankAccess().checkPassword(thisWorld.getCards().get(cardc), password))
								{
									System.out.println("Authorization completed");
									innerloop2 = true;
								}
								else
								{
									System.out.println("! Wrong password");
								}
							}
							innerloop2 = false;
							while(innerloop2 == false)
							{
								System.out.println();
								System.out.println("Please enter the amount of money you'd like to withdraw");
								int withdraw = sc.nextInt();
								sc.nextLine();

								if(thisWorld.getAtms().get(atm).checkViolateMaxWithdraw(withdraw))
								{
									System.out.println("$"+withdraw +" exceeds the transaction limit ($"+thisWorld.getAtms().get(atm).getMaxWithdraw()+")");
								}
								else
								{
									// checking if withdraw amount is less or equal to the deposit
									if(thisWorld.getAtms().get(atm).getBankAccess().getAccount(thisWorld.getCards().get(cardc)).withdrawCheck(withdraw))
									{
										int current_deposit = thisWorld.getAtms().get(atm).getBankAccess().getAccount(thisWorld.getCards().get(cardc)).getDeposit();
										thisWorld.getAtms().get(atm).getBankAccess().getAccount(thisWorld.getCards().get(cardc)).withdraw(withdraw);
										System.out.println("$"+withdraw+" is withdrawn from your account");
										System.out.println("The initial balance was $"+current_deposit);
										System.out.println("The remaining balance is $"+thisWorld.getAtms().get(atm).getBankAccess().getAccount(thisWorld.getCards().get(cardc)).getDeposit());
										System.out.println();
										System.out.println("Please enter [C]ontinue more transactions or [Q]uit");
										String input = sc.nextLine();
										input= input.toLowerCase();
										if(input.equals("c"))
										{							
											System.out.println();
											System.out.println("[C]ontinue more transactions");
										}
										else if(input.equals("q"))
										{
											innerloop2 = true;
										}
										else
										{
											System.out.println("Please enter either [C] or [Q]");
										}

									}
									else
									{
										System.out.println("Insufficient fund! You have $"+thisWorld.getAtms().get(atm).getBankAccess().getAccount(thisWorld.getCards().get(cardc)).getDeposit()+" on your account");
									}
								}
							}
						}
						else if(atm.equals("m")||atm.equals("M"))
						{
							innerloop = true;
						}
						else
						{
							System.out.println("Please enter correct atm name");	
						}
					}
					break;
				case "q": 
					terminator = true;
					break;
				default: 
					System.out.println("please select corret menu");
					break;	
			}
		}
		sc.close();
		System.out.println("Farewell~!");
	}
}
