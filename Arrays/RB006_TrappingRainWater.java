/*
Problem Name: Trapping Rain Water

Approach:
Use two pointers starting from both ends of the array while maintaining
the maximum height seen so far from the left and right sides.

1. Keep track of leftMax and rightMax.
2. The side with the smaller maximum determines the amount of water
   that can be trapped at that position.
3. Move the corresponding pointer inward.
4. Water trapped at a position is calculated as:
   currentMax - currentHeight.

This allows us to compute the trapped water in a single traversal
without using extra arrays.

Algorithm Used:
Two Pointers + Prefix Maximums

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int trappedWater = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += (leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += (rightMax - height[right]);
            }
        }

        return trappedWater;
    }
}
