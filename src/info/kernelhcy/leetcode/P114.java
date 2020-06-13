package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P114
{
    public static void main(String[] args)
    {

    }

    public static  class Solution
    {
        public void flatten(TreeNode root)
        {
            if (root == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            traverse(root, queue);
            root = queue.poll();
            while (! queue.isEmpty()) {
                root.right = queue.poll();
                root.left = null;
                root = root.right;
            }

            if (root != null) {
                root.left = null;
                root.right = null;
            }
        }

        private void traverse(TreeNode root, Queue<TreeNode> queue)
        {
            if (root == null) return;
            queue.add(root);
            traverse(root.left, queue);
            traverse(root.right, queue);
        }
    }
}
