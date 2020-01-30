package leetcode.leetcode.editor.cn;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

/*
杨辉三角
思路：规律每下一层数组都比上一层长度+1；
        每个数list.get(i)是它左上方和右上方的数的和list.get(i)+list.get(i-1)。
        排除两边要单独求和
*/
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        solution.generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> lists = new ArrayList<>();
            if (numRows == 0) {
                return lists;
            }
            //初始化第一个值
            List<Integer> start = new ArrayList();
            start.add(1);
            lists.add(start);
            //循环添加几次（输入次数减去初始化了一次）
            for (int i = 0; i < numRows - 1; i++) {
                //获取lists的最后一个数组
                //输入2，其实当前数组中只有一个数组，其下标为0
                List<Integer> before = lists.get(i);
                List<Integer> current = new ArrayList<>();//创建数组用于存当前行数据
                //头尾和前一个数组相同
                current.add(before.get(0));
                for (int j = 1; j < before.size(); j++) {
                    current.add(before.get(j - 1) + before.get(j));
                }
                current.add(before.get(before.size() - 1));
                lists.add(current);
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}