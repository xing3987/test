package leetcode.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

import java.util.Stack;

/*
有效的括号
*/
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        System.out.println(isValid("({}{})"));
    }

    /**
     * 使用栈解决问题（栈先进先出，栈顶元素为最后放入元素）：
     * push( num) //入栈
     * pop() //栈顶元素出栈
     * empty() //判定栈是否为空
     * peek() //获取栈顶元素
     * search(num) //判端元素num是否在栈中，如果在返回1，不在返回-1
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack();
            char[] chars = s.toCharArray();
            for (char x : chars) {
                if (stack.empty()) {
                    stack.push(x);
                } else if (isGroup(stack.peek(), x)) {
                    stack.pop();
                } else {
                    stack.push(x);
                }
            }
            return stack.size() == 0;
        }

        /**
         * 判断是不是一组的
         *
         * @param a
         * @param b
         * @return
         */
        private boolean isGroup(char a, char b) {
            if (a == '(' && b == ')'
                    || a == '[' && b == ']'
                    || a == '{' && b == '}') {
                return true;
            }
            return false;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 解法二：字符串循环消除法
     */
    private static boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\[\\]", "");
            s = s.replaceAll("\\{\\}", "");
        }
        return s.length() == 0;
    }
}