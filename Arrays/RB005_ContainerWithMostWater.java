/*
Problem Name: Container With Most Water

Approach:
Use two pointers, one at the beginning and one at the end of the array.
At each step:
1. Calculate the area formed by the two lines.
2. Update the maximum area found so far.
3. Move the pointer corresponding to the shorter line inward,
   since moving the taller line cannot increase the area while
   the shorter line remains the limiting factor.

This greedy strategy ensures all promising containers are considered
in a single pass.

Algorithm Used:
Two Pointers

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int maxArea(int[] height) {
        if (height.length == 2)
            return Math.min(height[0], height[1]);

        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int waterHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = width * waterHeight;

            maxArea = Math.max(maxArea, area);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
