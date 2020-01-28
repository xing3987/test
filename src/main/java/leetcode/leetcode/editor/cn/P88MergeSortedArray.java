package leetcode.leetcode.editor.cn;
//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
合并两个有序数组
思路：1.本来使用双指针，两个for循环，第二个数组中的数和第一个数组中比较如果小则插入第一个数组
     需要写一个插入数组的公共方法
     2.这里使用取巧的方式直接拼成一个数组，然后再排个序就行了
*/
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //参数说明：需要复制的数组，指针，目标数组，开始位置，复制长度
            System.arraycopy(nums2, 0, nums1, m, n);
            /*for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }*/
            Arrays.sort(nums1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}