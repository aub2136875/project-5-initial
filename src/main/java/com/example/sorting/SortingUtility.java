package com.example.sorting;

public class SortingUtility {


    // =========================================================================
    // GNOME SORT
    // =========================================================================

    /**
     * Sorts an array of any Comparable type using Gnome Sort.
     *
     * The "gnome" walks forward when elements are in order, and walks backward
     * (swapping as it goes) when they are out of order.
     *
     * Variable names match the pseudocode specification exactly:
     *   - a   : the input array
     *   - pos : the current gnome position
     */
    public static <T extends Comparable<T>> void gnomeSort(T[] a) {

        // pos tracks the gnome's current position in the array
        int pos = 0;

        // Continue until the gnome has walked past the end of the array
        while (pos < a.length) {

            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                // Current element is in the correct relative position:
                //   - pos == 0: gnome is at the start, nothing to compare behind it
                //   - a[pos] >= a[pos-1]: current element is >= the one before it
                // Move the gnome one step forward
                pos = pos + 1;

            } else {
                // Current element is out of order (less than its predecessor).
                // Call swap() to exchange a[pos] and a[pos-1], then step the
                // gnome backward to recheck the swapped element against its
                // new neighbor.
                swap(a, pos, pos - 1);
                pos = pos - 1;
            }
        }
    } // end gnomeSort


    // =========================================================================
    // COCKTAIL SHAKER SORT
    // =========================================================================

    /**
     * Sorts an array of any Comparable type using Cocktail Shaker Sort.
     *
     * A bidirectional variant of Bubble Sort: a forward pass bubbles the
     * largest unsorted element right; a backward pass bubbles the smallest
     * unsorted element left. Exits early if a full cycle produces no swaps.
     *
     * Variable names match the pseudocode specification exactly:
     *   - a       : the input array
     *   - swapped : flag tracking whether any swap occurred in a pass
     *   - i       : loop index for both forward and backward passes
     */
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {

        // swapped tracks whether at least one swap was made during a full
        // forward + backward cycle. If no swaps occur, the array is sorted
        // and the loop exits early.
        boolean swapped;

        do {
            // ----------------------------------------------------------------
            // FORWARD PASS (left → right)
            // Bubbles the largest unsorted element toward the end of the array.
            // ----------------------------------------------------------------
            swapped = false;

            // Traverse from the first element up to the second-to-last.
            // We compare a[i] with a[i+1], so i must stop at length - 2
            // to avoid an out-of-bounds access on a[i+1].
            for (int i = 0; i <= a.length - 2; i++) {

                if (a[i].compareTo(a[i + 1]) > 0) {
                    // a[i] > a[i+1]: the pair is out of order.
                    // Call swap() to exchange the two adjacent elements,
                    // then flag that a swap occurred.
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // ----------------------------------------------------------------
            // EARLY EXIT CHECK
            // If the entire forward pass produced no swaps, the array is fully
            // sorted — no need to run the backward pass.
            // ----------------------------------------------------------------
            if (!swapped) {
                break;
            }

            // ----------------------------------------------------------------
            // BACKWARD PASS (right → left)
            // Bubbles the smallest unsorted element toward the front of the array.
            // Reset swapped before this pass so it only reflects backward activity.
            // ----------------------------------------------------------------
            swapped = false;

            // Traverse from the second-to-last element down to the first.
            // Again, we compare a[i] with a[i+1], so i must stop at 0
            // (comparing index 0 with index 1).
            for (int i = a.length - 2; i >= 0; i--) {

                if (a[i].compareTo(a[i + 1]) > 0) {
                    // a[i] > a[i+1]: still out of order going right-to-left.
                    // Call swap() to exchange the two adjacent elements,
                    // then flag that a swap occurred.
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // Repeat the full cycle only if the backward pass found something to swap.
            // If swapped is still false here, the array is sorted and the loop ends.
        } while (swapped);

    } // end cocktailShakerSort


    // =========================================================================
    // SHELL SORT
    // =========================================================================

    /**
     * Sorts an array of any Comparable type using Shell Sort with the Ciura
     * gap sequence.
     *
     * Shell Sort is a gapped insertion sort: elements far apart are sorted
     * first (large gaps), progressively reducing the gap until a final
     * ordinary insertion sort pass (gap = 1) finishes the job efficiently.
     *
     * Variable names match the pseudocode specification exactly:
     *   - gaps : the Ciura gap sequence array
     *   - n    : length of the input array a
     *   - gap  : the current gap value being processed
     *   - i    : outer loop index (current element being placed)
     *   - j    : inner shift loop index (scanning leftward by gap steps)
     *   - temp : saved copy of a[i], the element being inserted
     *
     * NOTE: swap() is NOT used here. Shell Sort shifts elements one gap-position
     *       at a time (a[j] = a[j - gap]) rather than swapping pairs, then
     *       writes temp once at the correct location. Using swap() would require
     *       two writes per step and would not correctly implement the algorithm.
     */
    public static <T extends Comparable<T>> void shellSort(T[] a) {

        // The Ciura gap sequence — empirically optimal gap values.
        // We start with the largest gap (701) and work down to 1.
        // Gaps larger than n are skipped automatically by the inner loops.
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        // n holds the total number of elements in the array
        int n = a.length;

        // Iterate over each gap value from largest to smallest.
        // Large gaps sort elements that are far apart early on,
        // reducing the work needed for smaller gaps later.
        for (int gap : gaps) {

            // Gapped insertion sort for this gap size.
            // Start at index `gap` and process every subsequent element.
            // Each element at index i is inserted into its correct position
            // among the gap-separated sub-sequence to its left.
            for (int i = gap; i < n; i += 1) {

                // Save a[i] into temp and conceptually "open a hole" at
                // position i. temp will be placed at its correct location
                // once the inner shift loop finishes.
                T temp = a[i];

                // Shift earlier gap-sorted elements to the right (up) by one
                // gap position until the correct insertion point for temp is
                // found. The loop moves left in steps of `gap`, stopping when:
                //   - j < gap          : reached the left boundary of this sub-sequence, OR
                //   - a[j-gap] <= temp : the left neighbor is already in order
                int j;
                for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j -= gap) {
                    // Shift the gap-neighbor one gap-position to the right,
                    // filling the current hole and opening a new one at j - gap
                    a[j] = a[j - gap];
                }

                // Place temp (the original a[i]) into its correct sorted position.
                // The hole left by the shift loop is now at index j.
                a[j] = temp;
            }

        } // end for gap

    } // end shellSort

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





