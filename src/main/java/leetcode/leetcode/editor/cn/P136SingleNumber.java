package leetcode.leetcode.editor.cn;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
只出现一次的数字
*/
public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        solution.singleNumber(new int[]{2, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            for (int j = 0; j < nums.length; j++) {
                Boolean flag = true;
                for (int i = 0; i < nums.length; i++) {
                    if (i == j) {
                        continue;
                    }
                    if (nums[j] == nums[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return nums[j];
                }
            }
            return -1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 方法：使用list的contains方法判段是否重复，
     * 但是要注意删除的时候要转成包装类不然remove会默认删除下标
     *
     * @param nums
     * @return
     */
    private int single(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int x : nums) {
            if (list.contains(x)) {
                list.remove((Integer) x);//转成包装类不然remove会默认删除下标
            } else {
                list.add(x);
            }
        }
        if (list.size() > 0) {
            return list.get(0);
        }
        return -1; // can't find it.
    }

    //使用map，把数组的值作为Key，统计出现次数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }
}