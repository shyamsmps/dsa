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
Rotate array by k steps (reverse approach).

2. **Remove Element**  
Remove all instances of a value in-place.

3. **Sort Colors (Dutch Flag Problem)**  
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

Example Problems
1. Valid Palindrome

Check if a string reads the same forward and backward.

2. Reverse Words in a String

Trim spaces, then reverse order of words.

3. Longest Common Prefix

Find common prefix across all strings.

4. Implement strStr()

Find first index of substring in string.

5. Add Binary

Add two binary numbers represented as strings.

## 8. Kadane’s Algorithm (Max Subarray Sum)
When to Use

When finding:

Maximum sum subarray (any length)

Problems involving local vs global maxima

Key Idea

Keep track of:

current_max = max(num, current_max + num)
global_max = max(global_max, current_max)

Example Problems
1. Maximum Subarray

Find maximum sum of any contiguous subarray.

2. Maximum Product Subarray

Track max and min product due to negative numbers.

3. Best Time to Buy and Sell Stock

Variation of cumulative gain.

4. Maximum Circular Subarray

Combine Kadane + prefix logic.

5. Maximum Sum of Hourglass

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
For each element in the array, find the Next Greater Element (NGE) — the first element to the right of the current element that is strictly greater than it.


2. **Stock Span**  
Given an array of integers where each element represents the price of a stock on a given day, compute the stock span for each day.
The span of a stock’s price on a given day is defined as the maximum number of consecutive days (ending on that day) for which the price of the stock was less than or equal to today’s price.


3. **Daily Temperatures**  
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
When to Use

When dealing with 2D grids.

Key Idea

Directional arrays, boundary checks, BFS/DFS.

Example Problems
1. Spiral Matrix

Return elements in spiral order.

2. Rotate Image

Rotate 2D matrix 90° in-place.

3. Transpose Matrix

Swap rows and columns.

4. Search a 2D Matrix II

Binary search + sorted rows/cols.

5. Flood Fill

Classic DFS/BFS painting algorithm.