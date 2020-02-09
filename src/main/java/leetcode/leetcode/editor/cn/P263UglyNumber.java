package leetcode.leetcode.editor.cn;
//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学

/*
丑数(1也是丑数)
*/
public class P263UglyNumber {
    public static void main(String[] args) {
        Solution solution = new P263UglyNumber().new Solution();
        solution.isUgly(6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int num) {
            while (num > 0) {
                if (num % 3 == 0) {
                    num /= 3;
                    continue;
                } else if (num % 2 == 0) {
                    num /= 2;
                    continue;
                } else if (num % 5 == 0) {
                    num /= 5;
                    continue;
                }
                if (num == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}