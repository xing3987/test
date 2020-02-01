package leetcode.leetcode.editor.cn;
//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针

/*
环形链表
思路：判断一个链表是否是环形链表，遍历替换数值为null,如果遍历到了null，则是环形链表
*/
public class P141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (null == head || null == head.next) {
                return false;
            }
            head.val = Integer.MIN_VALUE;
            if (head.next.val == Integer.MIN_VALUE) {
                return true;
            }
            return hasCycle(head.next);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 每次循环删除后面一个节点，直到后面的节点为空(false)，或者后面的节点和当前节点一致(true)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head == head.next) {
                return true;
            }
            if (head.next != null) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return false;
    }
}