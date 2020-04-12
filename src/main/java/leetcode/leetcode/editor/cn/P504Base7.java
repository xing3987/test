package leetcode.leetcode.editor.cn;
//给定一个整数，将其转化为7进制，并以字符串形式输出。 
//
// 示例 1: 
//
// 
//输入: 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: -7
//输出: "-10"
// 
//
// 注意: 输入范围是 [-1e7, 1e7] 。 
//

/*
七进制数
*/
public class P504Base7 {
    public static void main(String[] args) {
        Solution solution = new P504Base7().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean flag = true;
            if (num < 0) {
                flag = false;
                num = Math.abs(num);
            }
            StringBuffer sb = new StringBuffer();
            while (num > 0) {
                int x = num % 7;
                sb.insert(0, x);
                num /= 7;
            }
            if (!flag) {
                sb.insert(0, "-");
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}