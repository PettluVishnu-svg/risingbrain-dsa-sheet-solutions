/*
Problem Name: Max Consecutive Ones

Approach:
Traverse the array while maintaining a count of consecutive 1s.
- If the current element is 1, increment the count.
- Update the maximum count encountered so far.
- If the current element is 0, reset the count to 0.

This single-pass approach efficiently finds the longest sequence of
consecutive 1s.

Algorithm Used:
Linear Traversal (Single Pass)

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int i : nums) {
            if (i == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
