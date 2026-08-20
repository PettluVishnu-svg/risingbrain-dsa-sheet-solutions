/*
Problem Name: Reverse String

Approach:
Use the two-pointer technique to reverse the character array in-place.
- Initialize one pointer at the beginning and another at the end.
- Swap the characters at both pointers.
- Move the left pointer forward and the right pointer backward.
- Continue until the two pointers meet.

Algorithm Used:
Two-Pointer Technique

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;

            left++;
            right--;
        }
    }
}
