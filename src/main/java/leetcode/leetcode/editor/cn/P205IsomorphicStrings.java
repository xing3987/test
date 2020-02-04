package leetcode.leetcode.editor.cn;
//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表

import java.util.HashMap;
import java.util.Map;

/*
同构字符串
思路：确定一个标准字符数组{a,b,c,d...z}
        然后根据输入字符转换成字符串输出（写映射方法）：egg->abb;xdd->abb;dadf->abac
        最终只要看转换后的字符串是否相等即可
     改进：标准模版value变成Integer,int count=0每出现一个不同的value +1
          然后根据输入字符转换成字符串输出（写映射方法）：egg->011;xdd->011;dadf->0102
*/
public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        solution.isIsomorphic("paper", "title");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            String sChange = change(s);
            String tChange = change(t);
            if (sChange.equals(tChange)) {
                return true;
            }
            return false;
        }

        //将字符串转成标准样式
        private String change(String s) {
            int i = 0;
            Map<Character, Integer> map = new HashMap<>();
            StringBuffer sf = new StringBuffer();
            for (int j = 0; j < s.length(); j++) {
                char x = s.charAt(j);
                if (map.get(x) == null) {
                    sf.append(i);
                    map.put(x, i);
                    i++;
                } else {
                    sf.append(map.get(x));
                }
            }
            return sf.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}