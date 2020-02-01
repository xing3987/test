package leetcode.leetcode.editor.cn;
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
多数元素
思路：使用map来保存元素和次数，在new两个int来保存当前出现最多的元素和次数
*/
public class P169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int times = 0;
            int aim = nums[0];
            for (int num : nums) {
                int a = 1;
                if (null != map.get(num)) {
                    a += map.get(num);
                }
                if (a > times) {
                    times = a;
                    aim = num;
                }
                map.put(num, a);
            }
            return aim;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //题意：多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    //不需要求出现最多的元素，其他解法：排序，如果有超过一半的数那么最中间那个数就是所要的数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}