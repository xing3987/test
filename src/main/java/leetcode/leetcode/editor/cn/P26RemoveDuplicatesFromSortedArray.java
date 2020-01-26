package leetcode.leetcode.editor.cn;
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// ****不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。****
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针

/*
删除排序数组中的重复项
思路：双指针法，选出重复的数字和最后一个数字交换，数组的取长减去1
*/
public class P26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        /*int[] x = {1, 1, 2, 3, 2, 3, 3, 3, 4, 4, 1, 2, 3};
        int len = solution.removeDuplicates(x);*/

        int[] x = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4};
        int len = removeDuplicates(x);
        for (int i = 0; i < len; i++) {
            System.out.print(x[i]);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //可以解决所有包含没有排序的数组
        public int removeDuplicates(int[] nums) {
            int length = nums.length;
            int i = 1;
            while (i <= length - 1) {
                Boolean dupl = false;
                for (int j = 0; j < i; j++) {
                    //如果有重复的数字，后面所有数字覆盖前一位，返回长度减去1（舍去最后一位）
                    if (nums[i] == nums[j]) {
                        length--;
                        int m = i;
                        while (m < length) {
                            nums[m] = nums[m + 1];
                            m++;
                        }
                        dupl = true;
                        break;
                    }
                }
                if (!dupl) {
                    //如果没有重复的，继续看下一个数字
                    i++;
                }
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 更好的方法，由于是排好序的数组，所以只要和前面一位比就行了。
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //如果和前面一位不相等，就确定该数在数组的位置
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        //由于i是数组的下标，返回数组的长度要加一
        return i + 1;
    }

}