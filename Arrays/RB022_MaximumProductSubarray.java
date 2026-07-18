/*
Problem Name: Maximum Product Subarray

Approach:
Use two running products: one from the left (prefix) and one from the
right (suffix).
- Traverse the array from both directions simultaneously.
- Reset the running product to 1 whenever it becomes 0, since any
  subarray crossing a zero will have a product of zero.
- Update the maximum product using both prefix and suffix products.
- Traversing from both ends ensures that cases involving an odd number
  of negative values are handled correctly.

Algorithm Used:
Prefix Product + Suffix Product

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int maxPro = -10;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;

            if (suffix == 0)
                suffix = 1;

            prefix *= nums[i];
            suffix *= nums[nums.length - 1 - i];

            maxPro = Math.max(maxPro, Math.max(prefix, suffix));
        }

        return maxPro;
    }
}
