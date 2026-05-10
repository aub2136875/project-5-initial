 - # Performance Analysis
 - When testing by changing `.limit(10000)` values from smaller to larger it went from faster to slower.
 - Test 1 Original (Fastest-Slowest): Shell, gnome, cocktail
 - Test 2 Limit 100 (Fastest-Slowest): Shell, cocktail,gnome
 - Test 3 Limit 10 (Fastest-Slowest): Shell, cocktail, gnome
 - Test 4 Limit 100000 (Fastest-Slowest): Shell, gnome, cocktail
 - Test 5 Limit 1000000 (Fastest-Slowest): Took too long


 - Test 6 Sorted (Fastest-Slowest): Cocktail, gnome, shell
 - Test 7 Reverse Sorted (Fastest-Slowest): Shell, gnome, cocktail
 - Test 8 Mostly Sorted (Fastest-Slowest): Cocktail, gnome, shell

 ##### Performance:
 - The shell method took the least amount of time for all tests with randomized numbers which makes sense since gnome and cocktail method are only comparing adjacent values in the array
 - When it was sorted and mostly sorted shell took the longest because it had to go through each of the gaps (Ciura gap) and cocktail was faster than gnome because gnome has to check each element starting by the beginning
 - Cocktail shaker is faster than bubble sort because bubble sort can only move things forward while cocktail shaker can go back and forth so bubble sort brings the largest value to the end and then goes through again to find the next largest while cocktail shaker goes back and forth switching values
 - Gnome sort seems to show consistent O(n²) behavior for the higher numbers.

# Tests:
 - First test `.limit(10000)`

Result:
```
First 10 of Array...
1: 16595
2: 7269
3: 4420
4: 13712
5: 6526
6: 10452
7: 46800
8: 37018
9: 46219
10: 3041

Gnome Sort...

First 10 of Array...
1: 1
2: 1
3: 2
4: 5
5: 8
6: 13
7: 24
8: 39
9: 40
10: 46
Time elapsed: 191.4145 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 1
2: 1
3: 2
4: 5
5: 8
6: 13
7: 24
8: 39
9: 40
10: 46
Time elapsed: 370.2077 ms

Shell Sort...

First 10 of Array...
1: 1
2: 1
3: 2
4: 5
5: 8
6: 13
7: 24
8: 39
9: 40
10: 46
Time elapsed: 4.8444 ms

StopWatch '': 0.5664666 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.1914145     34%     Gnome Sort
0.3702077     65%     Cocktail Shaker Sort
0.0048444     01%     Shell Sort
```
 - Second Test `.limit(10)`

Result:
```
First 10 of Array...
1: 41153
2: 27182
3: 49107
4: 3786
5: 12853
6: 36337
7: 1774
8: 45160
9: 13813
10: 41602

Gnome Sort...

First 10 of Array...
1: 1774
2: 3786
3: 12853
4: 13813
5: 27182
6: 36337
7: 41153
8: 41602
9: 45160
10: 49107
Time elapsed: 0.6641 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 1774
2: 3786
3: 12853
4: 13813
5: 27182
6: 36337
7: 41153
8: 41602
9: 45160
10: 49107
Time elapsed: 0.0159 ms

Shell Sort...

First 10 of Array...
1: 1774
2: 3786
3: 12853
4: 13813
5: 27182
6: 36337
7: 41153
8: 41602
9: 45160
10: 49107
Time elapsed: 0.0111 ms

StopWatch '': 0.0006911 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.0006641     96%     Gnome Sort
0.0000159     02%     Cocktail Shaker Sort
0.0000111     02%     Shell Sort
```
- Third test `.limit(100)`

Result:
```
First 10 of Array...
1: 7789
2: 26186
3: 37504
4: 23129
5: 28754
6: 11161
7: 1234
8: 44161
9: 5761
10: 4129

Gnome Sort...

First 10 of Array...
1: 185
2: 773
3: 1234
4: 1538
5: 1647
6: 2119
7: 2278
8: 2304
9: 2840
10: 2977
Time elapsed: 1.1876 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 185
2: 773
3: 1234
4: 1538
5: 1647
6: 2119
7: 2278
8: 2304
9: 2840
10: 2977
Time elapsed: 0.3223 ms

Shell Sort...

First 10 of Array...
1: 185
2: 773
3: 1234
4: 1538
5: 1647
6: 2119
7: 2278
8: 2304
9: 2840
10: 2977
Time elapsed: 0.0478 ms

StopWatch '': 0.0015577 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.0011876     76%     Gnome Sort
0.0003223     21%     Cocktail Shaker Sort
0.0000478     03%     Shell Sort
```
 - Test 4: `.limit(100000)`

Result:
```
First 10 of Array...
1: 45347
2: 19171
3: 41399
4: 49279
5: 6746
6: 25736
7: 20937
8: 19716
9: 26692
10: 14580

Gnome Sort...

First 10 of Array...
1: 0
2: 0
3: 1
4: 1
5: 1
6: 1
7: 3
8: 4
9: 4
10: 4
Time elapsed: 16853.1059 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 0
2: 0
3: 1
4: 1
5: 1
6: 1
7: 3
8: 4
9: 4
10: 4
Time elapsed: 35261.6176 ms

Shell Sort...

First 10 of Array...
1: 0
2: 0
3: 1
4: 1
5: 1
6: 1
7: 3
8: 4
9: 4
10: 4
Time elapsed: 62.2765 ms

StopWatch '': 52.177 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
16.8531059    32%     Gnome Sort
35.2616176    68%     Cocktail Shaker Sort
00.0622765    00%     Shell Sort
```
 - Test 5: `.limit(1000000)`
```
I stopped running the test because it was going to take too long with a limit that large.
```
 - Test 6: Replace line 13-16 with `Integer[] arr = IntStream.range(0, 10000)
        .boxed()
        .toArray(Integer[]::new);`
(Sorted)

Results:
```
First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9

Gnome Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 1.6413 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 0.9899 ms

Shell Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 5.0643 ms

StopWatch '': 0.0076955 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.0016413     21%     Gnome Sort
0.0009899     13%     Cocktail Shaker Sort
0.0050643     66%     Shell Sort
```

 - Test 7: Replace line 13-16 with 
```
IInteger[] arr = IntStream.range(0, 10000)
        .map(i -> 9999 - i)
        .boxed()
        .toArray(Integer[]::new);
```
(Reverse sorted)

Results:
```
First 10 of Array...
1: 9999
2: 9998
3: 9997
4: 9996
5: 9995
6: 9994
7: 9993
8: 9992
9: 9991
10: 9990

Gnome Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 388.857 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 501.7314 ms

Shell Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 3.6506 ms

StopWatch '': 0.894239 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.388857      43%     Gnome Sort
0.5017314     56%     Cocktail Shaker Sort
0.0036506     00%     Shell Sort
```
 - Test 8: Replace line 13-16 with 
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
```
(Mostly sorted)

Result:
```
First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9

Gnome Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 1.5807 ms

Cocktail Shaker Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 0.902 ms

Shell Sort...

First 10 of Array...
1: 0
2: 1
3: 2
4: 3
5: 4
6: 5
7: 6
8: 7
9: 8
10: 9
Time elapsed: 4.2697 ms

StopWatch '': 0.0067524 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.0015807     23%     Gnome Sort
0.000902      13%     Cocktail Shaker Sort
0.0042697     63%     Shell Sort
```