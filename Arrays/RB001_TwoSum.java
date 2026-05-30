/*
Problem Name: Two Sum II - Input Array Is Sorted

Approach:
Since the array is sorted in non-decreasing order, use two pointers:
1. Place one pointer at the beginning and another at the end.
2. Calculate the sum of elements at both pointers.
3. If the sum equals the target, return their 1-based indices.
4. If the sum is smaller than the target, move the left pointer forward.
5. If the sum is greater than the target, move the right pointer backward.
6. Continue until the target pair is found.

Algorithm Used:
Two Pointers

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] targetIndices = new int[2];
        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                targetIndices[0] = left + 1;
                targetIndices[1] = right + 1;
                return targetIndices;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return targetIndices;
    }
}
