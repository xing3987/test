package test;

/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 */
public class PatternString {
    public static boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            //判断字符第一次出现的位置和数组中的string第一次出现的下标是否相等
            if (pattern.indexOf(pattern.charAt(i)) != getIndex(words, words[i])) {
                return false;
            }
        }
        return true;
    }

    private static int getIndex(String[] words, String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern="abc";
        String str="b c a";
        boolean b = wordPattern(pattern, str);
        System.out.println(b);
    }
}
