package info.kernelhcy.leetcode;

import java.util.*;

public class P51
{
    public static void main(String[] args)
    {
        List<List<String>>re = new Solution().solveNQueens(4);
        for (List<String> r : re) {
            for (String s : r) {
                System.out.println(s);
            }
        }
    }

    public static class Solution
    {
        public List<List<String>> solveNQueens(int n)
        {
            if (n <= 0) return new LinkedList<>();

            boolean[][] board = new boolean[n][n];
            for (boolean[] bb : board) {
                Arrays.fill(bb, true);
            }

            Stack<Position> positions = new Stack<>();
            List<List<Position>> res = new LinkedList<>();
            solveNQueens(res, board, 0, n, positions);
            return convert(res, n);
        }

        private List<List<String>> convert(List<List<Position>> res, int n)
        {
            List<List<String>> rr = new LinkedList<>();
            for (List<Position> ps : res) {
                char[][] board = new char[n][n];
                for (char[] bb : board) {
                    Arrays.fill(bb, '.');
                }
                for (Position p : ps) {
                    board[p.i][p.j] = 'Q';
                }
                System.out.println('[');
                List<String> r = new LinkedList<>();
                for (int i = 0; i < n; ++i) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; ++j) {
                        System.out.print(board[i][j]);
                        sb.append(board[i][j]);
                    }
                    System.out.println(",");
                    r.add(sb.toString());
                }
                rr.add(r);
                System.out.println(']');
            }
            return rr;
        }

        private void solveNQueens(List<List<Position>> res, boolean[][] board, int pos, int n,
                                  Stack<Position> positions)
        {
            if (positions.size() >= n) {
                res.add(new ArrayList<>(positions));
                return;
            }

            int nextPos = pos;
            while (nextPos < n * n) {
                int i = nextPos / n;
                int j = nextPos % n;
                if (board[i][j]) {
                    positions.push(new Position(i, j));
                    solveNQueens(res, updateBoard(board, i, j), nextPos + 1, n, positions);
                    positions.pop();
                }
                ++nextPos;
            }
        }

        private boolean[][] updateBoard(boolean[][] board, int x, int y)
        {
            boolean[][] b= new boolean[board.length][board.length];
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board.length; ++j) {
                    b[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < board.length; ++i) {
                if (x + i < board.length && y + i < board.length) {
                    b[x + i][y + i] = false;
                }

                if (x + i < board.length && y - i >= 0) {
                    b[x + i][y - i] = false;
                }

                if (x - i >= 0 && y + i < board.length) {
                    b[x - i][y + i] = false;
                }

                if (x + i < board.length) b[x + i][y] = false;
                if (y + i < board.length) b[x][y + i] = false;

                if (x - i >= 0 && y - i >= 0) {
                    b[x - i][y - i] = false;
                }

                if (x - i >= 0) b[x - i][y] = false;
                if (y - i >= 0) b[x][y - i] = false;
            }
            return b;
        }

        private static class Position
        {
            public Position(int i, int j)
            {
                this.i = i;
                this.j = j;
            }

            int i, j;
        }
    }
}
