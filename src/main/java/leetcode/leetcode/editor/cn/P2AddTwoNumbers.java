package leetcode.leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

import java.util.ArrayList;
import java.util.List;

/*
两数相加
*/
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 链表前加一个节点表示开头
            ListNode head = new ListNode(0);
            ListNode p = l1, q = l2, cur = head;
            int mark = 0;
            while (p != null || q != null) {
                int x = p == null ? 0 : p.val;
                int y = q == null ? 0 : q.val;
                int sum = x + y + mark;
                /* 可以优化代码，但是会增加内存消耗
                 mark = sum / 10;
                 cur.next = new ListNode(sum%10);
                 */
                mark = 0;
                if (sum / 10 > 0) {
                    mark = sum / 10;
                    sum %= 10;
                }
                cur.next = new ListNode(sum);
                cur = cur.next;
                p = p == null ? null : p.next;
                q = q == null ? null : q.next;
            }
            if (mark > 0) {
                cur.next = new ListNode(mark);
            }
            return head.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 拓展创建链表
    private static ListNode createListNode(List<Integer> list) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int x : list) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return head.next;
    }
}