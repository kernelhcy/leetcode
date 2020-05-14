package info.kernelhcy.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class P40
{
    public static void main(String[] args)
    {

    }

    public static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target)
        {
            Arrays.sort(candidates);
            List<List<Integer>> res = new LinkedList<>();
            if (candidates.length <= 0 || target <= 0) {
                return res;
            }

            Set<List<Integer>> dups = new HashSet<>();
            combinationSum(candidates, -1, target, new LinkedList<>(), res, dups);
            return res;
        }

        public void combinationSum(int[] candidates, int start, int target, List<Integer> ops,
                                   List<List<Integer>> res, Set<List<Integer>> dups)
        {
            if (target <= 0) {
                List<Integer> tmp = new ArrayList<>(ops);
                if (!dups.contains(tmp)) {
                    res.add(tmp);
                    dups.add(tmp);
                }
                return;
            }

            for (int i = start + 1; i < candidates.length; ++i) {
                if (candidates[i] <= target) {
                    List<Integer> tmp = new LinkedList<>(ops);
                    tmp.add(candidates[i]);
                    combinationSum(candidates, i, target - candidates[i], tmp, res, dups);

                }
            }
        }
    }
}
