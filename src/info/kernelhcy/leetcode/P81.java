package info.kernelhcy.leetcode;

public class P81
{
    public static void main(String[] args)
    {
//        System.out.println(new Solution().search(new int[]{2,5,6,7,0,0,1,2}, 0));
        System.out.println(new Solution().search(new int[]{1,2,3,4,6}, 0));
        System.out.println(new Solution().search(new int[]{1,1,1,1,1}, 0));
    }

    public static class Solution
    {
        public boolean search(int[] nums, int target)
        {
            if (nums.length <= 0) return false;
            if (nums.length == 1) return nums[0] == target;
            if (nums.length == 2) return nums[0] == target || nums[1] == target;

            int pivot = findPivot(nums);
            if (pivot <= 0) {
                
            }
            return false;
        }

        private int findPivot(int[] nums)
        {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                if (left == right) return left;
                if (left + 1 == right) return right;

                int mid = (left + right) / 2;
                if (nums[mid] < nums[nums.length - 1]) right = mid;
                if (nums[mid] >= nums[0]) left = mid;

                if (nums[mid] >= nums[0] && nums[mid] <= nums[nums.length - 1]) return -1;
            }
            return -1;
        }

        public boolean search2(int[] nums, int target)
        {
            for (int i = 0; i < nums.length; ++i)
            {
                if (nums[i] == target) return true;
            }
            return false;
        }
    }
}
