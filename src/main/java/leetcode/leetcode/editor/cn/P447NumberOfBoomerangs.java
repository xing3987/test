package leetcode.leetcode.editor.cn;
//给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺
//序）。 
//
// 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。 
//
// 示例: 
//
// 
//输入:
//[[0,0],[1,0],[2,0]]
//
//输出:
//2
//
//解释:
//两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
// Related Topics 哈希表

import java.util.HashMap;

/*
回旋镖的数量
以每个点作为顶点，计算所有的可能
*/
public class P447NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new P447NumberOfBoomerangs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                hashMap.clear();
                for (int j = 0; j < points.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    //如果hashMap.getOrDefault有值则获取，没有则获取默认值
                    count += hashMap.getOrDefault(distance, 0) * 2;
                    hashMap.put(distance, hashMap.getOrDefault(distance, 0) + 1);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}