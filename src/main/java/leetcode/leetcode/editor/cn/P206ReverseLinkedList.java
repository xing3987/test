package leetcode.leetcode.editor.cn;
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

import java.util.ArrayList;
import java.util.List;

/*
反转链表
*/
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode reverseList(ListNode head) {
            //创建一个list保存链表的数据
            List<Integer> list = new ArrayList<>();
            while (null != head) {
                list.add(0, head.val);
                head = head.next;
            }
            return createNode(list, 0);
        }

        /**
         * 通过list创建链表
         *
         * @param list
         * @param i
         * @return
         */
        private ListNode createNode(List<Integer> list, int i) {
            if (i >= list.size()) {
                return null;
            }
            ListNode listNode = new ListNode(list.get(i));
            listNode.next = createNode(list, i + 1);
            return listNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 更好的方法，直接改变指针的方向
     */
    private static ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}