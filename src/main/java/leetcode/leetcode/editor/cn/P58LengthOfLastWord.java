package leetcode.leetcode.editor.cn;
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。 
//
// 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 输入：" a"->1
// 输入："a "->1
// 
// Related Topics 字符串

/*
最后一个单词的长度
*/
public class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            int i = s.lastIndexOf(" ");
            if (i == -1) {
                return s.length();
            }
            return s.substring(i + 1).length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}