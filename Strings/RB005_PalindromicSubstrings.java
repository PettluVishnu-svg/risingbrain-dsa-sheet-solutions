/*
Problem Name: Palindromic Substrings

Approach:
Generate all possible substrings and check whether each substring
is a palindrome.
- Use two nested loops to generate every possible substring.
- For each substring, use the two-pointer technique to check whether
  it reads the same forwards and backwards.
- Increment the count whenever a palindrome is found.

Algorithm Used:
Brute Force + Two-Pointer Palindrome Check

Time Complexity:
O(n³)

Space Complexity:
O(1)

*/

class Solution {

    static int isPalindrome(String s, int i, int j) {
        int left = i;
        int right = j;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 0;
            }

            left++;
            right--;
        }

        return 1;
    }

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                count += isPalindrome(s, i, j);
            }
        }

        return count;
    }
}
