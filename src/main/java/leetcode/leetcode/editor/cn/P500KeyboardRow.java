package leetcode.leetcode.editor.cn;
//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
//
//
//
//
// 注意：
//
//
// 你可以重复使用键盘上同一字符。
// 你可以假设输入的字符串将只包含字母。
// Related Topics 哈希表

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
键盘行
*/
public class P500KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new P500KeyboardRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Character[] line1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        Character[] line2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        Character[] line3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        List<Character> list1 = Arrays.asList(line1);
        List<Character> list2 = Arrays.asList(line2);
        List<Character> list3 = Arrays.asList(line3);

        public String[] findWords(String[] words) {
            List<String> list = new ArrayList();
            for (int i = 0; i < words.length; i++) {
                if (isInOneLine(words[i])) {
                    list.add(words[i]);
                }
            }
            return list.toArray(new String[list.size()]);
        }

        private Boolean isInOneLine(String str) {
            str = str.toLowerCase();
            boolean flag1 = true, flag2 = true, flag3 = true;
            for (int i = 0; i < str.length(); i++) {
                if (flag1 && !list1.contains(str.charAt(i))) {
                    flag1 = false;
                }
                if (flag2 && !list2.contains(str.charAt(i))) {
                    flag2 = false;
                }
                if (flag3 && !list3.contains(str.charAt(i))) {
                    flag3 = false;
                }
            }
            return flag1 || flag2 || flag3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}