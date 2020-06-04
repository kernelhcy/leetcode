package info.kernelhcy.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class P85
{
    public static void main(String[] args)
    {
        char[][] m = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new Solution().maximalRectangle(m));

        m = new char[][]{{'1', '1'}};
        System.out.println(new Solution().maximalRectangle(m));

        m = new char[][]{
                {'0', '1'},
                {'1', '0'},
        };
        System.out.println(new Solution().maximalRectangle(m));
    }

    /*

    [
    ["1","1","1","1","1","1","1","1"],
    ["1","1","1","1","1","1","1","0"],
    ["1","1","1","1","1","1","1","0"],
    ["1","1","1","1","1","0","0","0"],
    ["0","1","1","1","1","0","0","0"]
    ]

     */
    public static class Solution
    {
        public int maximalRectangle(char[][] matrix)
        {
            if (matrix.length <= 0) return 0;
            if (matrix[0].length <= 0) return 0;

            int[][] h = new int[matrix.length][matrix[0].length];

            int max = 0;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if (matrix[i][j] == '1') {
                        h[i][j] = (i == 0 ? 1 : h[i - 1][j] + 1);
                    }
                    max = Math.max(max, largestRectangleArea(h[i]));
                }
            }
            return max;
        }


        private int largestRectangleArea(int[] heights)
        {
            if (heights.length <= 0) return 0;
            if (heights.length <= 1) return heights[0];

            int[] h = new int[heights.length + 1];
            Arrays.fill(h, 0);
            System.arraycopy(heights, 0, h, 0, heights.length);

            int max = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < h.length; ++i) {
                if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
                    stack.push(i);
                    continue;
                }

                int idx = stack.pop();
                int area = h[idx] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                max = Math.max(max, area);
                --i;
            }

            return max;
        }

        public int maximalRectangle2(char[][] matrix)
        {
            if (matrix.length <= 0) return 0;
            if (matrix[0].length <= 0) return 0;

            int max = 0;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if (matrix[i][j] == '0') continue;
                    max = Math.max(max, maximalRectangle(matrix, i, j));
                }
            }
            return max;
        }

        private int maximalRectangle(char[][] matrix, int x, int y)
        {
            int max = 0;
            for (int i = 0; i < matrix.length - x; ++i) {
                for (int j = 0; j < matrix[i].length - y; ++j) {
                    boolean all = true;
                    for (int k = x; k <= x + i; ++k) {
                        for (int l = y; l <= y + j; ++l) {
                            if (matrix[k][l] != '1') {
                                all = false;
                                break;
                            }
                        }
                    }
                    if (all) {
                        max = Math.max(max, (i + 1) * (j + 1));
                    }
                }
            }
            return max;
        }
    }
}
