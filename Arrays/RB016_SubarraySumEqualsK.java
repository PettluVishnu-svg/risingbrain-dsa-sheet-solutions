/*
Problem Name: Subarray Sum Equals K

Approach:
Use the Prefix Sum technique along with a HashMap to efficiently count
the number of subarrays whose sum equals k.
- Maintain a running prefix sum while traversing the array.
- For each prefix sum, check if (prefixSum - k) has been seen before.
- If it exists, all previous occurrences contribute to valid subarrays.
- Store the frequency of each prefix sum in the HashMap.

Algorithm Used:
Prefix Sum + HashMap

Time Complexity:
O(n)

Space Complexity:
O(n)

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
