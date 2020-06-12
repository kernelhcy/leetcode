package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    public static class SolutionP103
    {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root)
        {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) return result;

            Stack<TreeNode> ns = new Stack<>();
            ns.add(root);

            levelOrder(ns, result, 1);
            return result;
        }

        private void levelOrder(Stack<TreeNode> nodes, List<List<Integer>> result, int direction)
        {
            if (nodes.isEmpty()) return;

            Stack<TreeNode> ns = new Stack<>();
            List<Integer> nums = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                if (node == null) continue;

                nums.add(node.val);
                if ((direction & 1) == 1) {
                    ns.push(node.left);
                    ns.push(node.right);
                } else {
                    ns.push(node.right);
                    ns.push(node.left);
                }
            }

            if (nums.size() > 0) result.add(nums);
            levelOrder(ns, result, direction + 1);
        }
    }
}
