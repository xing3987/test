package leetcode.leetcode.editor.cn;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组

import java.util.Arrays;
import java.util.Collections;

/*
旋转数组
*/
public class P189RotateArray {
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        solution.rotate(new int[]{1, 2, 3, 4}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            } else if (k >= nums.length) {
                k %= nums.length;
            }
            if (k == 0) {
                return;
            }
            int[] a = new int[k];
            int[] b = new int[nums.length - k];
            //参数说明：需要复制的数组，指针，目标数组，开始位置，复制长度
            System.arraycopy(nums, nums.length - k, a, 0, k);//复制后面一段给a
            System.arraycopy(nums, 0, b, 0, nums.length - k);//复制前面一段给b
            System.arraycopy(a, 0, nums, 0, k);//把a复制给nums
            System.arraycopy(b, 0, nums, k, nums.length - k);//再把b复制给nums
            //这里如果想不用额外的数组也可以把nums扩容，后移再截取的方法
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 只使用一个额外的数组
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        } else if (k >= nums.length) {
            k %= nums.length;
        }
        if (k == 0) {
            return;
        }
        int[] x = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                x[i] = nums[nums.length - k + i];
            } else {
                x[i] = nums[i - k];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = x[i];
        }
    }

    /**
     * 更好的解法，三次反转
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * @param nums
     * @param k
     */
    private static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}