package leetcode.leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
二叉树的层次遍历
思路:先从上往下遍历：使用一个标记记录当前层数，然后向该层的数组中添加数据
    然后反转数组
*/
public class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (null != root) {
                getAll(root, 0, list);//利用数组的引用往里面插入数据
                Collections.reverse(list);//反转数组
            }
            return list;
        }

        /**
         * 使用迭代获取所有节点的数据
         *
         * @param treeNode 当前节点
         * @param index    第几层
         * @param list     传递的目标数组
         * @return
         */
        private void getAll(TreeNode treeNode,
                            Integer index, List<List<Integer>> list) {
            if (null == treeNode) {
                return;
            }
            if (list.size() <= index) {
                list.add(new ArrayList<Integer>());//初始化每层的列表
            }
            list.get(index).add(treeNode.val);
            getAll(treeNode.left, index + 1, list);
            getAll(treeNode.right, index + 1, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}