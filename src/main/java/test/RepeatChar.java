package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/784efd40ed8e465a84821c8f3970b7b5
 * 来源：牛客网
 * <p>
 * 输入一个字符串，求出该字符串包含的字符集合
 * <p>
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 * <p>
 * <p>
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * 示例1
 * 输入
 * abcqweracb
 * 输出
 * abcqwer
 */
public class RepeatChar {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String line = in.nextLine();
        String line = "abcjsadjfoiwieohnnc";
        StringBuffer aim = new StringBuffer();
        for (int i = 0; i < line.length(); i++) {
            String index = String.valueOf(line.charAt(i));
            if (!aim.toString().contains(index)) {
                aim.append(index);
            }
        }
        System.out.println(aim);

        /*Set<Character> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            char index = line.charAt(i);
            if (set.add(index)) {
                aim.append(index);
            }
        }
        System.out.println(aim.toString());*/
    }
}
