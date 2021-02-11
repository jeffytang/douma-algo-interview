package com.douma;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Test {
    private static int lines = 0;
    public static void main(String[] args) throws IOException {
        File file = new File("./src/com/douma");

        f(file);

        System.out.println(lines);
    }

    private static void f(File file) throws IOException {
        if (file.isFile()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (reader.readLine() != null) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    // 去掉空行
                    if (line.trim().length() == 0) continue;
                    // 去掉注释
                    if (line.trim().startsWith("/")
                            || line.trim().startsWith("*")) continue;
                    lines++;
                }
            }
        } else {
            File[] files = file.listFiles();
            for (File f : files) f(f);
        }
    }
}
