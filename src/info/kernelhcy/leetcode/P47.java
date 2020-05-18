package info.kernelhcy.leetcode;

import java.util.*;

public class P47
{
    public static void main(String[] args)
    {
        new Solution().permuteUnique(new int[]{1, 1, 3});
    }

    public static class Solution
    {
        private Set<List<Integer>> sets = new HashSet<>();

        public List<List<Integer>> permuteUnique(int[] nums)
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
                if (!sets.contains(part)) {
                    List<Integer> re = new ArrayList<>(part);
                    res.add(re);
                    sets.add(re);
                    return;
                }
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
