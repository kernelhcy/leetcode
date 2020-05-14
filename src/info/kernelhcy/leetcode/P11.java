package info.kernelhcy.leetcode;

import java.util.Objects;

public class P11
{
    public static void main(String[] args)
    {
        int[] hs = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(new Solution().maxArea(hs));
    }

    public static class Solution
    {
        public int maxArea(int[] height)
        {
            if (Objects.isNull(height) || height.length < 2) {
                return 0;
            }

            if (height.length == 2) {
                return Math.min(height[0], height[1]);
            }

            int max = -1;
            for (int i = 0; i < height.length; ++i) {
                for (int j = i + 1; j < height.length; ++j) {
                    int area = Math.min(height[i], height[j]) * (j - i);
                    if (area > max) {
                        max = area;
                    }
                }
            }
            return max;
        }
    }
}
