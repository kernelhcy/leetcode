package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P77
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().combine(4, 1));
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(5, 2));
    }

    public static class Solution
    {
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
