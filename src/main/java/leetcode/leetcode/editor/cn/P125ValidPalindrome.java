package leetcode.leetcode.editor.cn;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

/*
验证回文串
*/
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        solution.isPalindrome(",M 9y\"yj\"j9 M,");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();//全部转成小写
            //筛选掉字母和数字以外的
            char[] chars = s.toCharArray();
            StringBuffer sf = new StringBuffer();
            for (char x : chars) {
                if (x >= '0' && x <= '9' || x >= 'a' && x <= 'z') {
                    sf.append(x);
                }
            }
            s = sf.toString();
            //循环遍历是否头尾相等
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}