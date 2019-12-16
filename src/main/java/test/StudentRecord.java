package test;

import java.util.Scanner;

/**
 * @author chenxing
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * <p>
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * <p>
 * 输入例子1:
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * <p>
 * 输出例子1:
 * 5
 * 6
 * 5
 * 9
 */
public class StudentRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String row = sc.nextLine();
        String[] rows = row.split(" ");
        int count = Integer.valueOf(rows[0]);
        int control = Integer.valueOf(rows[1]);

        String[] dataStr = sc.nextLine().split(" ");
        Integer[] datas = new Integer[count];
        for (int i = 0; i < dataStr.length; i++) {
            datas[i] = Integer.valueOf(dataStr[i]);
        }

        for (int j = 0; j < control; j++) {
            String detail = sc.nextLine();
            String a = detail.split(" ")[0];
            String b = detail.split(" ")[1];
            String c = detail.split(" ")[2];
            if (a.equals("Q")) {
                System.out.println(getMax(datas, Integer.valueOf(b) - 1, Integer.valueOf(c) - 1));
            } else {
                reset(datas, Integer.valueOf(b) - 1, Integer.valueOf(c));
            }
        }
        sc.close();
    }

    public static Integer getMax(Integer[] datas, int begin, int end) {
        int max = datas[begin];
        for (int i = begin; i <= end; i++) {
            if (max < datas[i]) {
                max = datas[i];
            }
        }
        return max;
    }

    public static void reset(Integer[] datas, int index, int record) {
        datas[index] = record;
    }
}
