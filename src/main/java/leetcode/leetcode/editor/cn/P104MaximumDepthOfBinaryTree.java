package leetcode.leetcode.editor.cn;
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索

/*
二叉树的最大深度
一般使用递归，注意要有出口
*/
public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return maxDepth(1, root.left, root.right);
        }

        //传入当前深度，加上左右节点的最深深度即为结果
        private int maxDepth(int i, TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return i;
            } else if (left == null) {
                return maxDepth(i + 1, right.left, right.right);
            } else if (right == null) {
                return maxDepth(i + 1, left.left, left.right);
            } else {
                return Math.max(maxDepth(i + 1, left.left, left.right),
                        maxDepth(i + 1, right.left, right.right));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 更简易的方式
     *
     * @param root
     * @return
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}