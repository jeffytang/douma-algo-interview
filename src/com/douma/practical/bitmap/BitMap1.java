package com.douma.practical.bitmap;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class BitMap1 {
    private byte b;

    public BitMap1() {
        b = 0;
    }

    public void set(int num) {
        /*
            set 2
            00000001 << 2
            00000100
          | 00000000
          = 00000100

            set 2
            00000001 << 2
            00000100
          | 00000100
          = 00000100
         */
        b |= (1 << num);
    }

    public boolean contains(int target) {
        /*
            contains 4
            00000001 << 4
            00010000
          & 10101100
          = 00000000
         */
        // 10101100
        return ((1 << target) & b) != 0;
    }

    @Override
    public String toString() {
        return "BitMap{" +
                "b=" + Integer.toBinaryString(b).substring(24) +
                '}';
    }

    public static void main(String[] args) {
        int[] data = new int[] {2, 7, 2, 5, 3};
        int target = 2;

        BitMap1 bitMap1 = new BitMap1();
        for (int i = 0; i < data.length; i++) {
            bitMap1.set(data[i]);
        }

        System.out.println(bitMap1);

        if (bitMap1.contains(target)) {
            System.out.println("存在目标值：" + target);
        }
    }
}
