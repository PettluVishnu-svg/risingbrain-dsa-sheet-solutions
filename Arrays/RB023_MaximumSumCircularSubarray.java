/*
Problem Name: Maximum Sum Circular Subarray

Approach:
Use Kadane's Algorithm to find both the maximum subarray sum and
the minimum subarray sum.
- The maximum subarray sum gives the best non-circular subarray.
- The circular maximum sum can be found by subtracting the minimum
  subarray sum from the total array sum.
- If all elements are negative, return the maximum subarray sum directly,
  because total - minSum would incorrectly result in 0.

Algorithm Used:
Kadane's Algorithm (Maximum + Minimum Subarray Sum)

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int curMax = 0;

        int minSum = nums[0];
        int curMin = 0;

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + nums[i], nums[i]);
            minSum = Math.min(minSum, curMin);

            total += nums[i];
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(total - minSum, maxSum);
    }
}
