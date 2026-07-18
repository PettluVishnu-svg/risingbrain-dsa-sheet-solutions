/*
Problem Name: Subarrays with K Different Integers

Approach:
The number of subarrays containing exactly k distinct integers can be
calculated by subtracting:
- Subarrays with at most (k - 1) distinct integers
from
- Subarrays with at most k distinct integers.

A helper method uses the Sliding Window technique with a HashMap to
count subarrays containing at most k distinct integers.

Algorithm Used:
Sliding Window + HashMap

Time Complexity:
O(n)

Space Complexity:
O(k)

*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int allSubarrays = subarrays(nums, k);
        int invalidSubarrays = subarrays(nums, k - 1);
        return allSubarrays - invalidSubarrays;
    }

    static int subarrays(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
