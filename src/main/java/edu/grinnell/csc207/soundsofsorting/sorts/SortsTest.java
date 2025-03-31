package edu.grinnell.csc207.soundsofsorting.sorts;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;

public class SortsTest {

    private void checkSort(Integer[] expected, List<SortEvent<Integer>> events) {
        Integer[] copy = Arrays.copyOf(expected, expected.length);
        Sorts.eventSort(copy, events);
        assertArrayEquals(expected, copy);
    }

    @Test
    public void testSelectionSort() {
        checkSort(new Integer[]{1, 2, 3, 4, 5}, Sorts.selectionSort(new Integer[]{4, 2, 5, 1, 3}));
        checkSort(new Integer[]{1, 2, 3}, Sorts.selectionSort(new Integer[]{1, 2, 3}));
        checkSort(new Integer[]{1, 2, 3}, Sorts.selectionSort(new Integer[]{3, 2, 1}));
        checkSort(new Integer[]{3, 3, 3}, Sorts.selectionSort(new Integer[]{3, 3, 3}));
        checkSort(new Integer[]{}, Sorts.selectionSort(new Integer[]{}));
    }

    @Test
    public void testInsertionSort() {
        checkSort(new Integer[]{2, 4, 6, 8, 9}, Sorts.insertionSort(new Integer[]{8, 4, 6, 2, 9}));
        checkSort(new Integer[]{1, 2, 5, 5}, Sorts.insertionSort(new Integer[]{5, 1, 5, 2}));
        checkSort(new Integer[]{1}, Sorts.insertionSort(new Integer[]{1}));
        checkSort(new Integer[]{}, Sorts.insertionSort(new Integer[]{}));
    }

    @Test
    public void testBubbleSort() {
        checkSort(new Integer[]{1, 2, 3, 4}, Sorts.bubbleSort(new Integer[]{1, 4, 2, 3}));
        checkSort(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Sorts.bubbleSort(new Integer[]{7, 6, 5, 4, 3, 2, 1}));
        checkSort(new Integer[]{1, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 2, 3}));
        checkSort(new Integer[]{}, Sorts.bubbleSort(new Integer[]{}));
    }

    @Test
    public void testMergeSort() {
        checkSort(new Integer[]{2, 5, 6, 8, 9}, Sorts.mergeSort(new Integer[]{9, 5, 2, 6, 8}));
        checkSort(new Integer[]{1, 2, 3, 3, 3}, Sorts.mergeSort(new Integer[]{1, 3, 3, 3, 2}));
        checkSort(new Integer[]{1, 4}, Sorts.mergeSort(new Integer[]{4, 1}));
        checkSort(new Integer[]{}, Sorts.mergeSort(new Integer[]{}));
    }

    @Test
    public void testQuickSort() {
        checkSort(new Integer[]{1, 2, 4, 6, 7, 9}, Sorts.quickSort(new Integer[]{9, 4, 6, 2, 7, 1}));
        checkSort(new Integer[]{2, 2, 2, 2}, Sorts.quickSort(new Integer[]{2, 2, 2, 2}));
        checkSort(new Integer[]{}, Sorts.quickSort(new Integer[]{}));
        checkSort(new Integer[]{1, 3}, Sorts.quickSort(new Integer[]{3, 1}));
    }

    @Test
    public void testHeapSort() {
        checkSort(new Integer[]{1, 3, 5, 7, 10}, Sorts.heapSort(new Integer[]{10, 3, 7, 1, 5}));
        checkSort(new Integer[]{5, 5, 5, 5, 5}, Sorts.heapSort(new Integer[]{5, 5, 5, 5, 5}));
        checkSort(new Integer[]{}, Sorts.heapSort(new Integer[]{}));
        checkSort(new Integer[]{50, 100}, Sorts.heapSort(new Integer[]{100, 50}));
    }
}

/*
package edu.grinnell.csc207.soundsofsorting.sorts;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;

public class SortsTest {

    @Test
    public void testSelectionSort() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, Sorts.eventSort(new Integer[]{4, 2, 5, 1, 3}, Sorts.selectionSort(new Integer[]{4, 2, 5, 1, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{1, 2, 3}, Sorts.selectionSort(new Integer[]{1, 2, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{3, 2, 1}, Sorts.selectionSort(new Integer[]{3, 2, 1})));
        assertArrayEquals(new Integer[]{3, 3, 3}, Sorts.eventSort(new Integer[]{3, 3, 3}, Sorts.selectionSort(new Integer[]{3, 3, 3})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.selectionSort(new Integer[]{})));
    }

    @Test
    public void testInsertionSort() {
        assertArrayEquals(new Integer[]{2, 4, 6, 8, 9}, Sorts.eventSort(new Integer[]{8, 4, 6, 2, 9}, Sorts.insertionSort(new Integer[]{8, 4, 6, 2, 9})));
        assertArrayEquals(new Integer[]{1, 2, 5, 5}, Sorts.eventSort(new Integer[]{5, 1, 5, 2}, Sorts.insertionSort(new Integer[]{5, 1, 5, 2})));
        assertArrayEquals(new Integer[]{1}, Sorts.eventSort(new Integer[]{1}, Sorts.insertionSort(new Integer[]{1})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.insertionSort(new Integer[]{})));
    }

    @Test
    public void testBubbleSort() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, Sorts.eventSort(new Integer[]{1, 4, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 4, 2, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Sorts.eventSort(new Integer[]{7, 6, 5, 4, 3, 2, 1}, Sorts.bubbleSort(new Integer[]{7, 6, 5, 4, 3, 2, 1})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{1, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 2, 3})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.bubbleSort(new Integer[]{})));
    }

    @Test
    public void testMergeSort() {
        assertArrayEquals(new Integer[]{2, 5, 6, 8, 9}, Sorts.eventSort(new Integer[]{9, 5, 2, 6, 8}, Sorts.mergeSort(new Integer[]{9, 5, 2, 6, 8})));
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 3}, Sorts.eventSort(new Integer[]{1, 3, 3, 3, 2}, Sorts.mergeSort(new Integer[]{1, 3, 3, 3, 2})));
        assertArrayEquals(new Integer[]{1, 4}, Sorts.eventSort(new Integer[]{4, 1}, Sorts.mergeSort(new Integer[]{4, 1})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.mergeSort(new Integer[]{})));
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(new Integer[]{1, 2, 4, 6, 7, 9}, Sorts.eventSort(new Integer[]{9, 4, 6, 2, 7, 1}, Sorts.quickSort(new Integer[]{9, 4, 6, 2, 7, 1})));
        assertArrayEquals(new Integer[]{2, 2, 2, 2}, Sorts.eventSort(new Integer[]{2, 2, 2, 2}, Sorts.quickSort(new Integer[]{2, 2, 2, 2})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.quickSort(new Integer[]{})));
        assertArrayEquals(new Integer[]{1, 3}, Sorts.eventSort(new Integer[]{3, 1}, Sorts.quickSort(new Integer[]{3, 1})));
    }

    @Test
    public void testHeapSort() {
        assertArrayEquals(new Integer[]{1, 3, 5, 7, 10}, Sorts.eventSort(new Integer[]{10, 3, 7, 1, 5}, Sorts.heapSort(new Integer[]{10, 3, 7, 1, 5})));
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, Sorts.eventSort(new Integer[]{5, 5, 5, 5, 5}, Sorts.heapSort(new Integer[]{5, 5, 5, 5, 5})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.heapSort(new Integer[]{})));
        assertArrayEquals(new Integer[]{50, 100}, Sorts.eventSort(new Integer[]{100, 50}, Sorts.heapSort(new Integer[]{100, 50})));
    }
}
*/


/* 

package edu.grinnell.csc207.soundsofsorting.sorts;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;

public class SortsTest {

    @Test
    public void testSelectionSort() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, Sorts.eventSort(new Integer[]{4, 2, 5, 1, 3}, Sorts.selectionSort(new Integer[]{4, 2, 5, 1, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{1, 2, 3}, Sorts.selectionSort(new Integer[]{1, 2, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{3, 2, 1}, Sorts.selectionSort(new Integer[]{3, 2, 1})));
        assertArrayEquals(new Integer[]{3, 3, 3}, Sorts.eventSort(new Integer[]{3, 3, 3}, Sorts.selectionSort(new Integer[]{3, 3, 3})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.selectionSort(new Integer[]{})));
    }

    @Test
    public void testInsertionSort() {
        assertArrayEquals(new Integer[]{2, 4, 6, 8, 9}, Sorts.eventSort(new Integer[]{8, 4, 6, 2, 9}, Sorts.insertionSort(new Integer[]{8, 4, 6, 2, 9})));
        assertArrayEquals(new Integer[]{1, 2, 5, 5}, Sorts.eventSort(new Integer[]{5, 1, 5, 2}, Sorts.insertionSort(new Integer[]{5, 1, 5, 2})));
        assertArrayEquals(new Integer[]{1}, Sorts.eventSort(new Integer[]{1}, Sorts.insertionSort(new Integer[]{1})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.insertionSort(new Integer[]{})));
    }

    @Test
    public void testBubbleSort() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, Sorts.eventSort(new Integer[]{1, 4, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 4, 2, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Sorts.eventSort(new Integer[]{7, 6, 5, 4, 3, 2, 1}, Sorts.bubbleSort(new Integer[]{7, 6, 5, 4, 3, 2, 1})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{1, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 2, 3})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.bubbleSort(new Integer[]{})));
    }

    @Test
    public void testMergeSort() {
        assertArrayEquals(new Integer[]{2, 5, 6, 8, 9}, Sorts.eventSort(new Integer[]{9, 5, 2, 6, 8}, Sorts.mergeSort(new Integer[]{9, 5, 2, 6, 8})));
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 3}, Sorts.eventSort(new Integer[]{1, 3, 3, 3, 2}, Sorts.mergeSort(new Integer[]{1, 3, 3, 3, 2})));
        assertArrayEquals(new Integer[]{1, 4}, Sorts.eventSort(new Integer[]{4, 1}, Sorts.mergeSort(new Integer[]{4, 1})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.mergeSort(new Integer[]{})));
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(new Integer[]{1, 2, 4, 6, 7, 9}, Sorts.eventSort(new Integer[]{9, 4, 6, 2, 7, 1}, Sorts.quickSort(new Integer[]{9, 4, 6, 2, 7, 1})));
        assertArrayEquals(new Integer[]{2, 2, 2, 2}, Sorts.eventSort(new Integer[]{2, 2, 2, 2}, Sorts.quickSort(new Integer[]{2, 2, 2, 2})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.quickSort(new Integer[]{})));
        assertArrayEquals(new Integer[]{1, 3}, Sorts.eventSort(new Integer[]{3, 1}, Sorts.quickSort(new Integer[]{3, 1})));
    }

    @Test
    public void testHeapSort() {
        assertArrayEquals(new Integer[]{1, 3, 5, 7, 10}, Sorts.eventSort(new Integer[]{10, 3, 7, 1, 5}, Sorts.heapSort(new Integer[]{10, 3, 7, 1, 5})));
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, Sorts.eventSort(new Integer[]{5, 5, 5, 5, 5}, Sorts.heapSort(new Integer[]{5, 5, 5, 5, 5})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.heapSort(new Integer[]{})));
        assertArrayEquals(new Integer[]{50, 100}, Sorts.eventSort(new Integer[]{100, 50}, Sorts.heapSort(new Integer[]{100, 50})));
    }
}

*/



/*
package edu.grinnell.csc207.soundsofsorting.sorts;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;

public class SortsTest {

    private void checkSort(Integer[] expected, List<SortEvent<Integer>> events) {
        Integer[] copy = Arrays.copyOf(expected, expected.length);
        Sorts.eventSort(copy, events);
        assertArrayEquals(expected, copy);
    }

    @Test
    public void testSelectionSort() {
        checkSort(new Integer[]{1, 2, 3, 4, 5}, Sorts.selectionSort(new Integer[]{4, 2, 5, 1, 3}));
        checkSort(new Integer[]{1, 2, 3}, Sorts.selectionSort(new Integer[]{1, 2, 3}));
        checkSort(new Integer[]{1, 2, 3}, Sorts.selectionSort(new Integer[]{3, 2, 1}));
        checkSort(new Integer[]{3, 3, 3}, Sorts.selectionSort(new Integer[]{3, 3, 3}));
        checkSort(new Integer[]{}, Sorts.selectionSort(new Integer[]{}));
    }

    @Test
    public void testInsertionSort() {
        checkSort(new Integer[]{2, 4, 6, 8, 9}, Sorts.insertionSort(new Integer[]{8, 4, 6, 2, 9}));
        checkSort(new Integer[]{1, 2, 5, 5}, Sorts.insertionSort(new Integer[]{5, 1, 5, 2}));
        checkSort(new Integer[]{1}, Sorts.insertionSort(new Integer[]{1}));
        checkSort(new Integer[]{}, Sorts.insertionSort(new Integer[]{}));
    }

    @Test
    public void testBubbleSort() {
        checkSort(new Integer[]{1, 2, 3, 4}, Sorts.bubbleSort(new Integer[]{1, 4, 2, 3}));
        checkSort(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Sorts.bubbleSort(new Integer[]{7, 6, 5, 4, 3, 2, 1}));
        checkSort(new Integer[]{1, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 2, 3}));
        checkSort(new Integer[]{}, Sorts.bubbleSort(new Integer[]{}));
    }

    @Test
    public void testMergeSort() {
        checkSort(new Integer[]{2, 5, 6, 8, 9}, Sorts.mergeSort(new Integer[]{9, 5, 2, 6, 8}));
        checkSort(new Integer[]{1, 2, 3, 3, 3}, Sorts.mergeSort(new Integer[]{1, 3, 3, 3, 2}));
        checkSort(new Integer[]{1, 4}, Sorts.mergeSort(new Integer[]{4, 1}));
        checkSort(new Integer[]{}, Sorts.mergeSort(new Integer[]{}));
    }

    @Test
    public void testQuickSort() {
        checkSort(new Integer[]{1, 2, 4, 6, 7, 9}, Sorts.quickSort(new Integer[]{9, 4, 6, 2, 7, 1}));
        checkSort(new Integer[]{2, 2, 2, 2}, Sorts.quickSort(new Integer[]{2, 2, 2, 2}));
        checkSort(new Integer[]{}, Sorts.quickSort(new Integer[]{}));
        checkSort(new Integer[]{1, 3}, Sorts.quickSort(new Integer[]{3, 1}));
    }

    @Test
    public void testHeapSort() {
        checkSort(new Integer[]{1, 3, 5, 7, 10}, Sorts.heapSort(new Integer[]{10, 3, 7, 1, 5}));
        checkSort(new Integer[]{5, 5, 5, 5, 5}, Sorts.heapSort(new Integer[]{5, 5, 5, 5, 5}));
        checkSort(new Integer[]{}, Sorts.heapSort(new Integer[]{}));
        checkSort(new Integer[]{50, 100}, Sorts.heapSort(new Integer[]{100, 50}));
    }
}







package edu.grinnell.csc207.soundsofsorting.sorts;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;

public class SortsTest {

    @Test
    public void testSelectionSort() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, Sorts.eventSort(new Integer[]{4, 2, 5, 1, 3}, Sorts.selectionSort(new Integer[]{4, 2, 5, 1, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{1, 2, 3}, Sorts.selectionSort(new Integer[]{1, 2, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{3, 2, 1}, Sorts.selectionSort(new Integer[]{3, 2, 1})));
        assertArrayEquals(new Integer[]{3, 3, 3}, Sorts.eventSort(new Integer[]{3, 3, 3}, Sorts.selectionSort(new Integer[]{3, 3, 3})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.selectionSort(new Integer[]{})));
    }

    @Test
    public void testInsertionSort() {
        assertArrayEquals(new Integer[]{2, 4, 6, 8, 9}, Sorts.eventSort(new Integer[]{8, 4, 6, 2, 9}, Sorts.insertionSort(new Integer[]{8, 4, 6, 2, 9})));
        assertArrayEquals(new Integer[]{1, 2, 5, 5}, Sorts.eventSort(new Integer[]{5, 1, 5, 2}, Sorts.insertionSort(new Integer[]{5, 1, 5, 2})));
        assertArrayEquals(new Integer[]{1}, Sorts.eventSort(new Integer[]{1}, Sorts.insertionSort(new Integer[]{1})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.insertionSort(new Integer[]{})));
    }

    @Test
    public void testBubbleSort() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, Sorts.eventSort(new Integer[]{1, 4, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 4, 2, 3})));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Sorts.eventSort(new Integer[]{7, 6, 5, 4, 3, 2, 1}, Sorts.bubbleSort(new Integer[]{7, 6, 5, 4, 3, 2, 1})));
        assertArrayEquals(new Integer[]{1, 2, 3}, Sorts.eventSort(new Integer[]{1, 2, 3}, Sorts.bubbleSort(new Integer[]{1, 2, 3})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.bubbleSort(new Integer[]{})));
    }

    @Test
    public void testMergeSort() {
        assertArrayEquals(new Integer[]{2, 5, 6, 8, 9}, Sorts.eventSort(new Integer[]{9, 5, 2, 6, 8}, Sorts.mergeSort(new Integer[]{9, 5, 2, 6, 8})));
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 3}, Sorts.eventSort(new Integer[]{1, 3, 3, 3, 2}, Sorts.mergeSort(new Integer[]{1, 3, 3, 3, 2})));
        assertArrayEquals(new Integer[]{1, 4}, Sorts.eventSort(new Integer[]{4, 1}, Sorts.mergeSort(new Integer[]{4, 1})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.mergeSort(new Integer[]{})));
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(new Integer[]{1, 2, 4, 6, 7, 9}, Sorts.eventSort(new Integer[]{9, 4, 6, 2, 7, 1}, Sorts.quickSort(new Integer[]{9, 4, 6, 2, 7, 1})));
        assertArrayEquals(new Integer[]{2, 2, 2, 2}, Sorts.eventSort(new Integer[]{2, 2, 2, 2}, Sorts.quickSort(new Integer[]{2, 2, 2, 2})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.quickSort(new Integer[]{})));
        assertArrayEquals(new Integer[]{1, 3}, Sorts.eventSort(new Integer[]{3, 1}, Sorts.quickSort(new Integer[]{3, 1})));
    }

    @Test
    public void testHeapSort() {
        assertArrayEquals(new Integer[]{1, 3, 5, 7, 10}, Sorts.eventSort(new Integer[]{10, 3, 7, 1, 5}, Sorts.heapSort(new Integer[]{10, 3, 7, 1, 5})));
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, Sorts.eventSort(new Integer[]{5, 5, 5, 5, 5}, Sorts.heapSort(new Integer[]{5, 5, 5, 5, 5})));
        assertArrayEquals(new Integer[]{}, Sorts.eventSort(new Integer[]{}, Sorts.heapSort(new Integer[]{})));
        assertArrayEquals(new Integer[]{50, 100}, Sorts.eventSort(new Integer[]{100, 50}, Sorts.heapSort(new Integer[]{100, 50})));
    }
}
*/
