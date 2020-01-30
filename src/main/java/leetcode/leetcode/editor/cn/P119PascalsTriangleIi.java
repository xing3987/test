package leetcode.leetcode.editor.cn;
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

/*
杨辉三角 II
*/
public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        solution.getRow(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //rowIndex是索引从0开始
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<>();
            if (rowIndex < 0) {
                return list;
            }
            //初始化第一个值
            list.add(1);
            if (rowIndex == 0) {
                return list;
            }
            //循环添加几次（输入次数减去初始化的一次）
            for (int i = 0; i < rowIndex; i++) {
                //获取lists的最后一个数组
                //输入2，其实当前数组中只有一个数组，其下标为0
                List<Integer> current = new ArrayList<>();//创建数组用于存当前行数据
                //头尾和前一个数组相同
                current.add(list.get(0));
                for (int j = 1; j < list.size(); j++) {
                    current.add(list.get(j - 1) + list.get(j));
                }
                current.add(list.get(list.size() - 1));
                list = current;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //更好的解法，空间复杂读为O(k)
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        //初始化第一个值
        list.add(1);
        //循环添加几次（因为输入的是索引，所以输入几就是循环了几次）
        for (int i = 1; i <= rowIndex; i++) {
            int pre = 1;
            //第一个数是1，所以从第二个数开始更新，循环了到了第2次才需要加数据即：[1,1]后
            for (int j = 1; j < i; j++) {
                int tmp = pre;
                pre = list.get(j);
                list.set(j, tmp + pre);
            }
            list.add(1);//末尾也固定是1
        }
        return list;
    }
}