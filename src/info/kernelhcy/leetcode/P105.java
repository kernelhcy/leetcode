package info.kernelhcy.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P105
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    public static class Solution
    {
        public TreeNode buildTree(int[] preorder, int[] inorder)
        {
            if (preorder.length <= 0) return null;
            if (preorder.length == 1) return new TreeNode(preorder[0]);

            Queue<Integer> queue = new LinkedList<>();
            for (int i : preorder) queue.add(i);

            Map<Integer, Integer> inorderIdxs = new HashMap<>();
            for (int i = 0; i < inorder.length; ++i) inorderIdxs.put(inorder[i], i);

            return buildTree(queue, inorder, 0, inorder.length - 1, inorderIdxs);
        }

        public TreeNode buildTree(Queue<Integer> preorder, int[] inorder, int start, int end, Map<Integer, Integer> inorderIdxs)
        {
            if (start > end || preorder.isEmpty()) return null;
            if (start == end) {
                preorder.poll();
                return new TreeNode(inorder[start]);
            }

            TreeNode root = new TreeNode(preorder.poll());

            int rootIdx = inorderIdxs.get(root.val);
            root.left = buildTree(preorder, inorder, start, rootIdx - 1, inorderIdxs);
            root.right = buildTree(preorder, inorder, rootIdx + 1, end, inorderIdxs);

            return root;
        }
    }
}
