package leetcode.leetcode.editor.cn;
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学

/*
2的幂
*/
public class P231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) {
                return false;
            }
            while (n % 2 == 0) {//可以整除2时就一直整除直到不能整除为止
                n /= 2;
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    private static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;//如果x是2的幂：00001000&00000100,他们的运算与就是0；
                                // 如果存在其他1则不为0：00001010&00001001->00001000
    }
}