package leetcode.leetcode.editor.cn;
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4] 
//
// 说明: 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
两个数组的交集
*/
public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            List<Integer> inter = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i)) && !inter.contains(list1.get(i))) {
                    inter.add(list1.get(i));
                }
            }
            return inter.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}