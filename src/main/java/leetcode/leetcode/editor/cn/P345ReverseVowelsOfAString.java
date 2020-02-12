package leetcode.leetcode.editor.cn;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串

import java.util.Arrays;
import java.util.List;

/*
反转字符串中的元音字母
*/
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("hello"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            List<Character> words = Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u');
            int i = 0, j = chars.length - 1;
            while (i < j) {
                //从左到右找元音字母
                while (!words.contains(chars[i]) && i < j) {
                    i++;
                }
                //从右到左找元音字母
                while (!words.contains(chars[j]) && i < j) {
                    j--;
                }
                //交换
                char a = chars[i];
                chars[i] = chars[j];
                chars[j] = a;
                //继续找下一个
                i++;
                j--;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}