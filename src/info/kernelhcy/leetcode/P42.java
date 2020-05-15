package info.kernelhcy.leetcode;

public class P42
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,3,1,0,2,1,2,1}));
        System.out.println(new Solution().trap(new int[]{4,2,3}));
    }

    public static class Solution
    {
        public int trap(int[] height)
        {
            if (height.length <= 0) return 0;
            int idx = 0;
            while (idx < height.length && height[idx] <= 0) ++idx;

            return trap(height, idx);
        }

        private int trap(int[] height, int start)
        {
            if (start >= height.length) return 0;

            for (int i = start + 1; i < height.length; ++i) {
                if (height[i] >= height[start]) {
                    int cnt = 0;
                    for (int j = start + 1; j < i; ++j) {
                        cnt += (height[start] - height[j]);
                    }
                    return cnt + trap(height, i);
                }
            }
            --height[start];
            if (height[start] > 0) {
                return trap(height, start);
            } else {
                return 0;
            }
        }
    }
}
