package info.kernelhcy.leetcode;

public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {
    }

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode deepCopy()
    {
        TreeNode root = new TreeNode();
        root.val = val;
        if (left != null) {
            root.left = left.deepCopy();
        }

        if (right != null) {
            root.right = right.deepCopy();
        }
        return root;
    }

    public void insert(int n)
    {
        if (n <= val) {
           if (right == null) {
               right = new TreeNode(n);
           } else {
               right.insert(n);
           }
        } else {
            if (left == null) {
                left = new TreeNode(n);
            } else {
                left.insert(n);
            }
        }
    }

    @Override
    public String toString()
    {
        String s = "" + val + ",";
        if (right != null) s += right.toString();
        if (left != null) s += left.toString();
        return s;
    }
}
