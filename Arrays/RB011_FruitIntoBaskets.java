/*
Problem Name: Fruit Into Baskets

Approach:
Use the Sliding Window technique with a HashMap to maintain the count
of each fruit type within the current window.
- Expand the window by adding the current fruit.
- If the window contains more than two distinct fruit types, shrink
  the window from the left until only two types remain.
- Continuously update the maximum window size, which represents the
  maximum number of fruits that can be collected.

Algorithm Used:
Sliding Window + HashMap

Time Complexity:
O(n)

Space Complexity:
O(1)
(The HashMap stores at most 3 fruit types, so the space is constant.)

*/

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            if (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
