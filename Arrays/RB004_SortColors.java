/*
Problem Name: Sort Colors

Approach:
Use the Dutch National Flag Algorithm to sort the array in a single pass.
Maintain three pointers:
- low: next position for 0
- mid: current element being processed
- high: next position for 2

Rules:
1. If nums[mid] == 0, swap with low and move both pointers.
2. If nums[mid] == 1, move mid.
3. If nums[mid] == 2, swap with high and decrease high.

This partitions the array into:
[0s | 1s | unprocessed | 2s]

Algorithm Used:
Dutch National Flag Algorithm (Three Pointers)

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, low, mid);
                low++;
                mid++;
            }
        }
    }
}
