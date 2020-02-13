package leetcode.leetcode.editor.cn;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串

/*
字符串中的第一个唯一字符
*/
public class P387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new P387FirstUniqueCharacterInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            for (int i = 0; i < s.length(); i++) {
                Boolean flag = true;
                for (int j = 0; j < s.length(); j++) {
                    if (i != j && s.charAt(i) == s.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}