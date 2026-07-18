/*
Problem Name: Product of Array Except Self

Approach:
Compute the product of all elements except the current one without using
division.
- In the first pass, store the product of all elements to the left of
  each index in the answer array.
- In the second pass, traverse from right to left while maintaining a
  running suffix product.
- Multiply the stored prefix product with the suffix product to obtain
  the final result for each index.

Algorithm Used:
Prefix Product + Suffix Product

Time Complexity:
O(n)

Space Complexity:
O(1)
(Excluding the output array)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int suf = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suf;
            suf *= nums[i];
        }

        return ans;
    }
}
