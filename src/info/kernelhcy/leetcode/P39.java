package info.kernelhcy.leetcode;

import java.util.*;

public class P39
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public List<List<Integer>> combinationSum(int[] candidates, int target)
        {
            Arrays.sort(candidates);
            List<List<Integer>> res = new LinkedList<>();
            if (candidates.length <= 0 || target <= 0) {
                return res;
            }
            combinationSum(candidates, 0, target, new LinkedList<>(), res);
            return res;
        }

        public void combinationSum(int[] candidates, int start, int target, List<Integer> ops, List<List<Integer>> res)
        {
            if (target <= 0) {
                res.add(new ArrayList<>(ops));
                return;
            }

            for (int i = start; i < candidates.length; ++i) {
                if (candidates[i] <= target) {
                    List<Integer> tmp = new LinkedList<>(ops);
                    tmp.add(candidates[i]);
                    combinationSum(candidates, i, target - candidates[i], tmp, res);

                }
            }
        }
    }
}
