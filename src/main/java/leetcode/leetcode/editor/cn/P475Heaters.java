package leetcode.leetcode.editor.cn;
//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。 
//
// 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。 
//
// 说明: 
//
// 
// 给出的房屋和供暖器的数目是非负数且不会超过 25000。 
// 给出的房屋和供暖器的位置均是非负数且不会超过10^9。 
// 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。 
// 所有供暖器都遵循你的半径标准，加热的半径也一样。 
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3],[2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4],[1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
// Related Topics 二分查找

/*
供暖器
思路：先求出每个房子到供暖设备的最小距离
    再统计出所有房子到供暖设备最小距离中的最大值，
    该值就是最小半径
*/
public class P475Heaters {
    public static void main(String[] args) {
        Solution solution = new P475Heaters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int max = 0, min;
            for (int i = 0; i < houses.length; i++) {
                min = Math.abs(heaters[0] - houses[i]);
                for (int j = 1; j < heaters.length; j++) {
                    int length = Math.abs(heaters[j] - houses[i]);
                    min = Math.min(min, length);
                }
                max = Math.max(max, min);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}