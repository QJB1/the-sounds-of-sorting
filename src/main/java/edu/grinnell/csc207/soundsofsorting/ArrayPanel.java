package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    // @SuppressWarnings("unused")      // removed this line
    private NoteIndices notes;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Creates all the graphics and bars, and adjusts the color and height continuously
     * 
     * @param g the Graphics library for drawing onto
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Integer[] noteArray = notes.getNotes();
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / noteArray.length;

        for (int i = 0; i < noteArray.length; i++) {
            // calculates the height of the bars based on noteArray length
            double ratio = (double) noteArray[i] / (noteArray.length - 1);
            int barHeight = (int) (ratio * height);

            // changes the highlighted color to red and calculates the green & blue gradients
            if (notes.isHighlighted(i)) {
                g.setColor(Color.RED);
            } else {
                int red = 50;
                int green = (int) (255 * (1 - ratio));
                int blue = (int) (255 * ratio);
                g.setColor(new Color(red, green, blue));
            }

            // draws the bar at the bottom
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
    }
    
}