/*
Problem Name: Subarray Sums Divisible by K

Approach:
Use the Prefix Sum technique with a HashMap to count subarrays whose
sum is divisible by k.
- Maintain a running prefix sum.
- Compute the remainder of the prefix sum when divided by k.
- If the same remainder has appeared before, all previous occurrences
  contribute to valid subarrays because their difference is divisible by k.
- Handle negative remainders by converting them to their positive
  equivalent using:
  rem = (rem + k) % k.

Algorithm Used:
Prefix Sum + HashMap

Time Complexity:
O(n)

Space Complexity:
O(min(n, k))
(The HashMap stores the frequency of remainders.)

*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            int rem = prefix % k;
            if (rem < 0)
                rem += k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
