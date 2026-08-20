/*
Problem Name: Find All Anagrams in a String

Approach:
Use the Sliding Window technique with a HashMap to maintain the
frequency of characters.
- Store the required frequency of each character from the pattern.
- Maintain a sliding window of the same size as the pattern.
- Decrease the required frequency when a character enters the window.
- Increase it when a character leaves the window.
- Maintain a count of characters that still need to be matched.
- When count becomes 0, the current window is an anagram of the pattern.

Algorithm Used:
Sliding Window + HashMap

Time Complexity:
O(n)

Space Complexity:
O(k)

Where k is the number of distinct characters in the pattern.

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = p.length();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            int val = map.getOrDefault(ch, 0);

            if (val > 0)
                count--;

            map.put(ch, val - 1);

            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);

                int leftVal = map.getOrDefault(leftChar, 0);

                if (leftVal >= 0)
                    count++;

                map.put(leftChar, leftVal + 1);
                left++;
            }

            if (count == 0) {
                result.add(left);
            }
        }

        return result;
    }
}
