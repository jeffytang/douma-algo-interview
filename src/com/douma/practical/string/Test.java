package com.douma.practical.string;

public class Test {
    public static void main(String[] args) {
        String mainStr = "douma, shake your code"; // 主串
        String patternStr = "your"; // 模式串

        int index = mainStr.indexOf(patternStr);
        System.out.println(index);

        // BF、RK、BM、KMP
    }
}
