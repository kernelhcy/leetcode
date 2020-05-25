package info.kernelhcy.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P68
{
    public static void main(String[] args)
    {
        List<String> res = new Solution().fullJustify(
                new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                16);
        System.out.println(res.stream().map(s -> "\"" + s + "\"")
                              .collect(Collectors.joining(",\n", "[\n", "\n]\n")));

        res = new Solution().fullJustify(
                new String[]{"What","must","be","acknowledgment","shall","be"},
                16);
        System.out.println(res.stream().map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(",\n", "[\n", "\n]\n")));

        res = new Solution().fullJustify(
                new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                        "to","a","computer.","Art","is","everything","else","we","do"},
                20);
        System.out.println(res.stream().map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(",\n", "[\n", "\n]\n")));

        res = new Solution().fullJustify(
                new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"},
                16);
        System.out.println(res.stream().map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(",\n", "[\n", "\n]\n")));

        res = new Solution().fullJustify(
                new String[]{"Listen","to","many,","speak","to","a","few."},
                6);
        System.out.println(res.stream().map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(",\n", "[\n", "\n]\n")));

    }

    public static class Solution
    {
        public List<String> fullJustify(String[] words, int maxWidth)
        {
            List<String> re = new LinkedList<>();
            fullJustify(words, 0, maxWidth, re);
            return re;
        }

        private void fullJustify(String[] words, int start, int maxWidth, List<String> re)
        {
            if (start >= words.length) return;

            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            int idx = -1;
            for(int i = start; i < words.length; ++i) {
                if (cnt + words[i].length() + 1 <= maxWidth + 1) {
                    cnt += (words[i].length() + 1);
                } else {
                    idx = i - 1;
                    break;
                }
            }

            if (idx <= 0 || idx == start) {
                if (idx < 0) idx = words.length - 1;
                for (int i = start; i < idx; ++i) {
                    sb.append(words[i]).append(' ');
                }
                sb.append(words[idx]);
                while (sb.length() < maxWidth) sb.append(' ');
                re.add(sb.toString());
                fullJustify(words, idx + 1, maxWidth, re);
                return;
            }

            if (cnt == maxWidth + 1) {
                for (int i = start; i < idx; ++i) {
                    sb.append(words[i]).append(' ');
                }
                sb.append(words[idx]);
                re.add(sb.toString());
                fullJustify(words, idx + 1, maxWidth, re);
                return;
            }

            int totalSpace = maxWidth - cnt + (idx - start);
            int baseSpaceNum = totalSpace / (idx - start);
            int extSpaceNum = totalSpace % (idx - start);
            String baseSpaceS = "";
            for (int i = 0; i < baseSpaceNum; ++i) baseSpaceS += ' ';
            for (int i = start; i < idx; ++i) {
                sb.append(words[i]).append(baseSpaceS);
                if (extSpaceNum >= 0) {
                    sb.append(' ');
                    --extSpaceNum;
                }
            }
            sb.append(words[idx]);
            re.add(sb.toString());
            fullJustify(words, idx + 1, maxWidth, re);
        }
    }
}
