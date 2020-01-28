package leetcode.leetcode.editor.cn;
//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串

/*
二进制求和

r进制转10进制	方法
radix进制的字符串s转10进制	Integer.parseInt((String) s,(int) radix);

10进制转化其他进制	对应的方法,参数:n(原10进制数据),r(进制),	返回值
10进制转2进制	Integer.toBinaryString(n);	一个二进制字符串.
10进制转8进制	Integer.toOctalString(n);	一个八进制字符串
10进制转16进制	Integer.toHexString(n);	一个16进制字符串
10进制转 r(16) 进制	Integer.toString(100, 16);	一个r进制字符串
*/
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        String a = "1010";
        String b = "1011";
        System.out.println(solution.addBinary(a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            //转换a,b为相同长度，不足前面补0
            if (a.length() < b.length()) {
                a = appendZeroToSameLength(b.length() - a.length(), a);
            } else if (a.length() > b.length()) {
                b = appendZeroToSameLength(a.length() - b.length(), b);
            }
            StringBuffer sf = new StringBuffer();
            //设置进位符
            int flag = 0;
            for (int i = a.length() - 1; i >= 0; i--) {
                //从后往前计算，char数值计算要减去'0'
                int x = a.charAt(i) - '0' + (b.charAt(i) - '0') + flag;
                if (x / 2 > 0) {
                    sf.insert(0, x % 2);
                    flag = 1;
                } else {
                    sf.insert(0, x);
                    flag = 0;
                }
            }
            if (flag == 1) {
                sf.insert(0, 1);
            }
            return sf.toString();
        }

        //长度不足前面补0
        private String appendZeroToSameLength(int j, String str) {
            StringBuffer sf = new StringBuffer();
            for (int i = 0; i < j; i++) {
                sf.append(0);
            }
            sf.append(str);
            return sf.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 平时在不超int范围时使用
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(a1 + b1);
    }
}