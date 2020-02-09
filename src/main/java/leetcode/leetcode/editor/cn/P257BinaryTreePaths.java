package leetcode.leetcode.editor.cn;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索

import java.util.ArrayList;
import java.util.List;

/*
二叉树的所有路径
思路：使用递归记录当前路径，如果没有下一个节点就添加当前路径到list中，创建共同的方法
*/
public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            getAllPaths(root, "", list);
            return list;
        }

        /**
         * 创建方法，用于添加所有的路径
         *
         * @param root
         * @param current
         * @param list
         * @return
         */
        private List<String> getAllPaths(TreeNode root, String current, List<String> list) {
            if (root == null) {
                return list;
            }
            if (root.right == null && root.left == null) {
                list.add(current + root.val);
            }
            getAllPaths(root.left, current + root.val + "->", list);
            getAllPaths(root.right, current + root.val + "->", list);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}