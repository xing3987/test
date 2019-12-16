package test;

/**
 * @author chenxing
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * <p>
 * <p>
 * 示例 ：
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int begin, int end) {
        if (nums == null || begin > end) {
            return null;
        }
        int maxIndex = 0;
        int maxNum = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] > maxNum) {
                maxIndex = i;
                maxNum = nums[i];
            }
        }
        TreeNode treeNode = new TreeNode(maxNum);
        treeNode.left = buildTree(nums, begin, maxIndex - 1);
        treeNode.right = buildTree(nums, maxIndex + 1, end);
        return treeNode;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
