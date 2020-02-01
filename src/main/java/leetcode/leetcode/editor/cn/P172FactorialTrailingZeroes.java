package leetcode.leetcode.editor.cn;
//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学

/*
阶乘后的零
*/
public class P172FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new P172FactorialTrailingZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //进一步分析每隔5个数 出现1个
        // 5->5/5 25个数出现2个5->25/5+5/5
        // 125个数出现3个5->125/5+25/5+5/5....
        //125:因子中有25个5的倍数，5个5*5的倍数，一个5*5*5的倍数
        //所以只要判断有多少个5的倍数的数即可
        public int trailingZeroes(int n) {
            int count = 0;
            while (n > 0) {
                count += n / 5;
                n = n / 5;
            }
            return count;
        }

        /*
        //经过分析得出，乘数中有几个5的因子就有几个0（还是超时）
        public int trailingZeroes(int n) {
            int count = 0;
            while (n > 4) {//4以下没有5的倍数
                int i = n;
                while (i % 5 == 0) {
                    count++;
                    i = i / 5;
                }
                n--;
            }
            return count;
        }

        //数据大时会超时或超出限制
        public int trailingZeroes(int n) {
            long sum = n;//先算出和
            while (n - 1 > 0) {
                sum *= n - 1;
                n--;
            }
            int count = 0;//再算出有几个零
            while (sum % 10 == 0) {
                count++;
                sum = sum / 10;
            }
            return count;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}