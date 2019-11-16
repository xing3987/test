package test;

import java.util.ArrayList;
import java.util.List;

/*
 * 替换一个字符中的数字和标点字符为空格，并把英文单词第一个大写，其他小写
 */
public class PatternAndCaseUpper {
    public static void main(String[] args) {
        String x = "gk.gk2321249!@##gkh@  fhjfjh$##@";
        changeString(x);
    }

    private static void changeString(String x) {
        String s = x.replaceAll("[0-9!@#$.]", " ");
        //通过分隔一个或者多个空格注意这里要使用多个空格的正则匹配，要不然会分割出空字符串
        String[] words = s.split("\\s+");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1) {
                String a = words[i].substring(1).toLowerCase();
                String b = String.valueOf(words[i].charAt(0)).toUpperCase();
                list.add(b + a);
            } else { //去除分隔出的空单词
                list.add(words[i].toUpperCase());
            }
        }

        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sf.append(list.get(i) + ".");
            } else {
                sf.append(list.get(i) + " ");
            }
        }

        System.out.println(sf.toString());
    }
}
