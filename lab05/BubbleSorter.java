package lab05;

public class BubbleSorter implements Sorter {

    /**
     * Method that sorts the parameter array into increasing order
     * using the simplest version of the bubble sort algorithm and
     * returns the time taken in milliseconds.
     * @param array array to be sorted
     * @return the time taken to sort the array
     */
    @Override
    public double timedSort(double[] array) {
        long start = System.currentTimeMillis();
        boolean changed = true;
        while(changed) {
        	changed = false;
        	for(int i = 0; i < array.length - 1; i++) {
        		if(array[i + 1] < array[i]) {
        			array[i] = array[i] + array[i + 1];
        			array[i + 1] = array[i] - array[i + 1];
        			array[i] = array[i] - array[i + 1];
        			changed = true;
        		}
        	}
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
