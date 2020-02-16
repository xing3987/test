package leetcode.leetcode.editor.cn;
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
最长回文串
*/
public class P409LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            int length = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null) {
                    map.put(s.charAt(i), 1);
                } else {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            //判断标记记录正中间那个数是否存在
            Boolean mark = false;
            for (Map.Entry<Character, Integer> entry : entries) {
                if (!mark) {
                    if (entry.getValue() % 2 != 0) {
                        mark = true;
                    }
                }
                //如果是一对相同的数，则可以组成回文数
                if (entry.getValue() / 2 > 0) {
                    //去除余数
                    length += (entry.getValue() / 2) * 2;
                }
            }
            if (mark) {
                length++;
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}