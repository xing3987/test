package leetcode.leetcode.editor.cn;
//对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。 
//
// 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False 
//
// 
//
// 示例： 
//
// 输入: 28
//输出: True
//解释: 28 = 1 + 2 + 4 + 7 + 14
// 
//
// 
//
// 提示： 
//
// 输入的数字 n 不会超过 100,000,000. (1e8) 
// Related Topics 数学

import java.util.ArrayList;
import java.util.List;

/*
完美数
*/
public class P507PerfectNumber {
    public static void main(String[] args) {
        Solution solution = new P507PerfectNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num == 1) {
                return false;
            }
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    list.add(i);
                    list.add(num / i);
                }
            }
            int count = 0;
            for (int x : list) {
                count += x;
            }
            if (count == num) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}