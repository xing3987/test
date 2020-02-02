package leetcode.leetcode.editor.cn;
//编写一个算法来判断一个数是不是“快乐数”。 
//
// 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
//如果可以变为 1，那么这个数就是快乐数。 
//
// 示例: 
//
// 输入: 19
//输出: true
//解释: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学

import java.util.ArrayList;
import java.util.List;

/*
快乐数
*/
public class P202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new P202HappyNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            List<Integer> list = new ArrayList<>();//把出现过的是数字保存起来
            while (n != 1) {
                //创建出口，如果计算玩快乐数又回到了重复的数，就会陷入死循环
                if (list.contains(n)) {
                    return false;
                }
                list.add(n);
                int count = 0;
                //计算出平方结果
                while (n > 0) {
                    count += Math.pow(n % 10, 2);
                    n /= 10;
                }
                n = count;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 使用快慢指针判断循环
     */
    private static int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    private static Boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

}