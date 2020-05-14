package info.kernelhcy.leetcode;

import java.util.*;

public class P16
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static class Solution
    {
        public int threeSumClosest(int[] nums, int target)
        {
            int closest = Integer.MAX_VALUE;
            int currentGap = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length - 1; ++j) {
                    int need = target - (nums[i] + nums[j]);

                    int idx = biFind(nums, j + 1, nums.length - 1, need);
                    if (idx > 0 && Math.abs(target - (nums[i] + nums[j] + nums[idx])) < currentGap) {
                        closest = nums[i] + nums[j] + nums[idx];
                        currentGap = Math.abs(target - (nums[i] + nums[j] + nums[idx]));
                    }
                }
            }
            return closest;
        }

        private int biFind(int[] ns, int start, int end, int target)
        {
            if (start > end) return -1;
            if (start == end) return start;
            if (start + 1 == end) {
                if (Math.abs(ns[start] - target) > Math.abs(ns[end] - target)) {
                    return end;
                } else {
                    return start;
                }
            }
            int idx = (start + end) / 2;
            if (ns[idx] > target) {
                return biFind(ns, start, idx, target);
            } else {
                return biFind(ns, idx, end, target);
            }
        }
    }
}
