package leetcode.leetcode.editor.cn;
//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
找到所有数组中消失的数字
*/
public class P448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

            // 把所有的数字当成key放入hashTable
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], true);
            }

            // Response array that would contain the missing numbers
            List<Integer> result = new ArrayList<>();

            //遍历，如果key中不含有该数字，则没有出现
            for (int i = 1; i <= nums.length; i++) {
                if (!map.containsKey(i)) {
                    result.add(i);
                }
            }

            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            result.add(i);
        }
        Arrays.stream(nums).forEach(x -> result.remove((Integer) x));
        return result;
    }
}