package info.kernelhcy.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P106
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }

    public static class Solution
    {
        public TreeNode buildTree(int[] inorder, int[] postorder)
        {
            if (postorder.length <= 0) return null;
            if (postorder.length == 1) return new TreeNode(postorder[0]);

            Queue<Integer> queue = new LinkedList<>();
            for (int i = postorder.length - 1; i >= 0; --i) queue.add(postorder[i]);

            Map<Integer, Integer> inorderIdxs = new HashMap<>();
            for (int i = 0; i < inorder.length; ++i) inorderIdxs.put(inorder[i], i);

            return buildTree(queue, inorder, 0, inorder.length - 1, inorderIdxs);
        }

        public TreeNode buildTree(Queue<Integer> postorder, int[] inorder, int start, int end, Map<Integer, Integer> inorderIdxs)
        {
            if (start > end || postorder.isEmpty()) return null;
            if (start == end) {
                postorder.poll();
                return new TreeNode(inorder[start]);
            }

            TreeNode root = new TreeNode(postorder.poll());

            int rootIdx = inorderIdxs.get(root.val);
            root.right = buildTree(postorder, inorder, rootIdx + 1, end, inorderIdxs);
            root.left = buildTree(postorder, inorder, start, rootIdx - 1, inorderIdxs);

            return root;
        }
    }
}
