package leetcode.leetcode.editor.cn;
//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构
//成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。) 
//
// 注意： 
//
// 你可以假设两个字符串均只含有小写字母。 
//
// 
//canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true
// 
// Related Topics 字符串

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
赎金信
*/
public class P383RansomNote {
    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> map1 = countString(ransomNote);
            Map<Character, Integer> map2 = countString(magazine);
            Set<Map.Entry<Character, Integer>> entries = map1.entrySet();
            Boolean flag = true;
            for (Map.Entry<Character, Integer> entry : entries) {
                if (map2.get(entry.getKey()) == null
                        || map2.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
            return flag;
        }

        private Map<Character, Integer> countString(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char key = str.charAt(i);
                if (null == map.get(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}