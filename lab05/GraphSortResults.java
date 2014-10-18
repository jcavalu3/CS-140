package lab05;

import java.util.Random;

import javax.swing.JFrame;
/**
 * Driver class that creates a JFrame to hold the
 * component that shows a drawing of two paths,
 * connecting the points provided by the main method.
 *
 * @author CS 140
 *
 */
public class GraphSortResults {

    /**
     * Main method draws a JFrame and places the
     * component with graphs of the time taken by the
     * sorts
     * @param args command line arguments are not used
     */

    public static void main(String[] args) {
        final int FRAME_WIDTH = 540;
        final int FRAME_HEIGHT = 600;
        final int LEFT_OFFSET = 20;
        final int HORIZ_GAP = 50;
        final int TOP_OFFSET = 50;
        final int MEASURED_MAX = 200000; // May need adjusting
        Sorter sorter1 = new BubbleSorter();
        Sorter sorter2 = new MergeSorter();
        JFrame frame = new JFrame();;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Times");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graph component = new Graph(LEFT_OFFSET,FRAME_HEIGHT-TOP_OFFSET);

        frame.add(component);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Random r = new Random();
        int factor = 30000;
        double[] x = {0,1,2,3,4,5,6,7,8,9,10};
        double[] y = new double[x.length];
        double[] sample;
        double[] y1 = new double[x.length];
        double[] copy;
        for (int i = 1; i < x.length; i++) {
            sample = new double[factor*i];
            for(int j = 0; j < sample.length; j++) {
                sample[j] = r.nextDouble();
            }
            copy = sample.clone();
            y[i] = sorter1.timedSort(sample);
            System.out.println(y[i]);

            y1[i] = sorter2.timedSort(copy);
            System.out.println(y1[i]);
            component.addPoint(LEFT_OFFSET+HORIZ_GAP*x[i],
                    (FRAME_HEIGHT-TOP_OFFSET)*(1 - y[i]/MEASURED_MAX),
                    LEFT_OFFSET+HORIZ_GAP*x[i],
                    (FRAME_HEIGHT-TOP_OFFSET)*(1 - y1[i]/MEASURED_MAX));
        }
    }
}
