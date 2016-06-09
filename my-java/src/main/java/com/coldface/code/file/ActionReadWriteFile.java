package com.coldface.code.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.apache.commons.io.Charsets;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

/**
 * 类ActionReadWriteFile.java的实现描述：操作文件类
 * 
 * @author coldface
 * @date 2016年5月19日上午10:29:41
 */
public class ActionReadWriteFile {


    public static void main(String[] args) {
        // 读取的文件
        String inFileName = "indata.txt";
        // 写入的文件
        File outFileName = new File("outdata.txt");
        readWriteFile(inFileName, outFileName);
        System.out.println("执行完毕....");
    }


    public static void readWriteFile(String infileName, File outFileName) {
        File testFile = new File(infileName);

        List<String> lines = Lists.newArrayList();
        try {
            lines = Files.readLines(testFile, Charsets.UTF_8);
            int i = 1;
            for (String line : lines) {
                System.out.println(i + "===" + line);
                if (line != null) {
                    //line += "操作之后的文本";
                    line+=line;
                    BufferedWriter out = new BufferedWriter(new FileWriter(outFileName, true));
                    out.write(line);
                    out.newLine();
                    out.flush();
                    out.close();
                } else {
                    System.out.println("---" + line);
                }
                i += 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
