package info.kernelhcy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P57
{
    public static void main(String[] args)
    {
        int[][] intervals = new int[][] {
                new int[]{1, 3},
                new int[]{6, 9},
        };
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{2, 5})));

        intervals = new int[][] {
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{6, 7},
                new int[]{8, 10},
                new int[]{12, 16},
        };
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{5, 9})));

        intervals = new int[][]{};
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{4, 8})));

        intervals = new int[][]{
                new int[]{1, 7},
        };
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{4, 8})));
        intervals = new int[][]{
                new int[]{1, 5},
        };
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{0, 0})));
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{0, 3})));
        System.out.println(Arrays.deepToString(new Solution().insert(intervals, new int[]{6, 7})));
    }

    public static class Solution
    {
        public int[][] insert(int[][] intervals, int[] newInterval)
        {
            List<Tuple> is = new LinkedList<>();
            int na = newInterval[0];
            int nb = newInterval[1];
            int mergeA = 0;
            boolean foundA = false, found = false;
            for (int i = 0; i < intervals.length; ++i) {
                if (na > intervals[i][1] || found) {
                    is.add(new Tuple(intervals[i][0], intervals[i][1]));
                } else if (!foundA && na < intervals[i][0]) {
                    foundA = true;
                    mergeA = na;
                    --i;
                } else if (!foundA && na >= intervals[i][0] && na <= intervals[i][1]) {
                    foundA = true;
                    mergeA = intervals[i][0];
                    --i;
                } else if (!foundA && na >= intervals[i][1] && i + 1 < intervals.length && na < intervals[i + 1][0]) {
                    foundA = true;
                    mergeA = na;
                    --i;
                } else if (foundA && nb < intervals[i][0]) {
                    is.add(new Tuple(mergeA, nb));
                    found = true;
                    --i;
                } else if (foundA && nb >= intervals[i][0] && nb <= intervals[i][1]) {
                    is.add(new Tuple(mergeA, intervals[i][1]));
                    found = true;
                } else if (foundA && nb >= intervals[i][1] && i + 1 < intervals.length && nb < intervals[i + 1][0]) {
                    is.add(new Tuple(mergeA, nb));
                    found = true;
                }
            }

            if (foundA && !found) {
                is.add(new Tuple(mergeA, nb));
            }

            if (!found && !foundA) {
                is.add(new Tuple(na, nb));
            }

            int[][] re = new int[is.size()][2];
            for (int i = 0; i < re.length; ++i) {
                re[i][0] = is.get(i).a;
                re[i][1] = is.get(i).b;
            }
            return re;
        }

        private static class Tuple
        {
            public Tuple(int a, int b)
            {
                this.a = a;
                this.b = b;
            }
            int a, b;
        }
    }
}
