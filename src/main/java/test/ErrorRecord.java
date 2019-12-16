package test;
/*
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

    文件路径为windows格式

    如：E:\V1R2\product\fpgadrive.c 1325

输出描述:
将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1

    结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。

    如果超过8条记录，则只输出前8条记录.

    如果文件名的长度超过16个字符，则只输出后16个字符

输入例子1:
E:\V1R2\product\fpgadrive.c 1325

输出例子1:
fpgadrive.c 1325 1
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenxing
 */
public class ErrorRecord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Record> records = new ArrayList<>();
        while (sc.hasNext()) {
            String path = sc.next();
            String pathSimple = path.substring(path.lastIndexOf("\\") + 1);
            int line = sc.nextInt();
            Record record = new Record(pathSimple, line, 1);
            insertIntoList(record, records);
        }

        Collections.sort(records);
        int j = 0;
        for (Record in : records) {
            if (j++ == 8) {
                break;
            }
            System.out.println(formatFileName(in.getFileName()) + " " + in.getLine() + " " + in.getCount());
        }

        sc.close();

    }

    private static String formatFileName(String fileName) {
        if (fileName.length() > 16) {
            return fileName.substring(fileName.length() - 16);
        }
        return fileName;
    }

    private static void insertIntoList(Record record, List<Record> records) {
        for (Record in : records) {
            if (record.getFileName().equals(in.getFileName()) && record.getLine() == in.getLine()) {
                in.setCount(in.getCount() + 1);
                return;
            }
        }
        records.add(record);
    }
}


class Record implements Comparable<Record> {
    private String fileName;
    private int line;
    private int count;

    public Record() {
    }

    public Record(String fileName, Integer line, Integer count) {
        this.fileName = fileName;
        this.line = line;
        this.count = count;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Record o) {
        return o.count - this.count;
    }
}

