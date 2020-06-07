package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P98
{
    public static class Solution
    {
        public boolean isValidBST(TreeNode root)
        {
            long[] pre = new long[1];
            pre[0] = Long.MIN_VALUE;
            return isValidBST(root, pre);
        }

        private boolean isValidBST(TreeNode root, long[] pre)
        {
            if (root == null) return true;
            boolean re = true;
            if (root.left != null) {
                re = isValidBST(root.left, pre);
            }

            re &= ((long)root.val > pre[0]);
            pre[0] = root.val;

            if (root.right != null) {
                re &= isValidBST(root.right, pre);
            }
            return re;
        }


        public boolean isValidBST2(TreeNode root)
        {
            if (root == null) return true;
            List<Integer> nums = new LinkedList<>();
            traverse(root, nums);
            for (int i = 1; i < nums.size(); ++i) {
                if (nums.get(i - 1).equals(nums.get(i))) return false;
                if (nums.get(i - 1) > nums.get(i)) return false;
            }
            return true;
        }

        private void traverse(TreeNode root, List<Integer> result)
        {
            if (root.left != null) {
                traverse(root.left, result);
            }

            result.add(root.val);

            if (root.right != null) {
                traverse(root.right, result);
            }
        }
    }
}
