/*
Problem Name: Longest Substring with K Unique Characters

Approach:
Use the Sliding Window technique with a HashMap to find the longest
substring containing exactly K distinct characters.
- Expand the window by moving the right pointer.
- Store the frequency of each character in the HashMap.
- If the window contains more than K distinct characters, move the
  left pointer until the number of distinct characters becomes K or less.
- Whenever the window contains exactly K distinct characters, update
  the maximum length.

Algorithm Used:
Sliding Window + HashMap

Time Complexity:
O(n)

Space Complexity:
O(k)

*/

class Solution {
    public int longestKSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = -1;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            if (map.size() == k) {
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }
}
