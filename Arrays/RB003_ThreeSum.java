/*
Problem Name: 3Sum

Approach:
Sort the array and fix one element at a time. For each fixed element,
use two pointers to find pairs whose sum equals the negative of the
fixed element. Skip duplicate elements to avoid duplicate triplets.

Algorithm Used:
Sorting + Two Pointers

Time Complexity:
O(n²)

Space Complexity:
O(1)
(Excluding the space used for the output list)

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return list;
    }
}
