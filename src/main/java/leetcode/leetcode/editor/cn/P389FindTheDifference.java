package leetcode.leetcode.editor.cn;
//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表

import java.util.Arrays;

/*
找不同
*/
public class P389FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new P389FindTheDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            Arrays.sort(schars);
            Arrays.sort(tchars);

            for (int i = 0; i < t.length() - 1; i++) {
                if (tchars[i] != schars[i]) {
                    return tchars[i];
                }
            }
            return tchars[tchars.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}