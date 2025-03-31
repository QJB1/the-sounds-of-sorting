package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

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

    @Override
    public void paintComponent(Graphics g) {
        // TODO: fill me in!
        super.paintComponent(g);

        Integer[] noteArray = notes.getNotes();
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / noteArray.length;

        for (int i = 0; i < noteArray.length; i++) {
            int barHeight = (int) ((double) noteArray[i] / (noteArray.length - 1) * height);

            if (notes.isHighlighted(i)) {
                g.setColor(java.awt.Color.RED); // highlight = red
            } else {
                // a green-to-blue gradient based on height
                float ratio = (float) noteArray[i] / (noteArray.length - 1);
                int red = 50;
                int green = (int) (255 * (1 - ratio));
                int blue = (int) (255 * ratio);
                g.setColor(new java.awt.Color(red, green, blue));
            }

            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
        /*
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Integer[] noteArray = notes.getNotes();
        int barWidth = width / noteArray.length;

        notes.clearAllHighlighted(); 

        for (int i = 0; i < noteArray.length; i++) {
            int barHeight = (int) ((double) noteArray[i] / (noteArray.length - 1) * height);
            if (notes.isHighlighted(i)) {
                g.setColor(java.awt.Color.RED);
            } else {
                g.setColor(java.awt.Color.BLACK);
            }
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
        */
    }
}