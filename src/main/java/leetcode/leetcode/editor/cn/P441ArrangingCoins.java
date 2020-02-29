package leetcode.leetcode.editor.cn;
//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找

/*
排列硬币
ax^2+bx+c = 0
二次函数求根公式：x = [-b±√(b2-4ac)]/(2a)
*/
public class P441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new P441ArrangingCoins().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            /*int left = 0, right = n;
            int mid;
            while (left < right) {
                mid = (left + right + 1) / 2;
                int count = getSum(mid);
                if (count > n) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;*/
            return (int)(Math.sqrt(2.0 * n + 0.25) - 0.5);
        }

        /**
         * n!=n*(n+1)/2
         *
         * @param n
         * @return
         */
        private int getSum(int n) {
            return n * (n + 1) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}