/*
Problem Name: Maximum Absolute Sum of Any Subarray

Approach:
Use Kadane's Algorithm twice to find both the maximum subarray sum
and the minimum subarray sum.
- The maximum subarray sum gives the largest positive subarray sum.
- The minimum subarray sum gives the largest negative subarray sum.
- Take the maximum of the positive maximum and the absolute value
  of the negative minimum.

Algorithm Used:
Kadane's Algorithm (Maximum + Minimum Subarray Sum)

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;

        int curMax = 0;
        int maxSum = nums[0];

        int curMin = 0;
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(minSum, curMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}
