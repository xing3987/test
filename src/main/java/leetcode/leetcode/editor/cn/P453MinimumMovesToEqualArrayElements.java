package leetcode.leetcode.editor.cn;
//给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。 
//
// 示例: 
//
// 
//输入:
//[1,2,3]
//
//输出:
//3
//
//解释:
//只需要3次移动（注意每次移动会增加两个元素的值）：
//
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
// Related Topics 数学

import java.util.Arrays;

/*
最小移动次数使数组元素相等
思路：可理解位每次让一个值减去1，使得所有的值相等，那理想情况就是每个值最终等于最小值。
*/
public class P453MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new P453MinimumMovesToEqualArrayElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            for (int i = nums.length - 1; i > 0; i--) {
                count += nums[i] - nums[0];
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}