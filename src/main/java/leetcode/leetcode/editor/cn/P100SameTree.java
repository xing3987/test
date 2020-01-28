package leetcode.leetcode.editor.cn;
//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索

/*
相同的树
思路：使用递归判断两边的树是否相等即可。
*/
public class P100SameTree {
    public static void main(String[] args) {
        Solution solution = new P100SameTree().new Solution();
    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {//如果都为空
                return true;
            } else if (null == p || null == q) {//如果一个为空
                return false;
            } else if (p.val != q.val) {//如果值不相同
                return false;
            } else {//递归继续比较两侧的节点
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}