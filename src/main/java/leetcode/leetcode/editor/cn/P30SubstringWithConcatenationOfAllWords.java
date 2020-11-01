package leetcode.leetcode.editor.cn;
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串

import java.util.*;

/*
串联所有单词的子串
*/
public class P30SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new P30SubstringWithConcatenationOfAllWords().new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        solution.findSubstring(s, words);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int oneLen = words[0].length();
            int allLen = oneLen * words.length;
            Arrays.stream(words).forEach(item
                    -> map.put(item, map.getOrDefault(item, 0) + 1));
            // 获取结果数组
            return getResultList(s, oneLen, allLen, map);
        }

        private List<Integer> getResultList(String s, int oneLen, int allLen, HashMap<String, Integer> map) {
            List<Integer> list = new ArrayList<>();
            // 遍历字符串，把符合的位置保存到数组中
            for (int i = 0; i <= s.length() - allLen; i++) {
                String subWord = s.substring(i, i + allLen);
                if (Concatenation(oneLen, subWord, map)) {
                    list.add(i);
                }
            }
            return list;
        }

        private boolean Concatenation(int oneLen, String subWord, HashMap<String, Integer> map) {
            HashMap<String, Integer> mapClone = (HashMap) map.clone();
            String word = subWord;
            while (word.length() > 0) {
                String one = word.substring(0, oneLen);
                int count = mapClone.getOrDefault(one, 0);
                if (count > 0) {
                    mapClone.put(one, count - 1);
                } else {
                    return false;
                }
                word = word.substring(oneLen);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}