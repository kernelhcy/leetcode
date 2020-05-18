package info.kernelhcy.leetcode;

import java.util.Arrays;

public class P45
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().jump2(new int[]{1, 2, 3}));
        System.out.println(new Solution().jump2(new int[]{2,3,1,1,4}));
        System.out.println(new Solution().jump2(new int[]{2,3,0,1,4}));
        System.out.println(new Solution().jump2(new int[]{0}));
        System.out.println(new Solution().jump2(new int[]{1, 2}));
    }

    public static class Solution
    {
        public int jump(int[] nums)
        {
            for (int i = 0; i < nums.length; ++i) {
                if (i + nums[i] >= nums.length - 1) return 1;
            }

            int maxNum = -1;
            for (int num : nums) {
                if (num > maxNum) {
                    maxNum = num;
                }
            }

            int[][] map = new int[nums.length][maxNum + 1];
            for (int[] m : map) {
                Arrays.fill(m, -1);
            }

            map[map.length - 1][0] = 0;

            for (int i = nums.length - 2; i >= 0; --i) {
                for (int j = 1; j <= nums[i] && i + j < nums.length; ++j) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k <= nums[i + j]; ++k) {
                        if (map[i + j][k] >= 0) {
                            int tmp = 1 + map[i + j][k];
                            if (min > tmp) min = tmp;
                        }
                    }
                    if (min != Integer.MAX_VALUE) map[i][j] = min;
                }
            }

            int re = Integer.MAX_VALUE;
            for (int i = 0; i <= maxNum; ++i) {
                if (map[0][i] >= 0 && map[0][i] < re) re = map[0][i];
            }
            return re;
        }

        public int jump2(int[] nums)
        {
            if (nums.length <= 1) return 0;

            int step = 1;
            int index = 0;
            while (true) {
                if (index + nums[index] >= nums.length - 1) return step;
                int ma = -1, mi = -1;
                for (int i = 1; i <= nums[index]; ++i) {
                    if (index + i >= nums.length - 1) {
                        return step + 1;
                    }
                    if (ma < (index + i + nums[index + i])) {
                        ma = (index + i + nums[index + i]);
                        mi = index + i;
                    }
                }
                if (ma >= nums.length - 1) {
                    return step + 1;
                }
                ++step;
                index = mi;
            }
        }
    }
}
