package leetcode.leetcode.editor.cn;
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串

import java.util.regex.Pattern;

/*
重复的子字符串
思路：可以直接判断s+s中去除首尾元素之后，是否包含自身元素。如果包含。则表明存在重复子串。
*/
public class P459RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new P459RepeatedSubstringPattern().new Solution();
        solution.repeatedSubstringPattern("ababab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            String str = s + s;
            return str.substring(1, str.length() - 1).contains(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}