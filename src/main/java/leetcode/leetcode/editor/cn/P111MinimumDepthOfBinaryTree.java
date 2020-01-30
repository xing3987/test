package leetcode.leetcode.editor.cn;
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

/*
二叉树的最小深度
思路：递归求左右两个子节点的深度，最小的深度加一则为最小深度
*/
public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDepth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            if (null == root.right && null == root.left) {
                return 1;
            }
            int deep = Integer.MAX_VALUE;//定义一个深度
            if (root.right != null) {
                //求右节点的最小深度
                deep = Math.min(minDepth(root.right), deep);
            }
            if (root.left != null) {
                //求左节点的最小深度
                deep = Math.min(minDepth(root.left), deep);
            }
            //如果一侧节点是空的，则按照非空那侧的深度
            return deep + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}