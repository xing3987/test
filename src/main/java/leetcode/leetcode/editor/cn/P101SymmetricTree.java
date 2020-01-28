package leetcode.leetcode.editor.cn;
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索

/*
对称二叉树
思路：使用递归，左边和右边互成镜像
*/
public class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);//自身成镜像
        }

        //判读是否是镜像，只要两个节点：一个的左子节点和另一个右子节点成镜像，并且右子节点和另一个左子节点成镜像
        private boolean isMirror(TreeNode t1, TreeNode t2) {
            if (null == t1 && null == t2) {
                return true;
            }
            if (null == t1 || null == t2) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}