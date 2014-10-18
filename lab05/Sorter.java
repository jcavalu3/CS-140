package lab05;


/**
 * Interface for timed sort methods.
 * @author CS 140
 *
 */
public interface Sorter {
    /**
     * Method that sorts the parameter array into increasing order
     * and returns the time taken in milliseconds
     * @param array array to be sorted
     * @return the time taken to sort the array
     */
    public double timedSort(double[] array);
}

