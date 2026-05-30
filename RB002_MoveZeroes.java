/*
Problem Name: Move Zeroes

Approach:
Use two pointers to move all non-zero elements to the front of the array
while maintaining their relative order. The left pointer tracks the position
where the next non-zero element should be placed. Whenever a non-zero element
is found, swap it with the element at the left pointer and increment left.

Algorithm Used:
Two Pointers

Time Complexity:
O(n)

Space Complexity:
O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, temp = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
