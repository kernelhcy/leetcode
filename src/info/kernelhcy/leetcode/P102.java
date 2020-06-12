package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102
{
    public static void main(String[] args)
    {

    }

    public static class Solution
    {
        public List<List<Integer>> levelOrder(TreeNode root)
        {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) return result;

            Queue<TreeNode> ns = new LinkedList<>();
            ns.add(root);

            levelOrder(ns, result);
            return result;
        }

        private void levelOrder(Queue<TreeNode> nodes, List<List<Integer>> result)
        {
            if (nodes.isEmpty()) return;

            Queue<TreeNode> ns = new LinkedList<>();
            List<Integer> nums = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                nums.add(node.val);
                if (node.left != null) ns.offer(node.left);
                if (node.right!= null) ns.offer(node.right);
            }

            result.add(nums);
            levelOrder(ns, result);
        }
    }
}
