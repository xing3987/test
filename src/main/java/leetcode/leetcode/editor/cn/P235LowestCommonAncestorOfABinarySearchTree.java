package leetcode.leetcode.editor.cn;
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树

/*
二叉搜索树的最近公共祖先
思路：找二叉树的最底下的某个节点同时包含这两个子节点
        写共同方法一个节点包含某个节点，然后循环遍历找最底层节点
*/
public class P235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                if (contains(root.right, p) && contains(root.right, q)) {
                    root = root.right;
                } else if (contains(root.left, p) && contains(root.left, q)) {
                    root = root.left;
                } else {
                    break;
                }
            }
            return root;
        }

        /**
         * 判断一个节点是否是另一个节点的子节点
         *
         * @param root
         * @param x
         * @return
         */
        private Boolean contains(TreeNode root, TreeNode x) {
            if (root == null || x == null) {
                return false;
            } else if (root.val == x.val) {
                return true;
            }
            return contains(root.right, x) || contains(root.left, x);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}