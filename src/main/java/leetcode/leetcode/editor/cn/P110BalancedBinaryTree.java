package leetcode.leetcode.editor.cn;
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
// Related Topics 树 深度优先搜索

/*
平衡二叉树
思路：P104求二叉树深度，获取左右节点的深度互减一下就行了
*/
public class P110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBalanced(TreeNode root) {
            //如果节点本身为空，或者子节点都为空，则返回平衡
            if (null == root || (null == root.left && null == root.right)) {
                return true;
            }
            //如果左右节点的高度差小于1，继续判断子节点是否为平衡二叉树
            if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
                return isBalanced(root.right) && isBalanced(root.left);
            }
            return false;
        }

        //private boolean isBalanced

        //传入当前深度，加上左右节点的最深深度即为结果
        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}