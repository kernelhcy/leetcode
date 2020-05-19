package info.kernelhcy.leetcode;

public class P55
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public boolean canJump(int[] nums)
        {
            if (nums.length <= 1) return true;

            int index = 0;
            while (true) {
                if (index + nums[index] >= nums.length - 1) return true;
                int ma = -1, mi = -1;
                for (int i = 1; i <= nums[index]; ++i) {
                    if (index + i >= nums.length - 1) {
                        return true;
                    }
                    if (ma < (index + i + nums[index + i])) {
                        ma = (index + i + nums[index + i]);
                        mi = index + i;
                    }
                }
                if (ma >= nums.length - 1) {
                    return true;
                }
                if (index == mi || mi < 0) break;
                index = mi;
                if (index >= nums.length) break;
            }
            return false;
        }
    }
}
