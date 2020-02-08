package leetcode.leetcode.editor.cn;
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

import java.util.ArrayList;
import java.util.List;

/*
回文链表
思路：如果一个链表，从前到后和从后到前相同，则是回文数（即反转后相同）
*/
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();
            list = getNodeValue(head, list);
            for (int i = 0; i < list.size() / 2; i++) {
                if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                    return false;
                }
            }
            return true;
        }

        private List<Integer> getNodeValue(ListNode head, List<Integer> list) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}