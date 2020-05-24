package leetcode.leetcode.editor.cn;
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串

/*
Z 字形变换
*/
public class P6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        String str = "PAYPALISHIRING";
        System.out.println(solution.convert(str, 5));
        //Integer[] array = {1, 2, 3, 4, 5};
        //Arrays.stream(array).forEach(ss -> ss = 222); //流式操作不可用来赋值
        //Arrays.stream(array).forEach(ss -> System.out.println(ss));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1 || numRows > s.length()) {
                return s;
            }
            StringBuffer[] strs = new StringBuffer[numRows];
            for (int i = 0; i < numRows; i++) {
                strs[i] = new StringBuffer();
            }
            int subLen = 2 * numRows - 2;
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                int j = i % subLen;
                if (j < numRows) {
                    strs[j].append(chars[i]);
                } else {
                    int x = subLen - j; // 从下往上插入，不含头尾
                    strs[x].append(chars[i]);
                }
            }
            // 把所有的字符串加起来
            StringBuffer sf = new StringBuffer();
            for (StringBuffer str : strs) {
                sf.append(str);
            }
            return sf.toString();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}