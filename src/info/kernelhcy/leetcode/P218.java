package info.kernelhcy.leetcode;

import java.util.*;

public class P218
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().getSkyline(new int[][]{
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        }));
    }

    public static class Solution
    {
        public List<List<Integer>> getSkyline(int[][] buildings)
        {
            List<List<Integer>> re = new LinkedList<>();

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            for (int[] b : buildings) {
                queue.offer(new int[]{b[0], -b[2]});
                queue.offer(new int[]{b[1], b[2]});
            }

            TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
            heights.put(0, 1);
            int height = 0;
            while (! queue.isEmpty()) {
                int[] b = queue.poll();
                if (b[1] < 0) {
                    // left
                    heights.put(-b[1], heights.getOrDefault(-b[1], 0) + 1);
                } else {
                    // right
                    heights.put(b[1], heights.get(b[1]) - 1);
                    if (heights.get(b[1]) <= 0) heights.remove(b[1]);
                }

                int maxHeight = heights.keySet().iterator().next();
                if (maxHeight != height) {
                    height = maxHeight;
                    re.add(Arrays.asList(b[0], height));
                }
            }

            return re;
        }
    }
}
