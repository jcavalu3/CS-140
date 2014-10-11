import java.util.Arrays;

public class DriverQ2B {
	
	public static Customer1[] fourRichest(Customer1[] customers){
		Customer1[] richest = new Customer1[4];

		// variable to hold balances of richest four persons
		double[] balances = new double[4];
		
		// clears the balance to skip the previous richest person
		int clear = 0;
		
		// accounting for empty or null customers array
		if(customers == null) 
			return null;
		
		// loop to assign the 4 largest balances to richest array
		for(int tally = 0; tally < 4; tally++){
			clear = 0;
			// loop to check for next largest balance
			for(int i = 0; i < 1000; i++){
				// check to see if first element of richest has been assigned a customer yet
				if(tally == 0){
					// if first element is empty, assign customer to it
					if(richest[tally] == null){
						richest[tally] = customers[i];
						balances[tally] = customers[i].getAccountBalance();
						clear = i;
					} else
						// if the balance of the given customer is greater than the first customer in richest array
					if(customers[i].getAccountBalance() > richest[tally].getAccountBalance()){
						richest[tally] = customers[i];
						balances[tally] = customers[i].getAccountBalance();
						clear = i;
					}
				} else {
					if(richest[tally] == null){
						richest[tally] = customers[i];
						balances[tally] = customers[i].getAccountBalance();
						clear = i;
					}
					if(customers[i].getAccountBalance() == balances[tally - 1]){
						richest[tally] = customers[i];
						balances[tally] = customers[i].getAccountBalance();
						clear = i;
					} else
						if(customers[i].getAccountBalance() > richest[tally].getAccountBalance()){
							richest[tally] = customers[i];
							balances[tally] = customers[i].getAccountBalance();
							clear = i;
						}
				}
				if(i == 999)
					customers[clear].getAccount().setBalance(0.0);
			}
		}
		for(int i = 0; i < 4; i++){
			richest[i].getAccount().setBalance(balances[i]);
		}
		return richest;
	}
	
	public static void main(String[] args) {
		Customer1[] arrCustomer = new Customer1[1000];
		Customer1[] newArray = new Customer1[4];
		
		for(int i = 0; i < 500; i++)
			arrCustomer[i] = new Customer1(NamesResource.getRandomFeMaleFirstName(), NamesResource.getLastName(i), 'F', Math.round(1000000*Math.random())/100.0);
		for(int i = 500; i < 1000; i++){
			arrCustomer[i] = new Customer1(NamesResource.getRandomMaleFirstName(), NamesResource.getLastName(i), 'M', Math.round(1000000*Math.random())/100.0);
		}
		newArray = fourRichest(arrCustomer);
		for(int i = 0; i < 4; i++)	
			System.out.println(newArray[i]);
		Arrays.sort(newArray, (c1,c2) -> {
			int retVal = 0;
			if(c1 == c2)
				retVal = 1;
			else
				retVal = -1;
			return retVal;
		});
	}
}
