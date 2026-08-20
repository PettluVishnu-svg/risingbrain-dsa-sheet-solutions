/*
Problem Name: Maximum Subarray

Approach:
Use Kadane's Algorithm to find the maximum sum of a contiguous
subarray.
- Maintain a running sum of the current subarray.
- Update the maximum sum whenever the current sum is greater.
- If the current sum becomes negative, reset it to 0 because
  a negative sum cannot contribute to a better future subarray.

Algorithm Used:
Kadane's Algorithm

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            maxSum = Math.max(maxSum, curSum);

            if (curSum < 0) {
                curSum = 0;
            }
        }

        return maxSum;
    }
}
