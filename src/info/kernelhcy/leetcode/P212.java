package info.kernelhcy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P212
{
    public static void main(String args[])
    {
        System.out.println(new Solution().findWords(new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        }, new String[]{
                "eat","oath","pea","rain"
        }));
    }

    public static class Solution
    {
        public List<String> findWords(char[][] board, String[] words)
        {
            List<String> re = new LinkedList<>();

            for (String w : words) {
                boolean[][] map = new boolean[board.length][board[0].length];
                boolean found = false;
                for (int j = 0; j < board.length && !found; ++j) {
                    for (int k = 0; k < board[j].length; ++k) {
                        if (board[j][k] == w.charAt(0)) {
                            for (boolean[] m : map) Arrays.fill(m, false);
                            map[j][k] = true;
                            if (findWord(board, map, w, 1, j, k)) {
                                re.add(w);
                                found = true;
                                break;
                            }
                        }
                    }
                }

            }

            return re;
        }

        private boolean findWord(char[][] board, boolean[][] map, String word, int widx, int x, int y)
        {
            if (widx >= word.length()) return true;
            char c = word.charAt(widx);

            if (x - 1 >= 0 && !map[x - 1][y] && board[x - 1][y] == c) {
                map[x - 1][y] = true;
                if (findWord(board, map, word, widx + 1, x - 1, y)) return true;
                map[x - 1][y] = false;
            }

            if (x + 1 < map.length && !map[x + 1][y] && board[x + 1][y] == c) {
                map[x + 1][y] = true;
                if (findWord(board, map, word, widx + 1, x + 1, y)) return true;
                map[x + 1][y] = false;
            }

            if (y - 1 >= 0 && !map[x][y - 1] && board[x][y - 1] == c) {
                map[x][y - 1] = true;
                if (findWord(board, map, word, widx + 1, x, y - 1)) return true;
                map[x][y - 1] = false;
            }

            if (y + 1 < board[x].length && !map[x][y + 1] && board[x][y + 1] == c) {
                map[x][y + 1] = true;
                if (findWord(board, map, word, widx + 1, x, y + 1)) return true;
                map[x][y + 1] = false;
            }

            return false;
        }
    }
}
