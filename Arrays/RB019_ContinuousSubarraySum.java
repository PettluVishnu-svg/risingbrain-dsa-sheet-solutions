/*
Problem Name: Continuous Subarray Sum

Approach:
Use the Prefix Sum technique with a HashMap to determine whether there
exists a continuous subarray of length at least two whose sum is a
multiple of k.
- Maintain a running prefix sum.
- Compute the remainder of the prefix sum when divided by k.
- If the same remainder has been seen before, the sum of the elements
  between the two indices is divisible by k.
- Ensure the subarray length is at least two before returning true.
- Store only the first occurrence of each remainder to maximize the
  possible subarray length.

Algorithm Used:
Prefix Sum + HashMap

Time Complexity:
O(n)

Space Complexity:
O(min(n, k))
(In the worst case, the HashMap stores distinct remainders.)

*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int rem = prefix % k;

            if (map.containsKey(rem)) {
                if ((i - map.get(rem)) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }

        return false;
    }
}
