package leetcode.leetcode.editor.cn;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

/*
爬楼梯
*/
public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //其实这题就是求斐波那契数组的第n个数
        public int climbStairs(int n) {
            int a = 1, b = 2, c;
            if (n == 1) {
                return a;
            }
            for (int i = 3; i <= n; i++) {
                c = b;
                b = a + b;
                a = c;
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 每次爬的可能性是上一层+1，和上2层+2；使用递归获得答案（但是时间复杂度太高不建议）
     *
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        int a = 1, b = 2;
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}