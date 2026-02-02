<!-- TOC -->
* [Arrays & Strings](#arrays--strings-)
  * [1. Sliding Window](#1-sliding-window)
    * [When to Use](#when-to-use)
    * [Key Idea](#key-idea)
    * [Example Problems](#example-problems)
  * [2. Two Pointers](#2-two-pointers)
    * [When to Use](#when-to-use-1)
    * [Key Idea](#key-idea-1)
    * [Example Problems](#example-problems-1)
  * [3. Prefix Sum](#3-prefix-sum)
    * [When to Use](#when-to-use-2)
    * [Key Idea](#key-idea-2)
    * [Example Problems](#example-problems-2)
  * [4. Hash Map Based Counting](#4-hash-map-based-counting)
    * [When to Use](#when-to-use-3)
    * [Key Idea](#key-idea-3)
    * [Example Problems](#example-problems-3)
  * [5. Binary Search (on Arrays)](#5-binary-search-on-arrays)
    * [When to Use](#when-to-use-4)
    * [Key Idea](#key-idea-4)
    * [Example Problems](#example-problems-4)
  * [6. In-Place Array Manipulation](#6-in-place-array-manipulation)
    * [When to Use](#when-to-use-5)
    * [Key Ideas](#key-ideas)
    * [Example Problems](#example-problems-5)
  * [7. String Manipulation Patterns](#7-string-manipulation-patterns)
    * [When to Use](#when-to-use-6)
    * [Key Ideas](#key-ideas-1)
    * [Example Problems](#example-problems-6)
  * [8. Kadane’s Algorithm (Max Subarray Sum)](#8-kadanes-algorithm-max-subarray-sum)
    * [When to Use](#when-to-use-7)
    * [Key Idea](#key-idea-5)
    * [Example Problems](#example-problems-7)
  * [9. Monotonic Stack (Advanced but part of arrays)](#9-monotonic-stack-advanced-but-part-of-arrays)
    * [When to Use](#when-to-use-8)
    * [Key Idea](#key-idea-6)
    * [Example Problems](#example-problems-8)
  * [10. Matrix Traversal Patterns](#10-matrix-traversal-patterns)
    * [When to Use](#when-to-use-9)
    * [Key Idea](#key-idea-7)
    * [Example Problems](#example-problems-9)
<!-- TOC -->

# Arrays & Strings 

## 1. Sliding Window
### When to Use
- You need info about contiguous subarrays/substrings
- Problem asks for maximum/minimum, sum, count, or average over a window

### Key Idea

Two pointers (left, right) expand/contract a window while maintaining a running state (sum, count, freq map).

### Example Problems

1. **Maximum Sum Subarray of Size K**  
Given an integer array `nums` and an integer `k`, find the maximum sum of any contiguous subarray of length `k`.

2. **Maximum Average Subarray I**  
Given an integer array `nums` and an integer `k`, return the maximum average of any contiguous subarray of size `k`.

3. **Longest Substring Without Repeating Characters**  
Given a string `s`, return the length of the longest substring that contains no repeating characters.

4. **Longest Substring With At Most K Distinct Characters**  
Given a string `s` and an integer `k`, return the length of the longest substring containing at most `k` distinct characters.

5. **Minimum Size Subarray Sum**  
Given an integer array `nums` and a target `t`, return the minimal length of a contiguous subarray whose sum is greater than or equal to `t`.


## 2. Two Pointers
### When to Use
- Array/string is sorted or can be reasoned about with ordering
- You need to find pairs, triplets, partitions, or boundaries
### Key Idea
Move two pointers (left, right) inward/outward based on comparison logic.
### Example Problems
1. **Two Sum II (Sorted)**  
You are given a sorted array of integers. Find the indices of two numbers that sum up to a given target.

2. **3Sum**  
Given an integer array, find all unique triplets `[nums[i], nums[j], nums[k]]` such that they sum to zero.

3. **Remove Duplicates from Sorted Array**  
Given a sorted array, modify it in-place to remove duplicates and return the new length.

4. **Move Zeroes**  
Given an integer array, move all zeroes to the end while maintaining the relative order of non-zero elements.

5. **Reverse String / Reverse Array**  
Given a character array, reverse the array in-place using two pointers.


## 3. Prefix Sum
### When to Use
- You need range sums quickly (sum(i..j))
- Many queries for subarray sums
- Problems involving deltas, cumulative counts
### Key Idea
``` java
// Calculated array of n+1 size
prefix[i] = sum(nums[0..i-1])

sum(l, r) = prefix[r+1] - prefix[l]
```

### Example Problems

1. **Range Sum Query**  
Given an integer array and multiple queries of the form `(l, r)`, return the sum of elements in the subarray from index `l` to `r` for each query.

2. **Subarray Sum Equals K**  
Given an integer array and an integer `k`, count the total number of contiguous subarrays whose elements sum exactly to `k`.

3. **Find Pivot Index**  
Given an integer array, find the index where the sum of elements to the left equals the sum of elements to the right. Return the leftmost such index, or -1 if none exists.

4. **Continuous Subarray Sum (Divisible by k)**  
Given an integer array and an integer `k`, determine whether there exists a contiguous subarray of at least size 2 whose sum is a multiple of `k`.

5. **Minimum Value to Get Positive Step-by-Step Sum**  
Given an integer array, find the minimum positive integer `startValue` such that when added sequentially to the array’s elements, the running sum never drops below 1.


## 4. Hash Map Based Counting

### When to Use
- Need frequencies of elements or chars
- Need to track windows with constraints
- Need to detect duplicates or patterns quickly

### Key Idea
Maintain counts in a hash map or fixed-size array (if character set small).

### Example Problems
1. **Longest Substring Without Repeating Characters**  
Find the length of the longest substring within a given string $s$ that does not contain any repeating characters.  
Hint: Track seen characters via map/set.

2. **Valid Anagram**  
Check if two strings have same character counts.

3. **Group Anagrams**  
Group words with identical frequency signatures.

4. **First Unique Character in a String**  
Find index of first non-repeating character.

5. **Intersection of Two Arrays**  
Return elements appearing in both arrays (respecting counts).

## 5. Binary Search (on Arrays)

### When to Use
Array is sorted OR you can define a monotonic condition. You must search for a value, boundary, or answer.

### Key Idea
Check mid → move left or right based on condition.

### Example Problems
1. **Binary Search**  
Return index of target in sorted array.

2. **Search Insert Position**  
Given a sorted array of distinct integers and a target value, return the index where it would be inserted in order to maintain the sorted nature of the array.

3. **Find First and Last Position of Element**  
Binary search for left boundary and right boundary.

4. **Peak Index in Mountain Array**  
Find the peak element using binary search.

5. **Find Minimum in Rotated Sorted Array**  
Binary search for pivot point.

## 6. In-Place Array Manipulation

### When to Use
- You must rearrange the array without extra memory
- Problems mention modifying array "in-place"

### Key Ideas
- Swapping, reversing, fast/slow pointers.

### Example Problems
1. **Rotate Array**  
[RotateArray.java](arrays_strings/RotateArray.java)  
Rotate array by k steps (reverse approach).


2. **Remove Element**  
[RemoveElementOccurrences.java](arrays_strings/RemoveElementOccurrences.java)  
Remove all instances of a value in-place.


3. **Sort Colors (Dutch Flag Problem)**  
[DutchNationalFlag.java](arrays_strings/DutchNationalFlag.java)  
Sort array of 0, 1, 2 using 3-way partitioning.


4. **Merge Sorted Array**  
Merge two sorted arrays in-place from the end.


5. **Duplicate Zeros**  
Duplicate each zero in-place while shifting remaining elements.

## 7. String Manipulation Patterns

### When to Use
- Working heavily with characters
- Need transformation, cleanup, reconstruction

### Key Ideas
Builder patterns, two pointers, parsing

### Example Problems
1. **Valid Palindrome**  
[Palindrome.java](arrays_strings/Palindrome.java)  
Check if a string reads the same forward and backward.


2. **Reverse Words in a String**   
Trim spaces, then reverse order of words.

3. **Longest Common Prefix**  
[LongestCommonPrefix.java](arrays_strings/LongestCommonPrefix.java)  
Find common prefix across all strings.


4. **Implement strStr()**  
[IndexOfString.java](arrays_strings/IndexOfString.java)  
Find first index of substring in string.


5. **Add Binary**  
Add two binary numbers represented as strings.

## 8. Kadane’s Algorithm (Max Subarray Sum)

### When to Use

- Maximum sum subarray (any length)
- Problems involving local vs global maxima

### Key Idea
Keep track of:
- current_max = max(num, current_max + num)
- global_max = max(global_max, current_max)

### Example Problems
1. **Maximum Subarray**  
[Kadane_SubarrayMaximumSum.java](arrays_strings/Kadane_SubarrayMaximumSum.java)  
Find maximum sum of any contiguous subarray in a given array of integers.


2. **Maximum Product Subarray** 
[Kadane_SubarrayMaximumProduct.java](arrays_strings/Kadane_SubarrayMaximumProduct.java)  
Track max or min product of a contiguous subarray in a given array of integers where elements can be negative, positive or zero.


3. **Best Time to Buy and Sell Stock**  
Variation of cumulative gain.


4. **Maximum Circular Subarray**  
Combine Kadane + prefix logic.


5. **Maximum Sum of Hourglass**  
Can be adapted via sliding window + local evaluation.

## 9. Monotonic Stack (Advanced but part of arrays)
### When to Use

If a problem asks, for each element, about the nearest/consecutive element on left or right side of an array that breaks a comparision condition like less than, greater than etc.

- Next/previous greater/smaller element
- Consecutive elements satisfying a condition
- How far can you go until ..
- Span / stock span problems

### Key Idea
Use stack that keeps indices in monotonic order.

### Example Problems
1. **Next Greater Element**  
[MonotonicStack_NextGreaterElement.java](arrays_strings/MonotonicStack_NextGreaterElement.java)  
For each element in the array, find the Next Greater Element (NGE) — the first element to the right of the current element that is strictly greater than it.


2. **Stock Span**  
[MonotonicStack_StockSpan.java](arrays_strings/MonotonicStack_StockSpan.java)  
Given an array of integers where each element represents the price of a stock on a given day, compute the stock span for each day.
The span of a stock’s price on a given day is defined as the maximum number of consecutive days (ending on that day) for which the price of the stock was less than or equal to today’s price.


3. **Daily Temperatures**  
[MonotonicStack_DailyTemperatures.java](arrays_strings/MonotonicStack_DailyTemperatures.java)  
When will you see a warmer day?  
Given a list of integers where each number represents the temperature on a given day.
For each day, determine how many days you would have to wait until a warmer temperature occurs.


4. **Asteroid Collision**  
Simulate collisions with a stack.  
Given an array of integers representing asteroids moving in a straight line, 
Return the state of the asteroids after all collisions have occurred.
   - Each integer represents the size of an asteroid. 
   - The sign of the integer represents the direction:
     - Positive → moving right 
     - Negative → moving left 
   - All asteroids move at the same speed. 
   - A collision occurs only when a right-moving asteroid meets a left-moving asteroid. 
   - When two asteroids collide:
     - The smaller asteroid explodes. 
     - If both asteroids are the same size, both explode. 
     - The larger asteroid continues moving in its original direction. 
   - Asteroids moving in the same direction never collide.


5. **Largest Rectangle in Histogram**  
Given an array of non-negative integers where each integer represents the height of a bar in a histogram (each bar has width 1),
find the area of the largest rectangle that can be formed within the histogram.  
The rectangle must be formed using consecutive bars and its height is limited by the shortest bar in that range.


6. **Trapping Rain Water**  
Use two pointers or monotonic stack.

## 10. Matrix Traversal Patterns

### When to Use
When dealing with 2D grids.

### Key Idea
Directional arrays, boundary checks, BFS/DFS.  
Note that in an `m x n` matrix, `m` is number of rows, i.e. `matrix.length` and `n` is number of columns, which is, `matrix[0].length` if `m > 0`.

### Example Problems
1. **Spiral Matrix**  
[MatrixSpiralTraversal.java](arrays_2D_matrix/MatrixSpiralTraversal.java)  
Given an `m x n` matrix, return all elements of the matrix in spiral order in an array.
Spiral order means:
    1. Start from the top-left corner
   2. Move right across the top row
   3. Then down the last column
   4. Then left across the bottom row
   5. Then up the first column
   6. Continue inward until all elements are visited


2. **Rotate Image**  
[RotateImage.java](arrays_2D_matrix/RotateImage.java)  
Rotate 2D matrix 90° in-place.  
Transpose the matrix (swap rows and columns), i.e. i-j to j-i,
and reverse the rows if clockwise, else reverse columns.


3. **Transpose Matrix**  
Swap rows and columns.


4. **Search a 2D Matrix II**   
[MatrixSearch.java](arrays_2D_matrix/MatrixSearch.java)  
You are given an `m x n` integer matrix.
Integers in each row are sorted in ascending order from left to right.
Integers in each column are sorted in ascending order from top to bottom.
Determine if a given target integer exists in the matrix.


5. **Flood Fill**  
[FloodFill.java](arrays_2D_matrix/FloodFill.java)  
Classic DFS/BFS painting algorithm.  
You are given a 2D matrix (image) of integers, where each integer represents a color.  
You are also given a starting cell (sr, sc) and a newColor value as an integer.  
Perform a flood fill on the image starting from the cell (sr, sc) and return the updated matrix.  
Flood Fill Rules:
   - Change the color of the starting cell and all connected cells (4-directionally: up, down, left, right)
   - Only cells with the same original color as the starting cell are filled 
   - Diagonal cells are not considered connected