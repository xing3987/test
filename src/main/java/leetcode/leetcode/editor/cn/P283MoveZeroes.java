package leetcode.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

/*
移动零
思路：1.方法1：循环交换0和后面非0的数，如果没有交换成功则结束循环
      2.如果是整数换位可以使用方法2：直接%10取余，如果为0则记录需要补的次数
*/
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    boolean flag = true;//设置操作标记
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] != 0) {
                            nums[i] = nums[j];
                            nums[j] = 0;
                            flag = false;//记录交换的操作
                            break;
                        }
                    }
                    //如果没有交换，结束循环
                    if (flag) {
                        break;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}