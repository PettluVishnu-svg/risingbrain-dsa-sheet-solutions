/*
Problem Name: Valid Palindrome II

Approach:
Use the two-pointer technique to determine whether the string can
become a palindrome by deleting at most one character.
- Start with pointers at both ends of the string.
- Compare characters while moving the pointers inward.
- When a mismatch is found, try skipping either the left character
  or the right character.
- If either remaining substring is a palindrome, return true.

Algorithm Used:
Two-Pointer Technique

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return (isPalindrome(s, left + 1, right) ||
                        isPalindrome(s, left, right - 1));
            }

            left++;
            right--;
        }

        return true;
    }
}
