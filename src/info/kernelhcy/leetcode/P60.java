package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P60
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().getPermutation2(1, 1));
        System.out.println(new Solution().getPermutation2(3, 3));
        System.out.println(new Solution().getPermutation2(3, 9));
        System.out.println(new Solution().getPermutation2(4, 9));
    }

    public static class Solution
    {
        public String getPermutation2(int n, int k)
        {
            int total = 1;
            List<Integer> nums = new LinkedList<>();
            for (int i = 1; i <= n; ++i) {
                nums.add(i);
                total *= i;
            }

            if (k > total) return "";

            StringBuilder sb = new StringBuilder();
            int group = total, idx;
            while (n > 0) {
                group = group / n;
                idx = (k - 1) / group;
                sb.append(nums.remove(idx));

                k -= group * idx;
                --n;
            }
            return sb.toString();
        }


        public String getPermutation(int n, int k)
        {
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; ++i) nums[i] = i + 1;
            return toString(permutation(nums, k));
        }

        private int[] permutation(int[] nums, int k)
        {
            --k;
            while (true) {
                if (k <= 0) return nums;
                int idx1 = -1;
                for (int i = nums.length - 2; i >= 0; --i) {
                    if (nums[i] < nums[i + 1]) {
                        idx1 = i;
                        break;
                    }
                }
                if (idx1 < 0) break;

                int idx2 = -1;
                for (int i = nums.length -1; i > idx1; --i) {
                    if (nums[i] > nums[idx1]) {
                        idx2 = i;
                        break;
                    }
                }

                int tmp = nums[idx1];
                nums[idx1] = nums[idx2];
                nums[idx2] = tmp;
                reverse(nums, idx1 + 1);
                System.out.println("> " + toString(nums));
                --k;
            }
            return nums;
        }

        private void reverse(int[] nums, int start)
        {
            int i = start, j = nums.length - 1;
            int tmp;
            while (i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i;
                --j;
            }
        }

        private String toString(int[] nums)
        {
            StringBuilder s = new StringBuilder();
            for (int n : nums) {
                s.append(n);
            }
            return s.toString();
        }
    }
}
