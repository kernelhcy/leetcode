package info.kernelhcy.leetcode;

public class P34
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

    public static class Solution
    {
        public int[] searchRange(int[] nums, int target)
        {
            int left = biFind(nums, 0, nums.length - 1, target, true);
            int right = biFind(nums, 0, nums.length - 1, target, false);
            return new int[]{left, right};
        }

        /*
         * nums = [5,7,7,8,8,10], target = 8
         */
        private int biFind(int[] ns, int start, int end, int target, boolean left)
        {
            if (start > end) return -1;
            if (start == end) {
                if (ns[start] == target) {
                    return start;
                } else {
                    return -1;
                }
            }
            if (start + 1 == end) {
                if (ns[start] == target) {
                     if (left) {
                         return start;
                     } else if (ns[end] == target) {
                         return end;
                     } else {
                         return start;
                     }
                } else if (ns[end] == target) {
                    return end;
                } else {
                    return  -1;
                }
            }
            int idx = (start + end) / 2;
            if (ns[idx] > target) {
                return biFind(ns, start, idx, target, left);
            } else if (ns[idx] < target) {
                return biFind(ns, idx, end, target, left);
            } else {
                // ns[idx] == target
                if (left) {
                    return biFind(ns, start, idx, target, left);
                } else {
                    return biFind(ns, idx, end, target, left);
                }
            }
        }
    }
}
