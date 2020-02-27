package leetcode.leetcode.editor.cn;
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串

/*
字符串相加
思路字符串截取9位9位数相加
*/
public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        System.out.println(Integer.parseInt("000000000000"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            if (num1.length() > num2.length()) {
                num2 = changToFixLong(num2, num1.length());
            } else {
                num1 = changToFixLong(num1, num2.length());
            }
            StringBuffer result = new StringBuffer();
            int flag = 0;
            while (num1.length() > 0) {
                String num1sub = num1.substring(num1.length() - 1);
                String num2sub = num2.substring(num2.length() - 1);
                int sum = Integer.parseInt(num1sub) + Integer.parseInt(num2sub) + flag;
                if (String.valueOf(sum).length() > 1) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                String sumStr = String.valueOf(sum);
                result.insert(0, sumStr.substring(sumStr.length() - 1));
                num1 = num1.substring(0, num1.length() - 1);
                num2 = num2.substring(0, num2.length() - 1);
            }
            if (flag > 0) {
                result.insert(0, "1");
            }
            return result.toString();
        }

        private String changToFixLong(String str, int fix) {
            if (str.length() < fix) {
                int i = fix - str.length();
                StringBuffer sf = new StringBuffer();
                for (int j = 0; j < i; j++) {
                    sf.append("0");
                }
                str = sf.toString() + str;
            }
            return str;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}