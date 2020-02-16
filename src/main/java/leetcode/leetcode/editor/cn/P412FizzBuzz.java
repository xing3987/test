package leetcode.leetcode.editor.cn;
//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
//

import java.util.ArrayList;
import java.util.List;

/*
Fizz Buzz
*/
public class P412FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new P412FizzBuzz().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String FIZZ = "Fizz";
        private String BUZZ = "Buzz";
        private String FIZZBUZZ = "FizzBuzz";

        public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    list.add(FIZZBUZZ);
                } else if (i % 3 == 0) {
                    list.add(FIZZ);
                } else if (i % 5 == 0) {
                    list.add(BUZZ);
                } else {
                    list.add(String.valueOf(i));
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}