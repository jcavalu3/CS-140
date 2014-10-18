package lab05;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class SelectionArea extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4438259023740325645L;
	/**
	 * 
	 */
    private int baseOfMoveMouseX;
    private int baseOfMoveMouseY;
    private double baseOfMoveRectX;
    private double baseOfMoveRectY;
    private boolean movingMode = false;
    private boolean draggingFigure = false;
    
//	private static final long serialVersionUID = 8006478726035528594L;
	// When you open this code in Eclipse, click on the warning above and
    // have Eclipse generate a serial version UID, or use the serialver tool
    // that is in the same folder as the compiler javac
    private Rectangle2D.Double currentRect = new Rectangle2D.Double();
    private Rectangle2D.Double rectToDraw = new Rectangle2D.Double();
    private Rectangle2D.Double previousRectDrawn = new Rectangle2D.Double();
    private SelectionDemo controller;

    public SelectionArea(SelectionDemo controller) {
        this.controller = controller;
        addMouseListener(MouseListenerFactory.mousePressedHandler(e -> {
//            int x = e.getX();
//            int y = e.getY();
//            currentRect.setRect(x, y, 0, 0);
//            updateDrawableRect(getWidth(), getHeight());
//            repaint();
        	int x = e.getX();
        	int y = e.getY();
        	if (movingMode) {
        		if(currentRect.contains(x, y)) {
        			draggingFigure = true;
        			baseOfMoveMouseX = x;
        			baseOfMoveMouseY = y;
        			baseOfMoveRectX = currentRect.x;
        			baseOfMoveRectY = currentRect.y;
        		}
        	} else {
        		currentRect.setRect(x, y, 0, 0);
        		updateDrawableRect(getWidth(), getHeight());
        		repaint();
        	}
        }));
        addMouseListener(MouseListenerFactory.mouseReleasedHandler(e -> {
//            updateSize(e);
        	if(movingMode) {
               	if(draggingFigure) {
               		updatePosition(e);
               	}
        	} else {
        		updateSize1(e);
        	}
        	movingMode = !movingMode;
        	draggingFigure = false;
        }));
        
        addMouseMotionListener(MouseListenerFactory.mouseDraggedHandler(e -> {
        //    updateSize(e);
        	if(movingMode) {
        		if(draggingFigure) {
        			updatePosition(e);
        		}
        	} else {
        		updateSize1(e);
        	}
        }));

    }

    void updatePosition(MouseEvent e) {
    	int x = e.getX();
    	int y = e.getY();
    	int dispX = x - baseOfMoveMouseX;
    	int dispY = y - baseOfMoveMouseY;
    	currentRect.setRect(baseOfMoveRectX + dispX, baseOfMoveRectY + dispY,
    			currentRect.width, currentRect.height);
    	updateDrawableRect(getWidth(), getHeight());
    	Rectangle2D.Double totalRepaint = new Rectangle2D.Double();
    	Rectangle2D.Double.union(rectToDraw, previousRectDrawn, totalRepaint);
    	repaint((int)totalRepaint.x-4, (int)totalRepaint.y-4,
    			(int)totalRepaint.width+5, (int)totalRepaint.height+5);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //paints the background and image
        //Cast the Graphics context to Graphics2D
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(4));
        Rectangle2D.Double temp = new Rectangle2D.Double(
                rectToDraw.x, rectToDraw.y,
                rectToDraw.width - 1, rectToDraw.height - 1);
        Color color = Color.BLUE;
        g2.setColor(color);
        g2.draw(temp);
        Color fillColor = Color.YELLOW;
        g2.setColor(fillColor);
        g2.fill(temp);
        controller.updateLabel(rectToDraw);
    }

    public void updateDrawableRect(int compWidth, int compHeight) {
        double x = currentRect.x;
        double y = currentRect.y;
        double width = currentRect.width;
        double height = currentRect.height;

        //Make the width and height positive, if necessary.
        if (width < 0) {
            width = 0 - width;
            x = x - width + 1;
            if (x < 0) {
                width += x;
                x = 0;
            }
        }
        if (height < 0) {
            height = 0 - height;
            y = y - height + 1;
            if (y < 0) {
                height += y;
                y = 0;
            }
        }

        //The rectangle shouldn't extend past the drawing area.
        if ((x + width) > compWidth) {
            width = compWidth - x;
        }
        if ((y + height) > compHeight) {
            height = compHeight - y;
        }

        //Update rectToDraw after saving old value.
        if (rectToDraw != null) {
            previousRectDrawn.setFrame(
                    rectToDraw.x, rectToDraw.y,
                    rectToDraw.width, rectToDraw.height);
            rectToDraw.setFrame(x, y, width, height);
        } else {
            rectToDraw = new Rectangle2D.Double(x, y, width, height);
        }
    }

//    /*
//     * Update the size of the current rectangle and call repaint.
//     * Because currentRect always has the same origin, translate it if the
//     * width or height is negative.
//     *
//     * For efficiency (though that isn't an issue for this program),
//     * specify the painting region using arguments to the repaint() call.
//     *
//     */
//    void updateSize(MouseEvent e) {
//        int x = e.getX();
//        int y = e.getY();
//        currentRect.setRect(currentRect.x, currentRect.y,
//                x - currentRect.x, y - currentRect.y);
//        updateDrawableRect(getWidth(), getHeight());
//        Rectangle2D.Double totalRepaint = new Rectangle2D.Double();
//        Rectangle2D.Double.union(rectToDraw, previousRectDrawn, totalRepaint);
//        repaint((int)totalRepaint.x-4, (int)totalRepaint.y-4,
//                (int)totalRepaint.width+5, (int)totalRepaint.height+5);
//    }
    
    /*
     * Update the size of the current rectangle and call repaint.
     * Because currentRect always has the same origin, translate it if the
     * width or height is negative.
     *
     * For efficiency (though that isn't an issue for this program),
     * specify the painting region using arguments to the repaint() call.
     *
     */
    void updateSize1(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        currentRect.setRect(currentRect.x, currentRect.y,
                x - currentRect.x, y - currentRect.y);
        updateDrawableRect(getWidth(), getHeight());
        Rectangle2D.Double totalRepaint = new Rectangle2D.Double();
        Rectangle2D.Double.union(rectToDraw, previousRectDrawn, totalRepaint);
        repaint((int)totalRepaint.x-4, (int)totalRepaint.y-4,
                (int)totalRepaint.width+5, (int)totalRepaint.height+5);
    }

}
