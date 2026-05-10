# ChatGPT (GPT-5.5)
 - "Can you explain to me how Gnome Sort works?"
    The AI explained the logic of the gnome sort algorithm and how it moves through the array and sorts through numbers. It also explained why it is called gnome sort.
 - "Can you explain to me how Cocktail Shaker sort works?"
    The AI explained the logic of the cocktail shaker sort algorithm and how it is a variation of bubble sort but working in both directions. (Like shaking a cocktail)
 - "Can you explain to me how Shell Sort works?
    The AI explained the logic of Shell sort and how it sorts elements that are far apart and gradually reduces the gap is it sorts in order to move the different elements to their final positions early.
 - "Can you help me review this pseudocode (shell sort) and explain what each of the variables do"
    This helped me understand and explain in the reflection log.
 - "Can you help me review this pseudocode (shell sort) and explain the loops used in the sorting algorithm?"

# Claude (Sonnet 4.6)
 - "Can you generate a sorting algorithm based on this psuedocode? It needs to match the variable names from the pseudocode specifications exactly. Ensure it has proper variable naming and code structure. It also needs to work with generic comparable objects. Can you also show implimentation for comparable objects? (A generic array) Provide clear comments explaining each step. Mention the available swap() method when applicable."
```
procedure gnomeSort(a[]):
    pos := 0
    while pos < length(a):
        if (pos == 0 or a[pos] >= a[pos-1]):
            pos := pos + 1
        else:
            swap a[pos] and a[pos-1]
            pos := pos - 1
```
##### Response:
```
import java.util.Arrays;

/**
 * GnomeSort - A generic implementation of the Gnome Sort algorithm.
 *
 * Gnome Sort works similarly to insertion sort, but instead of shifting
 * elements, it uses swaps. The algorithm moves a "gnome" (position pointer)
 * forward when elements are in order, and backward (swapping as it goes)
 * when they are out of order.
 *
 * Time Complexity:  O(n²) worst/average case, O(n) best case (already sorted)
 * Space Complexity: O(1) — sorts in place
 */
public class GnomeSort {

    /**
     * Sorts an array of any Comparable type in ascending order using Gnome Sort.
     *
     * Variable names match the pseudocode specification exactly:
     *   - a[]  : the input array
     *   - pos  : the current gnome position
     *
     * @param <T> A type that implements Comparable (e.g. Integer, String, Double)
     * @param a   The array to be sorted in place
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
                // Swap a[pos] and a[pos-1] using the swap() helper method below.
                // Then step the gnome backward to recheck the swapped element
                // against its new neighbor.
                swap(a, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }

    /**
     * Swaps two elements in an array at the given indices.
     *
     * This utility method is used by gnomeSort() whenever an out-of-order
     * pair is detected (i.e. a[pos] < a[pos-1]).
     *
     * @param <T> The element type of the array
     * @param a   The array containing the elements to swap
     * @param i   Index of the first element
     * @param j   Index of the second element
     */
    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i]   = a[j];
        a[j]   = temp;
    }


    // -----------------------------------------------------------------------
    // Demonstration — sorting several different Comparable types
    // -----------------------------------------------------------------------

    public static void main(String[] args) {

        // --- Integer array ---
        Integer[] intArray = {34, 2, 78, 1, 56, 23, 9, 45};
        System.out.println("=== Integer Array ===");
        System.out.println("Before: " + Arrays.toString(intArray));
        gnomeSort(intArray);
        System.out.println("After:  " + Arrays.toString(intArray));

        // --- Double array ---
        Double[] doubleArray = {3.14, 1.41, 2.71, 0.57, 1.73};
        System.out.println("\n=== Double Array ===");
        System.out.println("Before: " + Arrays.toString(doubleArray));
        gnomeSort(doubleArray);
        System.out.println("After:  " + Arrays.toString(doubleArray));

        // --- String array (lexicographic / alphabetical order) ---
        String[] stringArray = {"banana", "apple", "cherry", "date", "avocado"};
        System.out.println("\n=== String Array ===");
        System.out.println("Before: " + Arrays.toString(stringArray));
        gnomeSort(stringArray);
        System.out.println("After:  " + Arrays.toString(stringArray));

        // --- Character array ---
        Character[] charArray = {'z', 'a', 'm', 'b', 'q', 'c'};
        System.out.println("\n=== Character Array ===");
        System.out.println("Before: " + Arrays.toString(charArray));
        gnomeSort(charArray);
        System.out.println("After:  " + Arrays.toString(charArray));

        // --- Already-sorted edge case ---
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("\n=== Already-Sorted Array (best case O(n)) ===");
        System.out.println("Before: " + Arrays.toString(sortedArray));
        gnomeSort(sortedArray);
        System.out.println("After:  " + Arrays.toString(sortedArray));

        // --- Single-element edge case ---
        Integer[] singleElement = {42};
        System.out.println("\n=== Single-Element Array ===");
        System.out.println("Before: " + Arrays.toString(singleElement));
        gnomeSort(singleElement);
        System.out.println("After:  " + Arrays.toString(singleElement));
    }
}
```
 - "Can you generate a sorting algorithm method based on this psuedocode? It needs to match the variable names from the pseudocode specifications exactly. Ensure it has proper variable naming and code structure. It also needs to work with generic comparable objects. Can you also show implimentation for comparable objects? (A generic array) Provide clear comments explaining each step. Mention the available swap() method when applicable."
 ```
procedure cocktailShakerSort(a : list of sortable items) is
    do
        swapped := false
        for each i in 0 to length(a) − 1 do:
            if a[i] > a[i + 1] then
                swap(a[i], a[i + 1])
                swapped := true
            end if
        end for
        if not swapped then
            break do-while loop
        end if
        swapped := false
        for each i in length(a) − 1 to 0 do:
            if a[i] > a[i + 1] then
                swap(a[i], a[i + 1])
                swapped := true
            end if
        end for
    while swapped
end procedure
```
##### Response:
```
import java.util.Arrays;

/**
 * CocktailShakerSort — A generic implementation of the Cocktail Shaker Sort algorithm.
 *
 * Cocktail Shaker Sort is a bidirectional variation of Bubble Sort. Instead of
 * only making left-to-right passes, it alternates: one forward pass bubbles the
 * largest unsorted element to the right, then one backward pass bubbles the
 * smallest unsorted element to the left. This two-directional approach eliminates
 * "turtles" (small values near the end of the array) more efficiently than
 * standard Bubble Sort.
 *
 * Time Complexity:  O(n²) worst/average case, O(n) best case (already sorted)
 * Space Complexity: O(1) — sorts in place
 */
public class CocktailShakerSort {

    /**
     * Sorts an array of any Comparable type in ascending order using
     * Cocktail Shaker Sort.
     *
     * Variable names match the pseudocode specification exactly:
     *   - a        : the input array of sortable items
     *   - swapped  : flag tracking whether any swap occurred in a pass
     *   - i        : the loop index for both forward and backward passes
     *
     * @param <T> A type that implements Comparable (e.g. Integer, String, Double)
     * @param a   The array to be sorted in place
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
    }

    /**
     * Swaps two elements in an array at the given indices.
     *
     * This utility method is called by cocktailShakerSort() whenever an
     * out-of-order adjacent pair (a[i] > a[i+1]) is detected in either
     * the forward or backward pass.
     *
     * @param <T> The element type of the array
     * @param a   The array containing the elements to swap
     * @param i   Index of the first element
     * @param j   Index of the second element
     */
    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i]   = a[j];
        a[j]   = temp;
    }


    // -------------------------------------------------------------------------
    // Demonstration — sorting several different Comparable types
    // -------------------------------------------------------------------------

    public static void main(String[] args) {

        // --- Integer array ---
        Integer[] intArray = {5, 1, 4, 2, 8, 0, 2};
        System.out.println("=== Integer Array ===");
        System.out.println("Before: " + Arrays.toString(intArray));
        cocktailShakerSort(intArray);
        System.out.println("After:  " + Arrays.toString(intArray));

        // --- Double array ---
        Double[] doubleArray = {3.14, 1.41, 2.71, 0.57, 1.73};
        System.out.println("\n=== Double Array ===");
        System.out.println("Before: " + Arrays.toString(doubleArray));
        cocktailShakerSort(doubleArray);
        System.out.println("After:  " + Arrays.toString(doubleArray));

        // --- String array (lexicographic / alphabetical order) ---
        String[] stringArray = {"banana", "apple", "cherry", "date", "avocado"};
        System.out.println("\n=== String Array ===");
        System.out.println("Before: " + Arrays.toString(stringArray));
        cocktailShakerSort(stringArray);
        System.out.println("After:  " + Arrays.toString(stringArray));

        // --- Character array ---
        Character[] charArray = {'z', 'a', 'm', 'b', 'q', 'c'};
        System.out.println("\n=== Character Array ===");
        System.out.println("Before: " + Arrays.toString(charArray));
        cocktailShakerSort(charArray);
        System.out.println("After:  " + Arrays.toString(charArray));

        // --- Already-sorted edge case (best case O(n) — single cycle, no swaps) ---
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("\n=== Already-Sorted Array (best case O(n)) ===");
        System.out.println("Before: " + Arrays.toString(sortedArray));
        cocktailShakerSort(sortedArray);
        System.out.println("After:  " + Arrays.toString(sortedArray));

        // --- Reverse-sorted edge case (worst case — maximum swaps needed) ---
        Integer[] reverseArray = {9, 7, 5, 3, 1};
        System.out.println("\n=== Reverse-Sorted Array (worst case) ===");
        System.out.println("Before: " + Arrays.toString(reverseArray));
        cocktailShakerSort(reverseArray);
        System.out.println("After:  " + Arrays.toString(reverseArray));

        // --- Single-element edge case ---
        Integer[] singleElement = {42};
        System.out.println("\n=== Single-Element Array ===");
        System.out.println("Before: " + Arrays.toString(singleElement));
        cocktailShakerSort(singleElement);
        System.out.println("After:  " + Arrays.toString(singleElement));
    }
}
```
 - There was a difference with the pseudocode where it said "a.length - 2" on line 80 within the cocktail shaker method.
 - "Why did you change this line from the pseudocode (line 80 of SortingUtility) from a.length - 1 to a.length - 2?"
##### Response: 
```
a.length - 2 and length(a) - 1 are not the same value — they differ by 1. However, a.length - 2 is actually the correct bound to use, because the body compares a[i] with a[i+1], and going up to length - 1 would cause an ArrayIndexOutOfBoundsException. This is a bug in the original pseudocode that was silently corrected. It's worth adding a comment explicitly calling this out.
The backward loop has the same situation — length(a) − 1 to 0 in the pseudocode becomes a.length - 2 down to 0, again correctly adjusted.
```
 - "Can you generate a sorting algorithm method based on this psuedocode? It needs to match the variable names from the pseudocode specifications exactly. Ensure it has proper variable naming and code structure. It also needs to work with generic comparable objects. Can you also show implimentation for comparable objects? (A generic array) Provide clear comments explaining each step. Mention the available swap() method when applicable."
```
# Sort an array a[0...n-1].
gaps = [701, 301, 132, 57, 23, 10, 4, 1]  # Ciura gap sequence
n = a[] length

# Start with the largest gap and work down to a gap of 1
foreach (gap in gaps)
{
    # Do a gapped insertion sort for every elements in gaps
    for (i = gap; i < n; i += 1)
    {
        # save a[i] in temp and make a hole at position i
        temp = a[i]
        # shift earlier gap-sorted elements up until the correct location for a[i] is found
        for (j = i; (j >= gap) && (a[j - gap] > temp); j -= gap)
        {
            a[j] = a[j - gap]
        }
        # put temp (the original a[i]) in its correct location
        a[j] = temp
    }
}
```
##### Response:
```
import java.util.Arrays;

/**
 * ShellSort — A generic implementation of Shell Sort using the Ciura gap sequence.
 *
 * Shell Sort is a generalization of Insertion Sort that allows the exchange of
 * elements far apart. Rather than comparing only adjacent elements, it first
 * sorts elements that are a large "gap" apart, progressively reducing the gap
 * until it reaches 1 (a final ordinary insertion sort pass). By the time the
 * gap reaches 1, the array is nearly sorted, making the final pass very fast.
 *
 * The Ciura gap sequence {701, 301, 132, 57, 23, 10, 4, 1} is empirically
 * determined to minimize comparisons for average-case input.
 *
 * Time Complexity:  O(n log²n) average case with Ciura gaps
 * Space Complexity: O(1) — sorts in place
 *
 * NOTE: Shell Sort sorts by shifting elements into place rather than swapping.
 *       A swap() helper is therefore not used here — each inner loop iteration
 *       shifts one element one gap-position to the right, and the saved value
 *       (temp) is written once at the correct location. This is more efficient
 *       than repeated adjacent swaps.
 */
public class ShellSort {

    /**
     * Sorts an array of any Comparable type in ascending order using Shell Sort
     * with the Ciura gap sequence.
     *
     * Variable names match the pseudocode specification exactly:
     *   - gaps  : the Ciura gap sequence array
     *   - n     : length of the input array a
     *   - gap   : the current gap value from the gaps sequence
     *   - i     : outer insertion-sort loop index (current element being placed)
     *   - j     : inner shift loop index (scanning leftward by gap increments)
     *   - temp  : saved copy of a[i], the element being inserted
     *
     * @param <T> A type that implements Comparable (e.g. Integer, String, Double)
     * @param a   The array to be sorted in place
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
                //   - j < gap  : we've reached the left boundary of this sub-sequence, OR
                //   - a[j - gap] <= temp : the neighbor to the left is already ≤ temp,
                //                          so temp belongs at position j
                //
                // NOTE: Because elements are shifted in place (a[j] = a[j - gap]),
                //       a dedicated swap() call is not used here. Using swap() would
                //       require two writes per step instead of one, and would not
                //       correctly implement gapped insertion sort. temp is written
                //       exactly once, after the loop, at a[j].
                int j;
                for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j -= gap) {
                    // Shift the gap-neighbor one gap-position to the right,
                    // filling the hole and opening a new one at j - gap
                    a[j] = a[j - gap];
                }

                // Place temp (the original a[i]) into its correct sorted position.
                // The hole left by the shift loop is now at index j.
                a[j] = temp;
            }
        }
    }


    // -------------------------------------------------------------------------
    // Demonstration — sorting several different Comparable types
    // -------------------------------------------------------------------------

    public static void main(String[] args) {

        // --- Integer array ---
        Integer[] intArray = {64, 25, 12, 22, 11, 90, 3, 47};
        System.out.println("=== Integer Array ===");
        System.out.println("Before: " + Arrays.toString(intArray));
        shellSort(intArray);
        System.out.println("After:  " + Arrays.toString(intArray));

        // --- Double array ---
        Double[] doubleArray = {3.14, 1.41, 2.71, 0.57, 1.73, 9.81};
        System.out.println("\n=== Double Array ===");
        System.out.println("Before: " + Arrays.toString(doubleArray));
        shellSort(doubleArray);
        System.out.println("After:  " + Arrays.toString(doubleArray));

        // --- String array (lexicographic / alphabetical order) ---
        String[] stringArray = {"banana", "apple", "cherry", "date", "avocado", "fig"};
        System.out.println("\n=== String Array ===");
        System.out.println("Before: " + Arrays.toString(stringArray));
        shellSort(stringArray);
        System.out.println("After:  " + Arrays.toString(stringArray));

        // --- Character array ---
        Character[] charArray = {'z', 'a', 'm', 'b', 'q', 'c', 'x'};
        System.out.println("\n=== Character Array ===");
        System.out.println("Before: " + Arrays.toString(charArray));
        shellSort(charArray);
        System.out.println("After:  " + Arrays.toString(charArray));

        // --- Already-sorted edge case (all large gaps skip immediately) ---
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("\n=== Already-Sorted Array ===");
        System.out.println("Before: " + Arrays.toString(sortedArray));
        shellSort(sortedArray);
        System.out.println("After:  " + Arrays.toString(sortedArray));

        // --- Reverse-sorted edge case (worst case — maximum shifting required) ---
        Integer[] reverseArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("\n=== Reverse-Sorted Array (worst case) ===");
        System.out.println("Before: " + Arrays.toString(reverseArray));
        shellSort(reverseArray);
        System.out.println("After:  " + Arrays.toString(reverseArray));

        // --- Single-element edge case (all loops skip) ---
        Integer[] singleElement = {42};
        System.out.println("\n=== Single-Element Array ===");
        System.out.println("Before: " + Arrays.toString(singleElement));
        shellSort(singleElement);
        System.out.println("After:  " + Arrays.toString(singleElement));

        // --- Large array to demonstrate Ciura gap effectiveness ---
        Integer[] largeArray = new Integer[20];
        for (int k = 0; k < 20; k++) largeArray[k] = 20 - k; // {20,19,...,1}
        System.out.println("\n=== Large Reverse Array (n=20) ===");
        System.out.println("Before: " + Arrays.toString(largeArray));
        shellSort(largeArray);
        System.out.println("After:  " + Arrays.toString(largeArray));
    }
}
```
 - "Can you go through the code and compare if the generated methods match the pseudocode specifications"
##### Response:
```
Let me do a careful side-by-side review of each method against its pseudocode.Review the final SortingUtility.javaReview the final SortingUtility.javaYes and no — here's the precise verdict for each one:

✅ Gnome Sort — Exact match
Every detail lines up cleanly with the pseudocode:
PseudocodeJavapos := 0int pos = 0while pos < length(a)while (pos < a.length)pos == 0 or a[pos] >= a[pos-1]pos == 0 || a[pos].compareTo(a[pos-1]) >= 0pos := pos + 1pos = pos + 1swap a[pos] and a[pos-1]swap(a, pos, pos - 1)pos := pos - 1pos = pos - 1

⚠️ Cocktail Shaker Sort — One deviation
The forward loop bound is slightly off. The pseudocode says:
for each i in 0 to length(a) − 1
But the implementation uses:
javafor (int i = 0; i <= a.length - 2; i++)

✅ Shell Sort — Exact match
All six variables (gaps, n, gap, i, j, temp) and all loop structures match precisely:
PseudocodeJavagaps = [701, 301, 132, 57, 23, 10, 4, 1]int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}n = a[] lengthint n = a.lengthforeach (gap in gaps)for (int gap : gaps)for (i = gap; i < n; i += 1)for (int i = gap; i < n; i += 1)temp = a[i]T temp = a[i]for (j = i; j >= gap && a[j-gap] > temp; j -= gap)for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j -= gap)a[j] = a[j - gap]a[j] = a[j - gap]a[j] = tempa[j] = temp
```
 - "Can you write comprehensive unit tests for this class? Verify test coverage for edge cases and typical cases and ensure tests validate algorithm correctness with comparable objects. Generate initial test suite for generic comparable types. Handle both Integer and String test cases. Identify additional edge cases specific to these algorithms. Can you verify that these tests check proper sorting behavior?

Here are the test requirements:

Empty array: []
Single element: [5]
Already sorted: [1, 2, 3, 4, 5]
Reverse sorted: [5, 4, 3, 2, 1]
Duplicates: [3, 1, 4, 1, 5, 9, 2, 6, 5, 3]
All same elements: [5, 5, 5, 5, 5]
Two elements (swapped): [2, 1]
Two elements (sorted): [1, 2]
Random order: [64, 34, 25, 12, 22, 11, 90]
String arrays: Test with Comparable objects other than integers (e.g., ["zebra", "apple", "mango", "banana"])"
##### Response:
```
package com.example.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SortingUtilityTest — Comprehensive JUnit 5 test suite for SortingUtility.
 *
 * Coverage strategy:
 *   - Every algorithm (gnomeSort, cocktailShakerSort, shellSort) is tested
 *     independently under an identical set of cases so regressions in one
 *     method cannot be masked by another.
 *   - Each @Nested class groups all tests for one algorithm, making output
 *     easy to read and failures easy to localise.
 *   - Tests are written as black-box checks: given an input array, sort it,
 *     then assert the result equals the expected sorted array.
 *   - A canonical Java sort (Arrays.sort) is used to compute the expected
 *     result for random/duplicate cases, removing the risk of a hand-written
 *     expected array being wrong.
 *
 * Cases covered per algorithm:
 *   1.  Empty array
 *   2.  Single element
 *   3.  Two elements — already sorted
 *   4.  Two elements — reverse (requires one swap)
 *   5.  Already sorted (no work needed / early-exit paths)
 *   6.  Reverse sorted (worst case — maximum comparisons & swaps)
 *   7.  Random order (typical case)
 *   8.  Duplicates present
 *   9.  All elements identical
 *   10. Large array (stress / performance sanity check)
 *   11. String array — Comparable type other than Integer
 *   12. String array — already sorted
 *   13. String array — reverse sorted
 *   14. String array — duplicates
 *   15. Mixed-case String sensitivity (uppercase sorts before lowercase in Java)
 */
class SortingUtilityTest {

    // =========================================================================
    // Shared helper
    // =========================================================================

    /**
     * Returns a copy of the input array sorted by Java's built-in sort.
     * Used as the ground-truth expected value for cases where writing the
     * expected array by hand would be error-prone.
     */
    private static <T extends Comparable<T>> T[] javaSorted(T[] input) {
        T[] copy = Arrays.copyOf(input, input.length);
        Arrays.sort(copy);
        return copy;
    }


    // =========================================================================
    // GNOME SORT
    // =========================================================================

    @Nested
    @DisplayName("gnomeSort()")
    class GnomeSortTests {

        // --- Empty & trivial ---

        @Test
        @DisplayName("Empty array — no exception, array unchanged")
        void emptyArray() {
            Integer[] a = {};
            assertDoesNotThrow(() -> SortingUtility.gnomeSort(a));
            assertArrayEquals(new Integer[]{}, a);
        }

        @Test
        @DisplayName("Single element — no movement required")
        void singleElement() {
            Integer[] a = {5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{5}, a);
        }

        // --- Two-element cases ---

        @Test
        @DisplayName("Two elements — already sorted, no swap needed")
        void twoElementsSorted() {
            Integer[] a = {1, 2};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Two elements — reverse order, one swap required")
        void twoElementsReverse() {
            Integer[] a = {2, 1};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        // --- Typical integer cases ---

        @Test
        @DisplayName("Already sorted — forward walk only, no swaps")
        void alreadySorted() {
            Integer[] a = {1, 2, 3, 4, 5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Reverse sorted — maximum backward movement")
        void reverseSorted() {
            Integer[] a = {5, 4, 3, 2, 1};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Random order — typical unsorted input")
        void randomOrder() {
            Integer[] a        = {64, 34, 25, 12, 22, 11, 90};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("Duplicates — equal elements must remain in sorted order")
        void duplicates() {
            Integer[] a        = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("All same elements — no swaps, array unchanged")
        void allSameElements() {
            Integer[] a = {5, 5, 5, 5, 5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, a);
        }

        @Test
        @DisplayName("Large array (100 elements) — stress test")
        void largeArray() {
            Integer[] a = new Integer[100];
            for (int k = 0; k < 100; k++) a[k] = 100 - k; // {100, 99, …, 1}
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }

        // --- String (Comparable) cases ---

        @Test
        @DisplayName("String array — random order, lexicographic sort")
        void stringRandomOrder() {
            String[] a        = {"zebra", "apple", "mango", "banana"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — already sorted")
        void stringsAlreadySorted() {
            String[] a = {"apple", "banana", "mango", "zebra"};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("String array — reverse sorted")
        void stringsReverseSorted() {
            String[] a = {"zebra", "mango", "banana", "apple"};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("String array — duplicate strings")
        void stringDuplicates() {
            String[] a        = {"banana", "apple", "banana", "cherry", "apple"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — mixed case (uppercase sorts before lowercase in Java)")
        void stringMixedCase() {
            // In Java's natural String ordering, 'A' (65) < 'a' (97),
            // so "Zebra" sorts before "apple".
            String[] a        = {"zebra", "Apple", "mango", "Banana"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }
    }


    // =========================================================================
    // COCKTAIL SHAKER SORT
    // =========================================================================

    @Nested
    @DisplayName("cocktailShakerSort()")
    class CocktailShakerSortTests {

        // --- Empty & trivial ---

        @Test
        @DisplayName("Empty array — no exception, array unchanged")
        void emptyArray() {
            Integer[] a = {};
            assertDoesNotThrow(() -> SortingUtility.cocktailShakerSort(a));
            assertArrayEquals(new Integer[]{}, a);
        }

        @Test
        @DisplayName("Single element — no movement required")
        void singleElement() {
            Integer[] a = {5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{5}, a);
        }

        // --- Two-element cases ---

        @Test
        @DisplayName("Two elements — already sorted, no swap needed")
        void twoElementsSorted() {
            Integer[] a = {1, 2};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Two elements — reverse order, one swap required")
        void twoElementsReverse() {
            Integer[] a = {2, 1};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        // --- Typical integer cases ---

        @Test
        @DisplayName("Already sorted — early exit after first forward pass")
        void alreadySorted() {
            Integer[] a = {1, 2, 3, 4, 5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Reverse sorted — maximum passes in both directions")
        void reverseSorted() {
            Integer[] a = {5, 4, 3, 2, 1};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Random order — typical unsorted input")
        void randomOrder() {
            Integer[] a        = {64, 34, 25, 12, 22, 11, 90};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("Duplicates — equal elements handled correctly")
        void duplicates() {
            Integer[] a        = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("All same elements — no swaps, array unchanged")
        void allSameElements() {
            Integer[] a = {5, 5, 5, 5, 5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, a);
        }

        @Test
        @DisplayName("Large array (100 elements) — stress test")
        void largeArray() {
            Integer[] a = new Integer[100];
            for (int k = 0; k < 100; k++) a[k] = 100 - k;
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        // --- Algorithm-specific edge case ---

        @Test
        @DisplayName("Turtle value at end — small element at far right bubbles left efficiently")
        void turtleAtEnd() {
            // Cocktail Shaker Sort's key advantage: backward passes quickly
            // pull small "turtle" values from the end toward the front.
            // Standard Bubble Sort would need O(n) passes for this case.
            Integer[] a        = {2, 3, 4, 5, 6, 7, 8, 1};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        // --- String (Comparable) cases ---

        @Test
        @DisplayName("String array — random order, lexicographic sort")
        void stringRandomOrder() {
            String[] a        = {"zebra", "apple", "mango", "banana"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — already sorted")
        void stringsAlreadySorted() {
            String[] a = {"apple", "banana", "mango", "zebra"};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("String array — reverse sorted")
        void stringsReverseSorted() {
            String[] a = {"zebra", "mango", "banana", "apple"};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("String array — duplicate strings")
        void stringDuplicates() {
            String[] a        = {"banana", "apple", "banana", "cherry", "apple"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — mixed case (uppercase sorts before lowercase in Java)")
        void stringMixedCase() {
            String[] a        = {"zebra", "Apple", "mango", "Banana"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }
    }


    // =========================================================================
    // SHELL SORT
    // =========================================================================

    @Nested
    @DisplayName("shellSort()")
    class ShellSortTests {

        // --- Empty & trivial ---

        @Test
        @DisplayName("Empty array — no exception, array unchanged")
        void emptyArray() {
            Integer[] a = {};
            assertDoesNotThrow(() -> SortingUtility.shellSort(a));
            assertArrayEquals(new Integer[]{}, a);
        }

        @Test
        @DisplayName("Single element — no movement required")
        void singleElement() {
            Integer[] a = {5};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{5}, a);
        }

        // --- Two-element cases ---

        @Test
        @DisplayName("Two elements — already sorted")
        void twoElementsSorted() {
            Integer[] a = {1, 2};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Two elements — reverse order")
        void twoElementsReverse() {
            Integer[] a = {2, 1};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        // --- Typical integer cases ---

        @Test
        @DisplayName("Already sorted — all gap passes produce no shifts")
        void alreadySorted() {
            Integer[] a = {1, 2, 3, 4, 5};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Reverse sorted — maximum shifting across all gap passes")
        void reverseSorted() {
            Integer[] a = {5, 4, 3, 2, 1};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Random order — typical unsorted input")
        void randomOrder() {
            Integer[] a        = {64, 34, 25, 12, 22, 11, 90};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("Duplicates — equal elements handled correctly by shift logic")
        void duplicates() {
            Integer[] a        = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("All same elements — no shifts, array unchanged")
        void allSameElements() {
            Integer[] a = {5, 5, 5, 5, 5};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, a);
        }

        @Test
        @DisplayName("Large array (1000 elements) — exercises Ciura gap sequence fully")
        void largeArray() {
            // 1000 elements is large enough to activate gaps 701, 301, 132, 57, …
            Integer[] a = new Integer[1000];
            for (int k = 0; k < 1000; k++) a[k] = 1000 - k; // {1000, 999, …, 1}
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        // --- Algorithm-specific edge cases ---

        @Test
        @DisplayName("Array smaller than all gaps — only gap=1 pass executes")
        void arraySmallerThanAllGaps() {
            // All Ciura gaps > 1 will have their inner loop skipped (i=gap >= n=3).
            // Only the gap=1 pass (plain insertion sort) runs.
            Integer[] a        = {3, 1, 2};
            Integer[] expected = {1, 2, 3};
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("Array of exactly 701 elements — largest Ciura gap fires once")
        void arrayExactly701Elements() {
            Integer[] a = new Integer[701];
            for (int k = 0; k < 701; k++) a[k] = 701 - k;
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        // --- String (Comparable) cases ---

        @Test
        @DisplayName("String array — random order, lexicographic sort")
        void stringRandomOrder() {
            String[] a        = {"zebra", "apple", "mango", "banana"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — already sorted")
        void stringsAlreadySorted() {
            String[] a = {"apple", "banana", "mango", "zebra"};
            SortingUtility.shellSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("String array — reverse sorted")
        void stringsReverseSorted() {
            String[] a = {"zebra", "mango", "banana", "apple"};
            SortingUtility.shellSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("String array — duplicate strings")
        void stringDuplicates() {
            String[] a        = {"banana", "apple", "banana", "cherry", "apple"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — mixed case (uppercase sorts before lowercase in Java)")
        void stringMixedCase() {
            String[] a        = {"zebra", "Apple", "mango", "Banana"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }
    }
}
```
 - How can I change the array in this driver class `SortingDriver` so that the numbers are already sorted?

Response:
```
Integer[] arr = IntStream.range(0, 10000)
        .boxed()
        .toArray(Integer[]::new);
"Gnome Sort and Cocktail Shaker should both complete near-instantly — Gnome walks forward without a single backtrack, Cocktail exits after one forward pass with no swaps. You should see times close to 0 ms for both."
```
 - How can I change the array in this driver class `SortingDriver` so that the numbers are in reverse order and need to be sorted?

Response:
```
Integer[] arr = IntStream.range(0, 10000)
        .map(i -> 9999 - i)
        .boxed()
        .toArray(Integer[]::new);
"This is the worst case for all three. Gnome Sort has to drag every element all the way back to position 0. Cocktail Shaker must do full passes in both directions every cycle. Compare these times directly against Pattern 1 to see the worst-case penalty."
```
 - How can I change the array in this driver class `SortingDriver` so that the numbers are mostly sorted?

Response:
```
Integer[] arr = IntStream.range(0, 10000)
        .boxed()
        .toArray(Integer[]::new);

// Introduce ~100 random adjacent swaps (√n ≈ 100 for n=10000)
for (int i = 0; i < 100; i++) {
    int idx = (int) (Math.random() * 9999);
    Integer tmp = arr[idx];
    arr[idx]     = arr[idx + 1];
    arr[idx + 1] = tmp;
}
"This tests Cocktail Shaker's early-exit break. With only ~100 elements out of place, both algorithms should exit far earlier than on random input, but Cocktail Shaker's backward pass resolves displaced elements faster than Gnome's backtracking."
```