package leetcode.leetcode.editor.cn;
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

/*
将有序数组转换为二叉搜索树
二叉搜索树（Binary Search Tree）是指一棵空树或具有如下性质的二叉树：
        1.若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值
        2.若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值
        3.任意节点的左、右子树也分别为二叉搜索树
        4.没有键值相等的节点
*/
public class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return createTreeNode(nums, 0, nums.length);
        }

        /**
         * 递归创建节点
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private TreeNode createTreeNode(int[] nums, int start, int end) {
            if (start == end) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = createTreeNode(nums, start, mid);
            treeNode.right = createTreeNode(nums, mid + 1, end);
            return treeNode;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}