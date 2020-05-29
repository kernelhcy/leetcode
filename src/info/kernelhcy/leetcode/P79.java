package info.kernelhcy.leetcode;

import java.util.Arrays;

public class P79
{
    public static void main(String[] args)
    {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        System.out.println(new Solution().exist(board, "ABCCED"));
        System.out.println(new Solution().exist(board, "SEE"));
        System.out.println(new Solution().exist(board, "ABCB"));
    }

    public static class Solution
    {
        public boolean exist(char[][] board, String word)
        {
            if (board.length <= 0 || board[0].length <= 0) return false;
            if (word.length() <= 0) return true;

            boolean[][] map = new boolean[board.length][board[0].length];
            for (boolean[] m : map) Arrays.fill(m, false);

            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (board[i][j] == word.charAt(0)) {
                        map[i][j] = true;
                        if (exist(board, i, j, map, word, 1)) {
                            return true;
                        }
                        map[i][j] = false;
                    }
                }
            }
            return false;
        }

        private boolean exist(char[][] board, int x, int y, boolean[][] map, String word, int idx)
        {
            if (idx >= word.length()) return true;
            int m = board.length;
            int n = board[0].length;

            int i, j;
            i = x - 1;
            j = y;
            if (i >= 0 && !map[i][j] && board[i][j] == word.charAt(idx)) {
                map[i][j] = true;
                if (exist(board, i, j, map, word, idx + 1)) {
                    return true;
                }
                map[i][j] = false;
            }

            i = x + 1;
            j = y;
            if (i < m && !map[i][j] && board[i][j] == word.charAt(idx)) {
                map[i][j] = true;
                if (exist(board, i, j, map, word, idx + 1)) {
                    return true;
                }
                map[i][j] = false;
            }

            i = x;
            j = y - 1;
            if (j >= 0 && !map[i][j] && board[i][j] == word.charAt(idx)) {
                map[i][j] = true;
                if (exist(board, i, j, map, word, idx + 1)) {
                    return true;
                }
                map[i][j] = false;
            }

            i = x;
            j = y + 1;
            if (j < n && !map[i][j] && board[i][j] == word.charAt(idx)) {
                map[i][j] = true;
                if (exist(board, i, j, map, word, idx + 1)) {
                    return true;
                }
                map[i][j] = false;
            }
            return false;
        }
    }
}
