public class Person {
	
	private String fname;
	private String lname;
	private char gender;
	private int id;
	private static int nextId = 10001;

	public Person(String fname, String lname, char gender){
		id = nextId++;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
	}
	
	public String toString() {
		String retVal = "null";
		StringBuilder builder = new StringBuilder("\n" + id + ": " + 
		lname + ", " + fname + " (" + gender + ")");
		retVal = builder.toString();
		return retVal;
	}
	
	public String getFirstName(){
		return this.fname;
	}
	
	public String getLastName(){
		return this.lname;
	}
	
	public char getGender(){
		return this.gender;
	}
	
	public int getID(){
		return this.id;
	}
}
