package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Collections;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private final int destinationIndex;
    private final T value;

    /**
     * Constructs a CopyEvent Object to copy a value to a destination index.
     *
     * @param destinationIndex the index the value is being copied to
     * @param value the value copied to the destinationIndex
     */
    public CopyEvent(int destinationIndex, T value) {
        this.destinationIndex = destinationIndex;
        this.value = value;
    }

    @Override
    public void apply(T[] arr) {
        arr[destinationIndex] = value;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return Collections.singletonList(destinationIndex);
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
