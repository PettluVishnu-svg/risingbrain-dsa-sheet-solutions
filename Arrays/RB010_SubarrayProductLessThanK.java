/*
Problem Name: Subarray Product Less Than K

Approach:
Use the Sliding Window technique to maintain a window whose product is
less than k.
- Expand the window by multiplying the current element.
- If the product becomes greater than or equal to k, shrink the window
  from the left until the product is less than k.
- For each valid window ending at the current index, all subarrays
  within that window are valid. Add (right - left + 1) to the answer.

Algorithm Used:
Sliding Window (Two Pointers)

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int count = 0;
        int left = 0;
        int pro = 1;

        for (int right = 0; right < nums.length; right++) {
            pro *= nums[right];

            while (pro >= k) {
                pro /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
