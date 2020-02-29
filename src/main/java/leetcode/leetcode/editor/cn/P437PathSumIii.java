package leetcode.leetcode.editor.cn;
//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树

/*
路径总和 III
*/
public class P437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        /**
         * 遍历所有节点，计算以每个节点为根节点的总值为sum的数量
         *
         * @param root
         * @param sum
         * @return
         */
        public int pathSum(TreeNode root, int sum) {
            if (root != null) {
                countRoot(root, 0, sum);

                if (root.left != null) {
                    pathSum(root.left, sum);
                }
                if (root.right != null) {
                    pathSum(root.right, sum);
                }
            }
            return count;
        }

        /**
         * 计算以该节点为根节点的所有和为目标数的个数
         *
         * @param node
         */
        private void countRoot(TreeNode node, int currentSum, int sum) {
            currentSum += node.val;
            if (currentSum == sum) {
                count++;
            }
            if (node.left != null) {
                countRoot(node.left, currentSum, sum);
            }
            if (node.right != null) {
                countRoot(node.right, currentSum, sum);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}