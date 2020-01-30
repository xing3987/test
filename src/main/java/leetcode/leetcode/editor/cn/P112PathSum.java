package leetcode.leetcode.editor.cn;
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索

/*
路径总和
思路：递归求和，
出口：叶子节点为空时总的和是否等于目标
*/
public class P112PathSum {
    public static void main(String[] args) {
        Solution solution = new P112PathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return hasPathSum(root, sum, 0);
        }

        public boolean hasPathSum(TreeNode node, int sum, int currentSum) {
            if (null == node) {
                return false;
            }
            /*可能有负数所以还是要全部遍历
            if (node.val + currentSum > sum) {
                return false;
            }*/
            currentSum = node.val + currentSum;
            //如果是叶子节点：在根节点到叶子节点的和与目标值对比
            if (null == node.left && null == node.right) {
                return currentSum == sum;
            }
            //不是叶子节点继续遍历左右子节点
            return hasPathSum(node.left, sum, currentSum)
                    || hasPathSum(node.right, sum, currentSum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}