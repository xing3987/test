package leetcode.leetcode.editor.cn;
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

import java.util.Arrays;
import java.util.stream.IntStream;

/*
加一
*/
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits[digits.length - 1] != 9) {
                digits[digits.length - 1] = digits[digits.length - 1] + 1;
                return digits;
            } else {
                Boolean flag = false;
                //判断是否包含9以外的数字
                for (int x : digits) {
                    if (x != 9) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    for (int j = digits.length - 1; j >= 0; j--) {
                        if (digits[j] != 9) {
                            digits[j] = digits[j] + 1;
                            return digits;
                        } else {
                            digits[j] = 0;
                        }
                    }
                    return digits;
                } else {
                    int[] result = Arrays.copyOf(digits, digits.length + 1);
                    result[0] = 1;
                    for (int i = 1; i < result.length; i++) {
                        result[i] = 0;
                    }
                    return result;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 简化求法
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        //从后到前判读是否有不含9的数，如果有加一返回数组
        for (int j = digits.length - 1; j >= 0; j--) {
            if (digits[j] != 9) {
                digits[j] = digits[j] + 1;
                return digits;
            } else {
                digits[j] = 0;
            }
        }
        //如果都是9的数组，数组长度加1，第一个值为1，其余值默认为0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}