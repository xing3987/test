package leetcode.leetcode.editor.cn;
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
二叉搜索树中的众数
方法1：使用递归中度遍历
方法2：利用中序遍历，将所有节点值存入map。
        遍历map，拿到最大的value 即保存在max遍历。
        再次遍历map，拿到所有value值等于max的key。
        返回结果。

*/
public class P501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxTimes = 0;
        int thisTimes = 0;
        private volatile List<Integer> res = new ArrayList<>();
        TreeNode pre = null;

        public int[] findMode(TreeNode root) {
            inOrder(root);
            int length = res.size();
            int[] rr = new int[length];
            for (int i = 0; i < length; i++) {
                rr[i] = res.get(i);
            }
            return rr;
        }

        public void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            if (pre != null && pre.val == root.val) {
                thisTimes++;
            } else {
                thisTimes = 1;
            }
            if (thisTimes == maxTimes) {
                res.add(root.val);
            } else if (thisTimes > maxTimes) {
                maxTimes = thisTimes;
                res.clear();
                res.add(root.val);
            }
            pre = root;
            inOrder(root.right);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    // 方法二：遍历所有数据保存到map中后遍历map
    Map<Integer, Integer> map = new HashMap<>();

    private void searchAll(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
        searchAll(treeNode.left);
        searchAll(treeNode.right);
    }
}