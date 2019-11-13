package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:
    ｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
    输入描述:
    每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
    输出描述:
    一行输出最后一个被删掉的数的原始下标位置。
    输入例子1:
    8
    输出例子1:
    6
*/
public class DeleteNumber {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //int count = sc.nextInt();
        int count = 8;
        if (count >= 1000) {
            count = 999;
        }
        Integer[] a = new Integer[count];
        for (int i = 0; i < count; i++) {
            a[i] = i;
        }
        //......6.
        List<Integer> list = new ArrayList<>(Arrays.asList(a));

        int i = 0;
        while (list.size() > 1) {
            i = (i + 2) % list.size();//为什么是"+2"?list删除数据后，下标重新计算即删掉：第一次删除0134567,第二次时5的下标为4
            list.remove(i);//删除后list长度减少1
        }
        System.out.println(list.get(0));
    }
}
