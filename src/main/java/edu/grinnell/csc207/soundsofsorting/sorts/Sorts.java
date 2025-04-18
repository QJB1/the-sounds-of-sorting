package edu.grinnell.csc207.soundsofsorting.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.csc207.soundsofsorting.sortevents.CompareEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.CopyEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SwapEvent;

/**
 * A collection of sorting algorithms.
 */
public class Sorts {
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> bubbleSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        int n = arr.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                events.add(new CompareEvent<>(i - 1, i));
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    events.add(new SwapEvent<>(i - 1, i));
                    swap(arr, i - 1, i);
                    swapped = true;
                }
            }
            n--; 
        }
        return events;
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> selectionSort(
            T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                events.add(new CompareEvent<>(j, minIdx));
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                events.add(new SwapEvent<>(i, minIdx));
                swap(arr, i, minIdx);
            }
        }
        return events;
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ] 
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> insertionSort(
            T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                events.add(new CompareEvent<>(j, j + 1));
                if (arr[j].compareTo(key) > 0) {
                    events.add(new CopyEvent<>(j + 1, (Integer) arr[j]));
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            events.add(new CopyEvent<>(j + 1, (Integer) key));
            arr[j + 1] = key;
        }
        return events;
    }

    /**
     * Sorts the array according to the merge sort algorithm.
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> mergeSort(
            T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        T[] aux = arr.clone();
        mergeSortH(arr, aux, 0, arr.length - 1, events);
        return events;
    }

    private static <T extends Comparable<? super T>> void mergeSortH(T[] arr, T[] aux, int low, int high, List<SortEvent<Integer>> events) {
        if (low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortH(aux, arr, low, mid, events);
        mergeSortH(aux, arr, mid + 1, high, events);
        merge(arr, aux, low, mid, high, events);
    }

    private static <T extends Comparable<? super T>> void merge(T[] src, T[] dest, int low, int mid, int high, List<SortEvent<Integer>> events) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                dest[k] = src[j];
                events.add(new CopyEvent<>(k, (Integer) src[j]));
                j++;
            } else if (j > high) {
                dest[k] = src[i];
                events.add(new CopyEvent<>(k, (Integer) src[i])); // events.add(new CopyEvent<>(k, src[i]));
                i++;
            } else {
                events.add(new CompareEvent<>(i, j));
                if (src[i].compareTo(src[j]) <= 0) {
                    dest[k] = src[i];
                    events.add(new CopyEvent<>(k, (Integer) src[i]));
                    i++;
                } else {
                    dest[k] = src[j];
                    events.add(new CopyEvent<>(k, (Integer) src[j]));
                    j++;
                }
            }
        }
    }
    /**
     * Sorts the array according to the quick sort algorithm.
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> quickSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        quickSortH(arr, 0, arr.length - 1, events);
        return events;
    }

    private static <T extends Comparable<? super T>> void quickSortH(T[] arr, int low, int high, List<SortEvent<Integer>> events) {
        if (low < high) {
            int p = helper(arr, low, high, events);
            quickSortH(arr, low, p - 1, events);
            quickSortH(arr, p + 1, high, events);
        }
    }

    private static <T extends Comparable<? super T>> int helper(T[] arr, int low, int high, List<SortEvent<Integer>> events) {
        T pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            events.add(new CompareEvent<>(j, high));
            if (arr[j].compareTo(pivot) < 0) {
                events.add(new SwapEvent<>(i, j));
                swap(arr, i, j);
                i++;
            }
        }
        events.add(new SwapEvent<>(i, high));
        swap(arr, i, high);
        return i;
    }

    /**
     * Sorts the array according to the heap sort algorithm.
     * This is the sixth comparison-based sorting algorithm.
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> heapSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapSortH(arr, n, i, events);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            events.add(new SwapEvent<>(0, i));
            swap(arr, 0, i);
            heapSortH(arr, i, 0, events);
        }

        return events;
    }

    private static <T extends Comparable<? super T>> void heapSortH(T[] arr, int heapSize, 
        int root, List<SortEvent<Integer>> events) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < heapSize) {
            events.add(new CompareEvent<>(left, largest));
            if (arr[left].compareTo(arr[largest]) > 0) {
                largest = left;
            }
        }

        if (right < heapSize) {
            events.add(new CompareEvent<>(right, largest));
            if (arr[right].compareTo(arr[largest]) > 0) {
                largest = right;
            }
        }

        if (largest != root) {
            events.add(new SwapEvent<>(root, largest));
            swap(arr, root, largest);
            heapSortH(arr, heapSize, largest, events);
        }
    }

    /**
     * Applies a sequence of sort events to the given array.
     * @param <T> the carrier type of the array
     * @param arr the array to modify
     * @param events the list of events to apply
     */
    public static <T> void eventSort(T[] arr, List<SortEvent<T>> events) {
        for (SortEvent<T> event : events) {
            event.apply(arr);
        }
    }

}
