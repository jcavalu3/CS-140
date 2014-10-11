public class Customer implements Comparable<Customer> {
	private Person person;
	private BankAccount account;
	
	public Customer(String fname, String lname, char gender, double balance) {
		 this.person = new Person(fname, lname, gender);
		 this.account = new BankAccount(balance);
	}
	
	public double getAccountBalance(){
		return account.getBalance();
	}
	
	public Person getPerson(){
		return this.person;
	}
	
	public BankAccount getAccount(){
		return account;
	}
	
	public String toString() {
		String retVal = "null";
		StringBuilder builder = new StringBuilder(this.person.getID() + ": " + 
		this.person.getLastName() + ", " + this.person.getFirstName() + " (" + this.person.getGender() + "). Balance: " + this.account.getBalance());
		retVal = builder.toString();
		return retVal;
	}

	public int compareTo(Customer arg){
		if(account.getBalance() < arg.account.getBalance())
			return -1;
		else if(account.getBalance() > arg.account.getBalance())
			return 1;
		else
			return 0;
	}
}

