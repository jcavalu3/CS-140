import java.util.ArrayList;

public class Exam1A {
	private ArrayList<Double> store = new ArrayList<Double>();
//	{	store.add(0.0);	}
	
	public void setStore(double[] array){
		for(int i = 0; i < array.length; i++)
			store.add(array[i]);
	}
	
	public void add(double d){
		store.add(d);
	}
	
	public ArrayList<Double> getArray(){
		return store;
	}
	
	public double average() {
			double retAv = 0.0;
			for(int i = 0; i < store.size(); i++)
				retAv = retAv + store.get(i);
			retAv = retAv / store.size();
			return retAv;
			
	}
	
	public static void main(String[] args) {
		Exam1A test = new Exam1A();
		test.setStore(new double[]{7.5,4.5,12});
		test.add(2.5);
		test.add(3.5);
		System.out.println(test.average());
	}
}
