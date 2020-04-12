package leetcode.leetcode.editor.cn;
//给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
// "Silver Medal", "Bronze Medal"）。 
//
// (注：分数越高的选手，排名越靠前。) 
//
// 示例 1: 
//
// 
//输入: [5, 4, 3, 2, 1]
//输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and 
//"Bronze Medal").
//余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。 
//
// 提示: 
//
// 
// N 是一个正整数并且不会超过 10000。 
// 所有运动员的成绩都不相同。 
// 
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
相对名次
*/
public class P506RelativeRanks {
    public static void main(String[] args) {
        Solution solution = new P506RelativeRanks().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks(int[] nums) {
            int[] copys = Arrays.copyOf(nums, nums.length);
            List<String> list = new ArrayList<>();
            // 从小到大排序
            Arrays.sort(copys);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < copys.length; j++) {
                    if (nums[i] == copys[j]) {
                        // 排名是从大到小，所以要反转下名次
                        int mark = copys.length - 1 - j;
                        switch (mark) {
                            case 0:
                                list.add("Gold Medal");
                                break;
                            case 1:
                                list.add("Silver Medal");
                                break;
                            case 2:
                                list.add("Bronze Medal");
                                break;
                            default:
                                list.add(mark + 1 + "");
                        }
                    }
                }
            }
            return list.toArray(new String[list.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}