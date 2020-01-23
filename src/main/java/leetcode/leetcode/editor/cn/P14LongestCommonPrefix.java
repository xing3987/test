package leetcode.leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

//最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            } else if (strs.length == 1) {
                return strs[0];
            }
            String init = strs[0];
            for (int i = 0; i < init.length(); i++) {
                char x = init.charAt(i);
                for (String str : strs) {
                    try {
                        if (x != str.charAt(i)) {
                            return init.substring(0, i);
                        }
                    } catch (Exception e) {
                        return init.substring(0, i);
                    }
                }
            }
            return init;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}