package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P78
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().subsets(new int[]{1,2 ,3}));
    }
    public static class Solution
    {
        public List<List<Integer>> subsets(int[] nums)
        {
            List<List<Integer>> r = new LinkedList<>();
            r.add(new LinkedList<>());
            if (nums.length <= 0) return r;

            List<List<Integer>> result = new LinkedList<>();
            for (int i = 0; i < nums.length; ++i) {
                result.addAll(combine(nums.length, i + 1));
            }

            for (List<Integer> list : result) {
                r.add(list.stream().map(i -> nums[i - 1]).collect(Collectors.toList()));
            }
            return r;
        }

        public List<List<Integer>> combine(int n, int k)
        {
            List<List<Integer>> result = new LinkedList<>();
            if (n <= 0 || k <= 0) return result;
            combine(1, n, k, result, new LinkedList<>());
            return result;
        }

        private void combine(int start, int n, int k, List<List<Integer>> result, List<Integer> part)
        {
            if (k == 1) {
                for (int i = start; i <= n; ++i) {
                    List<Integer> l = new LinkedList<>(part);
                    l.add(i);
                    result.add(l);
                }
                return;
            }

            for (int i = start; i <= n; ++i) {
                List<Integer> newPart = new LinkedList<>(part);
                newPart.add(i);
                combine(i + 1, n, k - 1, result, newPart);
            }
        }
    }
}
