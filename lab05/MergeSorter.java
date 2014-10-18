package lab05;

import java.util.Arrays;

/**
 * This class sorts an array, using the merge sort algorithm.
 * Copied but modified from Horstmann
 */
public class MergeSorter implements Sorter{

	@Override
    public double timedSort(double[] array) {
        long start = System.currentTimeMillis();
        mergeSort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * Sorts the array using merge sort.
     * @param array array to be sorted
     * @return the time taken to sort the array
     */
    public void mergeSort(double[] array) {
        if (array.length > 1) {
            double[] first = Arrays.copyOf(array,array.length / 2);
            double[] second = Arrays.copyOfRange(array, first.length, array.length);

            mergeSort(first);
            mergeSort(second);
            //merge back into array;
            int iFirst = 0;
            int iSecond = 0;
            int j = 0;
            while (iFirst < first.length && iSecond < second.length) {
            	if(first[iFirst] < second[iSecond]) {
            		array[j] = first[iFirst];
            		iFirst++;
            		j++;
            	} else {
            		array[j] = second[iSecond];
            		iSecond++;
            		j++;
            	}
// if first[iFirst] < second[iSecond]
// copy first[iFirst] to array[j] and increment iFirst
// else copy second[iSecond] to array[j] and increment iSecond
// in either case increment j
            }
            System.arraycopy(first, iFirst, array, j, first.length - iFirst);
            System.arraycopy(second, iSecond, array, j, second.length - iSecond);
        }
    }
}
