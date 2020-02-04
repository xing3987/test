package leetcode.leetcode.editor.cn;
//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学

/*
计数质数
*/
public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //数量大的时候会超时
        public int countPrimes(int n) {
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        //判断一个数是否是质数
        private boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            if (n > 2) {
                for (int i = 2; i <= (int) Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //其它优化的方法，标记法
    private static int countPrimes(int n) {
        // 1. 给0 - n之间的数加上标记
        byte[] nums = new byte[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }

        // 2. 对于非质数，进行标记清除
        for (int i = 2; i < n; i++) {
            // 如果当前数为质数
            if (nums[i] == 1) {
                // 将当前数作为基数，筛掉其倍数的数字
                for (int j = 2; i * j < n; j++) {
                    // 标记清除
                    nums[i * j] = 0;
                }
            }
        }

        //3. 遍历数组，统计质数(元素值==1)
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
        return count;
    }
}