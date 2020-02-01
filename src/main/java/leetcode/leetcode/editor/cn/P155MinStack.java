package leetcode.leetcode.editor.cn;
//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
最小栈
*/
public class P155MinStack {
    public static void main(String[] args) {
        MinStack solution = new P155MinStack().new MinStack();
        solution.top();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private List<Integer> list;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            list.remove(list.size() - 1);
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            return Collections.min(list);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
/*
不使用工具类自己实现
使用两个栈，一个保存数据；另一个保存最小值，如果新的数比最小值大新的数就保存最小值占位
public class MinStack {

    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    *//**
     * initialize your data structure here.
     *//*
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    // 思路 1：数据栈和辅助栈在任何时候都同步

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}*/

}