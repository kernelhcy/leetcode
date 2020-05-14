package info.kernelhcy.leetcode;

import java.util.Arrays;

public class P36
{
    public static void main(String[] args)
    {
        char[][] board = new char[9][];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        new Solution().solveSudoku(board);
        System.out.println();
    }

    public static class Solution
    {
        public void solveSudoku(char[][] board)
        {
            for (int i = 0; i < 81; ++i) {
                if (board[i / 9][i % 9] != '.') continue;
                boolean[] ps = possibles(board, i / 9, i % 9);
                for (int k = 0; k < 9; ++k) {
                    if (ps[k]) {
                        board[i / 9][i % 9] = (char) ('1' + k);
                        if (trySolveSudoku(board, i + 1)) {
                            return;
                        }
                    }
                }
                return;
            }
        }

        private boolean[] possibles(char[][] board, int x, int y)
        {
            boolean[] ps = new boolean[9];
            Arrays.fill(ps, true);
            for (int i = 0; i < 9; ++i) {
                if (board[x][i] != '.') {
                    ps[board[x][i] - '1'] = false;
                }
                if (board[i][y] != '.') {
                    ps[board[i][y] - '1'] = false;
                }
            }

            int p1 = x / 3 * 3;
            int p2 = y / 3 * 3;
            for (int k = 0; k < 3; ++k) {
                for (int l = 0; l < 3; ++l) {
                    if (board[k + p1][l + p2] != '.') {
                        ps[board[k + p1][l + p2] - '1'] = false;
                    }
                }
            }

            return ps;
        }

        private boolean trySolveSudoku(char[][] board, int start)
        {
            if ( start >= 81 ) {
                return true;
            }

            for (int i = start; i < 81; ++i) {
                if (board[i / 9][i % 9] != '.') {
                    if (i >= 80) {
                        return true;
                    }
                    continue;
                }
                boolean[] ps = possibles(board, i / 9, i % 9);
                for (int k = 0; k < 9; ++k) {
                    if (ps[k]) {
                        board[i / 9][i % 9] = (char) ('1' + k);
                        if (trySolveSudoku(board, i + 1)) {
                            return true;
                        }
                    }
                }
                board[i / 9][i % 9] = '.';
                return false;
            }
            return false;
        }

        public boolean isValidSudoku(char[][] board)
        {
            boolean[] map = new boolean[9];
            for (int i = 0; i < 9; ++i) {
                Arrays.fill(map, false);
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') continue;
                    int v = board[i][j] - '1';
                    if (map[v]) {
                        return false;
                    }
                    map[v] = true;
                }

                Arrays.fill(map, false);
                for (int j = 0; j < 9; ++j) {
                    if (board[j][i] == '.') continue;
                    int v = board[j][i] - '1';
                    if (map[v]) {
                        return false;
                    }
                    map[v] = true;
                }
            }

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    int p1 = i * 3;
                    int p2 = j * 3;
                    Arrays.fill(map, false);
                    for (int k = 0; k < 3; ++k) {
                        for (int l = 0; l < 3; ++l) {
                            if (board[k + p1][l + p2] == '.') continue;
                            int v = board[k + p1][l + p2] - '1';
                            if (map[v]) {
                                return false;
                            }
                            map[v] = true;
                        }
                    }
                }
            }
            return true;
        }
    }
}
