/*
Problem Name: Minimum Size Subarray Sum

Approach:
Use the Sliding Window technique to find the smallest contiguous subarray
whose sum is greater than or equal to the target.
- Expand the window by adding the current element to the running sum.
- While the current sum is greater than or equal to the target, update
  the minimum window length and shrink the window from the left.
- If no valid subarray exists, return 0.

Algorithm Used:
Sliding Window (Two Pointers)

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
