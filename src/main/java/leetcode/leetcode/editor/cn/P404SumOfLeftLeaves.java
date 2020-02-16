package leetcode.leetcode.editor.cn;
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树

/*
左叶子之和
*/
public class P404SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new P404SumOfLeftLeaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int count = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            sum(root);
            return count;
        }

        /**
         * 求树中的左树和
         *
         * @param root
         */
        private void sum(TreeNode root) {
            if (root == null) {
                return;
            }
            //左树不为null，并且是叶子
            if (root.left != null && isLeaves(root.left)) {
                count += root.left.val;
            }
            //左树不为null，并且不是叶子
            if (root.left != null && !isLeaves(root.left)) {
                sum(root.left);
            }
            //右树不为null，并且不是叶子
            if (root.right != null && !isLeaves(root.right)) {
                sum(root.right);
            }
        }

        /**
         * 判断是叶子节点
         *
         * @param root
         * @return
         */
        private Boolean isLeaves(TreeNode root) {
            if (root.left == null && root.right == null) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}