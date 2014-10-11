public class Exam1 {

	private double[] store = new double[]{0.0};
	private int numElem;
	private int cap;

	/**
	 *
	 * Creates a copy of an array with the new given capacity.
	 *
	 * @param newCap is the desired capacity of the array
	 * @return storeCopy is the new array with the new capacity
	 */
	private double[] copy(int newCap) {
		if(newCap <= store.length)
			return null;
		else {
			double[] storeCopy = new double[newCap];
			for(int i = 0; i < store.length; i++)
				storeCopy[i] = store[i];
			return storeCopy;
		}
	}
	
	public void setArray(double[] array) {
		if(array != null && array.length > 0) {
			store = array;
			cap = store.length;
			numElem = store.length;
		}
	}

	public void add(double d) {
		if(numElem == cap) {
			store = copy(2*cap);
			cap = 2*cap;
		}
		store[numElem] = d;
		numElem++;
	}

	public double average() {
		double retAv = 0;
		double dubNumElem = numElem;
		for(int i = 0; i < numElem; i++)
			retAv = retAv + store[i];
		retAv = retAv / numElem;
		return retAv;
	}
	
	public double[] getArray() {
		return store;
	}

	public static void main(String[] args) {
		Exam1 test = new Exam1();
		test.setArray(new double[]{7.5,4.5,12});
		test.add(2.5);
		test.add(3.5);
		System.out.println(test.average());
	}
}
