/*
Problem Name: Valid Palindrome

Approach:
Use the two-pointer technique to check whether the string is a palindrome.
- Initialize one pointer at the beginning and another at the end.
- Skip characters that are not letters or digits.
- Compare both characters after converting them to lowercase.
- If the characters are different, the string is not a palindrome.
- Move both pointers inward and continue until they meet.

Algorithm Used:
Two-Pointer Technique

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;

            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
