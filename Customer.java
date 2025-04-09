//Customer.java

import java.util.*;

class Customer extends User {
	class CheckingAcctList extends ArrayList<CheckingAccount>{};
	class SavingsAcctList extends ArrayList<SavingsAccount>{};
	protected CheckingAcctList chAccounts = new CheckingAcctList();
	protected SavingsAcctList svAccounts = new SavingsAcctList();

	protected String userName;
	protected String PIN;

	public static void main(String[] args){
		Customer alice = new Customer("Alice", "0000");
		alice.start();
	} //End main test harness

	public Customer(){
		super("", "");
		this.userName = "";
		this.PIN = "";
		this.loadSampleChAccount();
		this.loadSampleSvAccount();
	} //End constructor

	public Customer(String userName, String sPIN){
		super(userName, sPIN);
		this.userName = userName;
		this.PIN = sPIN;
		this.loadSampleChAccount();
		this.loadSampleSvAccount();
	} //End dual parameter constructor

	@Override
	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) View All Account Balances");
		System.out.println("2) Access Checking");
		System.out.println("3) Access Savings");
		System.out.print("Action (0-3): ");

		menuResponse = menuInput.nextLine();

		return menuResponse;
	} //End menu()

	public void start(){
		if(this.login()){
			boolean keepGoing = true;
			while (keepGoing){
				String menuInput = this.menu();

				if(menuInput.equals("0")){
					keepGoing = false;
				} //Exit
				
				else if(menuInput.equals("1")){
					System.out.println("View All Account Balances");
					this.getReport();
				} //View All Account
				
				else if(menuInput.equals("2")){
					System.out.println("Access Checking");
				} //Access Checking

				else if(menuInput.equals("3")){
					System.out.println("Access Savings");
				} //Access Savings
				else {
					System.out.println("Invalid input.");
				} //Invalid input
			} //End while
		} //Login

		else {
			System.out.println("Invalid login.");
		} //Invalid login

	} //End start()	

	@Override
	public void getReport(){
		System.out.println("Checking Accounts: ");
		this.printChAccounts();
		System.out.println("");

		System.out.println("Savings Accounts: ");
		this.printSvAccounts();	
	}

	public void loadSampleChAccount(){
		chAccounts.add(new CheckingAccount(1000d));
		chAccounts.add(new CheckingAccount(1000d));
	} //loadSampleChAccount()

	public void loadSampleSvAccount(){
		svAccounts.add(new SavingsAccount(1000d, 5));
		svAccounts.add(new SavingsAccount(1000d, 5));
	} //loadSampleSvAccount()

	public void printChAccounts(){
		Iterator<CheckingAccount> it = chAccounts.iterator();
		while(it.hasNext()){
			CheckingAccount currentAccount = it.next();
			currentAccount.getAccountReport();
		} //End while
	} //printChAccounts()

	public void printSvAccounts(){
		Iterator<SavingsAccount> it = svAccounts.iterator();
		while(it.hasNext()){
			SavingsAccount currentAccount = it.next();
			currentAccount.getAccountReport();
		} //End while
	} //printSvAccounts()


} //End class def
