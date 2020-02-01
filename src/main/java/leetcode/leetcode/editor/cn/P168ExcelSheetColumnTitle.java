package leetcode.leetcode.editor.cn;
//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学

/*
Excel表列名称
思路：就是26进制的实现
难点：26进制但是1对应A,26对应Z,没有0
*/
public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        System.out.println(solution.convertToTitle(52));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            StringBuffer sf = new StringBuffer();
            while (n > 0) {
                int x = n % 26;
                if (x == 0) {
                    x = 26;//x进一位
                    n -= 1;//总数退一位
                }
                sf.insert(0, (char) ('A' + x - 1));
                n = n / 26;
            }
            return sf.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}