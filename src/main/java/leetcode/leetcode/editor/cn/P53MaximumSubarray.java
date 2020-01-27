package leetcode.leetcode.editor.cn;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

/*
最大子序和
*/
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, -1, -1, 5, 1, -5, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int currSum = nums[0];
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //对比新加的数与 之前最大的和与新加的数的和，
                //如果新的数大，舍去之前的和，从新数开始统计和
                //如果后者大，保留新数和之前的和相加
                //记录当前最大值与最终最大值中大的为最终最大值
                currSum = Math.max(nums[i], currSum + nums[i]);
                maxSum = Math.max(currSum, maxSum);
            }
            return maxSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}