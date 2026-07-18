/*
Problem Name: Find Pivot Index

Approach:
First, calculate the total sum of all elements in the array.
Then, traverse the array while maintaining the sum of elements to the
left of the current index.
- Compute the right sum as:
  totalSum - leftSum - currentElement.
- If the left and right sums are equal, the current index is the pivot.
- Otherwise, update the left sum and continue.

Algorithm Used:
Prefix Sum

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int rightSum = sum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
