package leetcode.leetcode.editor.cn;
//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
// 
// Related Topics 字符串

/*
字符串中的单词数
*/
public class P434NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new P434NumberOfSegmentsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            s = s.trim();
            if (s == null || s.length() == 0) {
                return 0;
            }
            String[] split = s.split("\\s+");

            return split.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}