/*
Problem Name: Max Consecutive Ones III

Approach:
Use the Sliding Window technique to maintain a window containing at most
k zeros.
- Expand the window by moving the right pointer.
- Count the number of zeros within the current window.
- If the zero count exceeds k, shrink the window from the left until
  the condition is satisfied again.
- The remaining window represents the longest valid subarray where at
  most k zeros can be flipped to 1s.

Algorithm Used:
Sliding Window (Two Pointers)

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroCount++;

            if (zeroCount > k) {
                if (nums[left] == 0)
                    zeroCount--;

                left++;
            }
        }

        return right - left;
    }
}
