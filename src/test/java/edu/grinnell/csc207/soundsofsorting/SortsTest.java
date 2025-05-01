package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;   // for assertArrayEquals
import org.junit.jupiter.api.Test;                                 // for @Test

import java.util.Arrays;
import java.util.List;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;


/**
 * Unit tests for the Sorts class. Checks that each sorting algorithm
 * correctly sorts an Integer array.
 */
public class SortsTest {

    /**
     * Applies the sort events parameters to a copy of the expected array and
     * asserts that the sorting yields the expected result.
     *
     * @param input the original unsorted Integer array
     * @param expected the correctly sorted Integer array
     * @param events the list of SortEvent to sort
     */
    private void checkSort(Integer[] input, Integer[] expected, List<SortEvent<Integer>> events) {
        Integer[] copy = Arrays.copyOf(input, input.length);
        Sorts.eventSort(copy, events);
        assertArrayEquals(expected, copy);
    }

    /**
     * Tests selectionSort on different arrays: unsorted, sorted,
     * reverse sorted, equal, and empty.
     */
    @Test
    public void testSelectionSort() {
        Integer[] in1 = new Integer[]{4, 2, 5, 1, 3};
        Integer[] ex1 = new Integer[]{1, 2, 3, 4, 5};
        checkSort(in1, ex1, Sorts.selectionSort(in1.clone()));

        Integer[] in2 = new Integer[]{1, 2, 3};
        Integer[] ex2 = new Integer[]{1, 2, 3};
        checkSort(in2, ex2, Sorts.selectionSort(in2.clone()));

        Integer[] in3 = new Integer[]{3, 2, 1};
        Integer[] ex3 = new Integer[]{1, 2, 3};
        checkSort(in3, ex3, Sorts.selectionSort(in3.clone()));

        Integer[] in4 = new Integer[]{3, 3, 3};
        Integer[] ex4 = new Integer[]{3, 3, 3};
        checkSort(in4, ex4, Sorts.selectionSort(in4.clone()));

        Integer[] in5 = new Integer[]{};
        Integer[] ex5 = new Integer[]{};
        checkSort(in5, ex5, Sorts.selectionSort(in5.clone()));
    }

    /**
     * Tests insertionSort on unsorted, partially sorted,
     * single-element, and empty arrays.
     */
    @Test
    public void testInsertionSort() {
        Integer[] in1 = new Integer[]{8, 4, 6, 2, 9};
        Integer[] ex1 = new Integer[]{2, 4, 6, 8, 9};
        checkSort(in1, ex1, Sorts.insertionSort(in1.clone()));

        Integer[] in2 = new Integer[]{5, 1, 5, 2};
        Integer[] ex2 = new Integer[]{1, 2, 5, 5};
        checkSort(in2, ex2, Sorts.insertionSort(in2.clone()));

        Integer[] in3 = new Integer[]{1};
        Integer[] ex3 = new Integer[]{1};
        checkSort(in3, ex3, Sorts.insertionSort(in3.clone()));

        Integer[] in4 = new Integer[]{};
        Integer[] ex4 = new Integer[]{};
        checkSort(in4, ex4, Sorts.insertionSort(in4.clone()));
    }

    /**
     * Tests bubbleSort on small unsorted, reverse sorted,
     * already sorted, and empty arrays.
     */
    @Test
    public void testBubbleSort() {
        Integer[] in1 = new Integer[]{1, 4, 2, 3};
        Integer[] ex1 = new Integer[]{1, 2, 3, 4};
        checkSort(in1, ex1, Sorts.bubbleSort(in1.clone()));

        Integer[] in2 = new Integer[]{7, 6, 5, 4, 3, 2, 1};
        Integer[] ex2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        checkSort(in2, ex2, Sorts.bubbleSort(in2.clone()));

        Integer[] in3 = new Integer[]{1, 2, 3};
        Integer[] ex3 = new Integer[]{1, 2, 3};
        checkSort(in3, ex3, Sorts.bubbleSort(in3.clone()));

        Integer[] in4 = new Integer[]{};
        Integer[] ex4 = new Integer[]{};
        checkSort(in4, ex4, Sorts.bubbleSort(in4.clone()));
    }

    /**
     * Tests mergeSort on a variety of input sizes and orders.
     */
    @Test
    public void testMergeSort() {
        Integer[] in1 = new Integer[]{9, 5, 2, 6, 8};
        Integer[] ex1 = new Integer[]{2, 5, 6, 8, 9};
        checkSort(in1, ex1, Sorts.mergeSort(in1.clone()));

        Integer[] in2 = new Integer[]{1, 3, 3, 3, 2};
        Integer[] ex2 = new Integer[]{1, 2, 3, 3, 3};
        checkSort(in2, ex2, Sorts.mergeSort(in2.clone()));

        Integer[] in3 = new Integer[]{4, 1};
        Integer[] ex3 = new Integer[]{1, 4};
        checkSort(in3, ex3, Sorts.mergeSort(in3.clone()));

        Integer[] in4 = new Integer[]{};
        Integer[] ex4 = new Integer[]{};
        checkSort(in4, ex4, Sorts.mergeSort(in4.clone()));
    }

    /**
     * Tests quickSort on a variety of input sizes and orders.
     */
    @Test
    public void testQuickSort() {
        Integer[] in1 = new Integer[]{9, 4, 6, 2, 7, 1};
        Integer[] ex1 = new Integer[]{1, 2, 4, 6, 7, 9};
        checkSort(in1, ex1, Sorts.quickSort(in1.clone()));

        Integer[] in2 = new Integer[]{2, 2, 2, 2};
        Integer[] ex2 = new Integer[]{2, 2, 2, 2};
        checkSort(in2, ex2, Sorts.quickSort(in2.clone()));

        Integer[] in3 = new Integer[]{};
        Integer[] ex3 = new Integer[]{};
        checkSort(in3, ex3, Sorts.quickSort(in3.clone()));

        Integer[] in4 = new Integer[]{3, 1};
        Integer[] ex4 = new Integer[]{1, 3};
        checkSort(in4, ex4, Sorts.quickSort(in4.clone()));
    }

    /**
     * Tests heapSort on a variety of input sizes and orders.
     */
    @Test
    public void testHeapSort() {
        Integer[] in1 = new Integer[]{10, 3, 7, 1, 5};
        Integer[] ex1 = new Integer[]{1, 3, 5, 7, 10};
        checkSort(in1, ex1, Sorts.heapSort(in1.clone()));

        Integer[] in2 = new Integer[]{5, 5, 5, 5, 5};
        Integer[] ex2 = new Integer[]{5, 5, 5, 5, 5};
        checkSort(in2, ex2, Sorts.heapSort(in2.clone()));

        Integer[] in3 = new Integer[]{};
        Integer[] ex3 = new Integer[]{};
        checkSort(in3, ex3, Sorts.heapSort(in3.clone()));

        Integer[] in4 = new Integer[]{100, 50};
        Integer[] ex4 = new Integer[]{50, 100};
        checkSort(in4, ex4, Sorts.heapSort(in4.clone()));
    }
}
