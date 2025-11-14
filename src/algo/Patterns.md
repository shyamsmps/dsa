## Sliding Window
Whenever you see a problem that not only describes **_subarrays_** being "valid", 
but also asks you to find these **_subarrays_**, 
you should immediately think about sliding window.


Often, the problem will ask you to find the best **_valid subarray_**. 
The problem will define what makes one subarray better than another. 
For example, a problem might ask you to find the **_longest valid subarray_**.

### Complexity
A sliding window guarantees a maximum of **_2n_** window iterations, 
the right pointer can move n times and the left pointer can move n times.

### Examples
1. Given an array of positive integers `nums` and an integer `k`, 
find the length of the longest subarray whose sum is less than or equal to `k`. 
2. You are given a binary string `s` (a string containing only "0" and "1"). 
You may choose up to one "0" and flip it to a "1". 
What is the length of the longest substring achievable that contains only "1"?
3. Given an array of positive integers nums and an integer k, 
return the number of subarrays where the product of all the elements in the subarray is strictly less than k.
4. Given an integer array nums and an integer k, 
find the sum of the subarray with the largest sum whose length is k.