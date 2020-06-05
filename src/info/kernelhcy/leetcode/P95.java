package info.kernelhcy.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P95
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().generateTrees(3));
    }

    public static class Solution
    {
        public List<TreeNode> generateTrees(int n)
        {
            if (n <= 0) return new LinkedList<>();
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> result = new LinkedList<>();
            if (start > end) {
                result.add(null);
                return result;
            }

            for (int i = start; i <= end; ++i) {
                List<TreeNode> rtrees = generateTrees(start, i - 1);
                List<TreeNode> ltrees = generateTrees(i + 1, end);
                for (TreeNode rt : rtrees) {
                    for (TreeNode lt : ltrees) {
                        TreeNode t = new TreeNode(i, rt, lt);
                        result.add(t);
                    }
                }
            }

            return result;
        }

        public List<Integer> inorderTraversal(TreeNode root)
        {
            if (root == null) return Collections.emptyList();

            List<Integer> re = new LinkedList<>(inorderTraversal(root.left));
            re.add(root.val);
            re.addAll(inorderTraversal(root.right));
            return re;
        }
    }
}
