# Heaps

A **Heap** (also known as a **Priority Queue**) is a specialized tree-based data structure that allows you to quickly access the "best" element (the minimum or maximum) in a collection.

---

## 1. Core Concept
[HeapWithArray.java](heaps/HeapWithArray.java)
* **The Heap Property:**
    * **Min-Heap:** Every node is smaller than or equal to its children. The smallest element is always at the root.
    * **Max-Heap:** Every node is larger than or equal to its children. The largest element is always at the root.
* **Structure:** It is a **Complete Binary Tree**. This means all levels are fully filled except possibly the last level, which is filled from left to right.
* **Array Representation:** Because it's a complete tree, we store it in an array for efficiency:
    * **Left Child:** `2 * i + 1`
    * **Right Child:** `2 * i + 2`
    * **Parent:** `(i - 1) / 2`
* **Operations**
    * **Move Up:** While adding, add to the end of the array and keep replacing with parent if needed
    * **Move Down:** While removing, bring last one to the front and keep replacing with the correct child if needed

---

## 2. Complexity Analysis
| Operation          | Time Complexity | Note                                          |
|:-------------------|:----------------|:----------------------------------------------|
| **Push (Insert)**  | $O(\log n)$     | Add to end, then "sift up"                    |
| **Pop (Extract)**  | $O(\log n)$     | Swap root with last element, then "sift down" |
| **Peek (Min/Max)** | $O(1)$          | Access index `0`                              |
| **Heapify**        | $O(n)$          | Transform a list into a heap in-place         |

---

## 3. Common Interview Patterns

### A. Top K Elements
- [Heap_Largest_Kth_Element.java](heaps/Heap_Largest_Kth_Element.java)
- [Heap_Smallest_Kth_Element.java](heaps/Heap_Smallest_Kth_Element.java)

If a problem asks for the $K$ largest elements:
1.  Maintain a **Min-Heap** (?, yes) of size $K$.
2.  Iterate through the data.
3.  If the current element is larger than the heap's root, replace the root.
4.  By the end, the heap contains the $K$ largest elements.

### B. Two Heaps (Median Finding)
[Heap_Median_From_Data_Stream.java](heaps/Heap_Median_From_Data_Stream.java)

Find Median from Data Stream.

You are receiving a continuous stream of integers. At any given moment, you need to be able to report the median of all the integers you have seen so far.
The median is the middle value (mid-element or avg of two mid-elements) in an ordered integer list.

### C. K-Way Merge
[Heap_K_Way_Merge.java](heaps/Heap_K_Way_Merge.java)

Used for merging multiple sorted lists into one:
1.  Push the first element of each list into a Min-Heap.
2.  Pop the smallest, add to result, then push the next element from that same list.

---

## 4. Language Implementation Cheat Sheet

### Python (`heapq`)
* **Default:** Min-Heap.
* **Functions:** `heapq.heappush(heap, val)`, `heapq.heappop(heap)`, `heapq.heapify(list)`.
* **Max-Heap Tip:** Multiply values by `-1` to simulate a Max-Heap.

### Java (`PriorityQueue`)
* **Default:** Min-Heap.
* **Max-Heap:** `new PriorityQueue<>(Collections.reverseOrder())`.

### C++ (`priority_queue`)
* **Default:** **Max-Heap**.
* **Min-Heap:** `priority_queue<int, vector<int>, greater<int>>`.

---

## 5. When to use Heaps?
* You need to find the "Top K" of something.
* You need to repeatedly find the smallest or largest element while adding new data.
* The problem involves "scheduling" or "prioritizing" tasks.