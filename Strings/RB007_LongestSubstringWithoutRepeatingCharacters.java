/*
Problem Name: Longest Substring Without Repeating Characters

Approach:
Use the Sliding Window technique with a frequency array to find the
longest substring without repeating characters.
- Maintain a window using left and right pointers.
- Increase the frequency of the character when the right pointer moves.
- If the current character appears more than once, move the left pointer
  until the duplicate is removed.
- Track the maximum window length found.

Algorithm Used:
Sliding Window + Frequency Array

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        int[] freq = new int[128];

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            freq[s.charAt(right)]++;

            while (freq[s.charAt(right)] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }
}
