package info.kernelhcy.leetcode;

import java.util.*;

public class P90
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().subsets(new int[]{1,2,2}));
    }

    public static class Solution
    {
        public List<List<Integer>> subsets(int[] nums)
        {
            List<List<Integer>> r = new LinkedList<>();
            if (nums.length <= 0) return r;

            int n = (int) Math.pow(2, nums.length);
            for (int i = 0; i < n; ++i) {
                r.add(toSet(nums, i));
            }


            return new ArrayList<>(new HashSet<>(r));
        }

        private List<Integer> toSet(int[] nums, int n)
        {
            List<Integer> set = new LinkedList<>();
            for (int num : nums) {
                if (n == 0) break;
                if ((n & 1) == 1) {
                    set.add(num);
                }
                n >>= 1;
            }
            Collections.sort(set);
            return set;
        }
    }
}
