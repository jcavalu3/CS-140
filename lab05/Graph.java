package lab05;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * A component that draws a graphs of the
 * paths provided by the class that calls this one
 * @author CS 140
 */
public class Graph extends JComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2306361761813290431L;
	private Path2D.Double path = new Path2D.Double();
    private ArrayList<Point2D.Double> points = new ArrayList<>();
    private Path2D.Double path1 = new Path2D.Double();
    private ArrayList<Point2D.Double> points1 = new ArrayList<>();
    // radius of dot on graph
    private int r = 5;

    public Graph(double xOrg, double yOrg) {
        path.moveTo(xOrg, yOrg);
        path1.moveTo(xOrg, yOrg);
        points.add(new Point2D.Double(xOrg, yOrg));
        points1.add(new Point2D.Double(xOrg, yOrg));
    }

    public void addPoint(double x, double y, double x1, double y1) {
        path.lineTo(x, y);
        points.add(new Point2D.Double(x,y));
        path1.lineTo(x1, y1);
        points1.add(new Point2D.Double(x1,y1));
        repaint();
    }

    /**
     * Implementation of the paintComponent method
     * for this component. It draws a sequence of
     * straight lines between the points in the
     * paths provided to the component
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLUE);
        g2.draw(path);
        g2.setColor(Color.BLACK);
        for(Point2D.Double p : points) {
            g2.fill(new Ellipse2D.Double(p.x-r,p.y-r,2*r,2*r));
        }

        g2.setColor(Color.GREEN);
        g2.draw(path1);
        g2.setColor(Color.RED);
        for(Point2D.Double p : points1) {
            g2.fill(new Ellipse2D.Double(p.x-r,p.y-r,2*r,2*r));
        }
    }
}
