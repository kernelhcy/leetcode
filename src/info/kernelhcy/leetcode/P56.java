package info.kernelhcy.leetcode;

import java.util.*;

public class P56
{
    public static void main(String[] args)
    {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        };
        System.out.println(Arrays.deepToString(new Solution().merge2(intervals)));

        intervals = new int[][]{
                new int[]{3, 6},
                new int[]{1, 3},
        };
        System.out.println(Arrays.deepToString(new Solution().merge2(intervals)));
    }

    public static class Solution
    {
        public int[][] merge2(int[][] intervals)
        {
            int[][] re = new int[intervals.length][2];
            int reLen = 0;

            for (int i = 0; i < intervals.length; ++i) {
                for (int j = i + 1; j < intervals.length; ++j) {
                    if (intervals[j][0] < intervals[i][0]) {
                        int t1, t2;
                        t1 = intervals[i][0];
                        t2 = intervals[i][1];

                        intervals[i][0] = intervals[j][0];
                        intervals[i][1] = intervals[j][1];

                        intervals[j][0] = t1;
                        intervals[j][1] = t2;
                    }
                }
            }

            int idx = 0;
            while (true) {
                if (idx == intervals.length - 1) {
                    re[reLen][0] = intervals[idx][0];
                    re[reLen][1] = intervals[idx][1];
                    ++reLen;
                    ++idx;
                    break;
                }

                if (intervals[idx + 1][0] >= intervals[idx][0] && intervals[idx + 1][0] <= intervals[idx][1]) {
                    intervals[idx + 1][0] = intervals[idx][0];
                    intervals[idx + 1][1] = Math.max(intervals[idx][1], intervals[idx + 1][1]);
                } else {
                    re[reLen][0] = intervals[idx][0];
                    re[reLen][1] = intervals[idx][1];
                    ++reLen;
                }
                ++idx;
            }

            while (idx < intervals.length) {
                re[reLen][0] = intervals[idx][0];
                re[reLen][1] = intervals[idx][1];
                ++reLen;
                ++idx;
            }

            int[][] rr = new int[reLen][2];
            for (int i = 0; i < reLen; ++i) {
                rr[i][0] = re[i][0];
                rr[i][1] = re[i][1];
            }
            return rr;
        }


        public int[][] merge(int[][] intervals)
        {
            List<Tuple> ts = new ArrayList<>(intervals.length);
            for (int[] interval : intervals) {
                ts.add(new Tuple(interval[0], interval[1]));
            }
            Collections.sort(ts);
            List<Tuple> re = new ArrayList<>();
            Stack<Tuple> stack = new Stack<>();
            for (int i = ts.size() - 1; i >= 0; --i) {
                stack.push(ts.get(i));
            }

            while (stack.size() > 1) {
                Tuple t1 = stack.pop();
                Tuple t2 = stack.pop();
                boolean merge = false;
                if (t2.a >= t1.a && t2.a <= t1.b) {
                    merge = true;
                    stack.push(new Tuple(t1.a, Math.max(t1.b, t2.b)));
                }
                if (!merge) {
                    re.add(t1);
                    stack.push(t2);
                }
            }

            while (!stack.isEmpty()) re.add(stack.pop());

            int[][] rea = new int[re.size()][2];
            for (int i = 0; i < re.size(); ++i) {
                rea[i][0] = re.get(i).a;
                rea[i][1] = re.get(i).b;
            }
            return rea;
        }

        private static class Tuple implements Comparable<Tuple>
        {
            public Tuple(int a, int b)
            {
                this.a = a;
                this.b = b;
            }

            int a, b;

            @Override
            public int compareTo(Tuple o)
            {
                return a - o.a;
            }
        }
    }
}
