package com.example.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class SortingUtilityTest {
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
            Integer[] a = {64, 34, 25, 12, 22, 11, 90};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("Duplicates — equal elements must remain in sorted order")
        void duplicates() {
            Integer[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
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
            String[] a = {"zebra", "apple", "mango", "banana"};
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
            String[] a = {"banana", "apple", "banana", "cherry", "apple"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.gnomeSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — mixed case (uppercase sorts before lowercase in Java)")
        void stringMixedCase() {
            // In Java's natural String ordering, 'A' (65) < 'a' (97),
            // so "Zebra" sorts before "apple".
            String[] a = {"zebra", "Apple", "mango", "Banana"};
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
            Integer[] a = {64, 34, 25, 12, 22, 11, 90};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("Duplicates — equal elements handled correctly")
        void duplicates() {
            Integer[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
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
            Integer[] a = {2, 3, 4, 5, 6, 7, 8, 1};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        // --- String (Comparable) cases ---

        @Test
        @DisplayName("String array — random order, lexicographic sort")
        void stringRandomOrder() {
            String[] a = {"zebra", "apple", "mango", "banana"};
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
            String[] a = {"banana", "apple", "banana", "cherry", "apple"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — mixed case (uppercase sorts before lowercase in Java)")
        void stringMixedCase() {
            String[] a = {"zebra", "Apple", "mango", "Banana"};
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
            Integer[] a = {64, 34, 25, 12, 22, 11, 90};
            Integer[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("Duplicates — equal elements handled correctly by shift logic")
        void duplicates() {
            Integer[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
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
            Integer[] a = {3, 1, 2};
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
            String[] a = {"zebra", "apple", "mango", "banana"};
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
            String[] a = {"banana", "apple", "banana", "cherry", "apple"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

        @Test
        @DisplayName("String array — mixed case (uppercase sorts before lowercase in Java)")
        void stringMixedCase() {
            String[] a = {"zebra", "Apple", "mango", "Banana"};
            String[] expected = javaSorted(a.clone());
            SortingUtility.shellSort(a);
            assertArrayEquals(expected, a);
        }

    }
}