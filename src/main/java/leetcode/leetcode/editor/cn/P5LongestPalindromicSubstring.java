package leetcode.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

/*
最长回文子串
暴力法：列出所有字符串判断是否是回文串
*/
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("bb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            String str = "";
            int max = 0;
            int length = s.length();
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j <= length; j++) {
                    String palindrome = s.substring(i, j);
                    if (palindrome.length() > max && isPalindrome(palindrome)) {
                        str = palindrome;
                        max = palindrome.length();
                    }
                }
            }
            return str;
        }

        private Boolean isPalindrome(String str) {
            Boolean flag = true;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                    return false;
                }
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}