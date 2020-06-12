package info.kernelhcy.leetcode;

import java.util.*;

public class P99
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public void recoverTree(TreeNode root)
        {
            if (root == null) return;

            List<Integer> nums = new ArrayList<>();
            traverse(root, nums);
            Collections.sort(nums);
            recover(root, new LinkedList<>(nums));
        }

        private void recover(TreeNode root, Queue<Integer> nums)
        {
            if (root.left != null) {
                recover(root.left, nums);
            }

            root.val = nums.poll();

            if (root.right != null) {
                recover(root.right, nums);
            }
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
