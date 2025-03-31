package edu.grinnell.csc207.soundsofsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private Integer[] notes;
    private Set<Integer> highlighted;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        notes = new Integer[n];
        highlighted = new HashSet<>();
        for (int i = 0; i < n; i++) {
            notes[i] = i;
        }
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        notes = new Integer[n];
        for (int i = 0; i < n; i++) {
            notes[i] = i;
        }
        Collections.shuffle(Arrays.asList(notes));
        highlighted.clear();
        
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return notes;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        highlighted.add(index);
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return highlighted.contains(index);
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        highlighted.clear();
    }
}
