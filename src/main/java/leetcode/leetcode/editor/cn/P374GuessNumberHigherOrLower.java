package leetcode.leetcode.editor.cn;
//我们正在玩一个猜数字游戏。 游戏规则如下： 
//我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。 
//每次你猜错了，我会告诉你这个数字是大了还是小了。 
//你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）： 
//
// -1 : 我的数字比较小
// 1 : 我的数字比较大
// 0 : 恭喜！你猜对了！
// 
//
// 示例 : 
//
// 输入: n = 10, pick = 6
//输出: 6 
// Related Topics 二分查找

/*
猜数字大小
*/
public class P374GuessNumberHigherOrLower {
    /*public static void main(String[] args) {
        Solution solution = new P374GuessNumberHigherOrLower().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
*//* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); *//*

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 0;
            int right = n;
            int num = 0;
            while (left <= right) {
                num = left + (right - left) / 2;
                if (guess(num) == 1) {
                    left = num + 1;
                } else if (guess(num) == -1) {
                    right = num - 1;
                } else {
                    return num;
                }
            }
            return num;
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)

}