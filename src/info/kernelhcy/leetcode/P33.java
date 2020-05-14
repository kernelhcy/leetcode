package info.kernelhcy.leetcode;

public class P33
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(new Solution().search(new int[]{4,5,6,7,0,1,2}, 3));
    }

    public static class Solution
    {
        public int search(int[] nums, int target)
        {
            return biFind(nums, 0, nums.length - 1, target);
        }

        private int biFind(int[] ns, int start, int end, int target)
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
                    return start;
                } else if (ns[end] == target) {
                    return end;
                } else {
                    return -1;
                }
            }
            int mid = (start + end) / 2;

            if (ns[mid] > ns[end]) {
                if (target >= ns[start] && target <= ns[mid]) {
                    return biFind(ns, start, mid, target);
                } else {
                    return biFind(ns, mid, end, target);
                }
            } else if (ns[mid] < ns[start]) {
                if (target >= ns[mid] && target <= ns[end]) {
                    return biFind(ns, mid, end, target);
                } else {
                    return biFind(ns, start, mid, target);
                }
            } else {
                if (ns[mid] > target) {
                    return biFind(ns, start, mid, target);
                } else {
                    return biFind(ns, mid, end, target);
                }
            }
        }
    }
}
