package info.kernelhcy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P46
{
    public static void main(String[] args)
    {
        new Solution().permute(new int[]{1, 2, 3});
    }

    public static class Solution
    {
        public List<List<Integer>> permute(int[] nums)
        {
            List<List<Integer>> re = new LinkedList<>();
            if (nums.length <= 0) return re;
            if (nums.length == 1) {
                re.add(new ArrayList<>());
                re.get(0).add(nums[0]);
                return re;
            }
            Arrays.sort(nums);

            permute(nums, re, new ArrayList<>());

            return re;
        }

        public void permute(int[] nums, List<List<Integer>> res, List<Integer> part)
        {
            if (nums.length <= 0) {
                res.add(new ArrayList<>(part));
                return;
            }

            for (int i = 0; i < nums.length; ++i) {
                int n = nums[i];
                swap(nums, 0, i);
                int[] newNums = Arrays.copyOfRange(nums, 1, nums.length);
                List<Integer> rr = new ArrayList<>(part);
                rr.add(n);
                permute(newNums, res, rr);
                swap(nums, 0, i);
            }
        }

        private void swap(int[] ns, int i, int j)
        {
            int tmp = ns[i];
            ns[i] = ns[j];
            ns[j] = tmp;
        }
    }
}
