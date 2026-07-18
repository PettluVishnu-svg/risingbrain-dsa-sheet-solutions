/*
Problem Name: Maximum Subarray

Approach:
Use Kadane's Algorithm to find the maximum sum of any contiguous subarray.
- Maintain a running sum while traversing the array.
- Update the maximum subarray sum whenever the current sum exceeds it.
- If the current sum becomes negative, reset it to zero since it cannot
  contribute to a larger subarray sum in the future.

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
