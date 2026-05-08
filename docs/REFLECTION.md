# Part A: Gnome Sort
##### Pseudocode Review:
 - The key variables here are "a[]" and "pos" which represent the array which goes in the brackets and pos which is the used to track position in the array while sorting
 - The pseudocode uses a while loop, and it keeps going until it goes through the array, and it is sorted (until pos reaches the end)
 - This sorting algorithm starts at the beginning of the array and compares two values that are next to each other. If they are in a correct order it moves the position forward and compares the higher number from the last comparison to the next number. If they are not in order then it swaps position and checks the two numbers again so it can move forward.

##### AI Sorting Method Implementation:
 - After asking the AI to generate the sorting algorithm implementation for Gnome Sort the code compiled fine
```
   First 10 of Array...
1: 6
2: 15
3: 20
4: 21
5: 23
6: 26
7: 29
8: 31
9: 32
10: 38
Time elapsed: 247.0761 ms
   ```

# Part B: Cocktail Shaker Sort
Pseudocode Review:
 - The key variables here are "a[]" "swapped" and "i" where "a[]" represents the array in brackets, swapped tracks whether something was swapped or not, and i is used to compare variables that are next to each other
 - The pseudocode uses a do-while loop so it's going to do the sorting algorithm "while swapped" which means it's going to stop when there are no more swaps.
 - This sorting algorithm works by pushing larger values to the right and smaller values toward the beginning.

##### AI Sorting Method Implementation:
 - There was a difference in the AI implementation logged in AI Interaction Log line 15.
 - I tried compiling with the original value from the pseudocode but there was an error "Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException"
 - I compiled with the code provided by the AI with the fix for the issue and the code compiled properly. "Time elapsed: 373.9091 ms"

# Part C: Shell Sort
Pseudocode Review:
- The key variables here are "a[]" the array being sorted, "gaps" which is a sequence of gaps sizes (Ciura Gap sequence in this case), "n" the number of elements in "a[]," "gap" which is the space between compared elements, "i" which is the position being processed, "temp" which (temporarily) stores the current element, and "j" which is used to move backwards through the "gap-sorted subsection"
- The pseudocode uses a gap loop as the main controlling loop to determine how far apart elements should be compared, an outer traversal loop controls which element is being inserted into the inner shifting loop. The inner shifting loop shifts elements forward in order to make space for the temp variable.
- This sorting algorithm works by choosing a gap, performing an insertion sort using the gap spacing, and reducing the gap until there isn't a large gap anymore.

##### AI Sorting Method Implementation:
 - After testing the code, the sorting algorithm implementation for Shell Sort compiled "Time elapsed: 6.177 ms"

# Test Class
 - I had initially copied and pasted just the tests into SortingUtilityTest and there were compile errors, this was fixed by adding the following
```
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
 
import java.util.Arrays;
 
import static org.junit.jupiter.api.Assertions.*;
```
 - After adding imports, SortingUtilityTest compiled and passed 48 tests.