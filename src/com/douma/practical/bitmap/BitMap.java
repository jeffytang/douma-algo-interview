package com.douma.practical.bitmap;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class BitMap {
    private byte[] bytes;
    private int nBits;

    public BitMap(int nBits) {
        this.nBits = nBits;
        this.bytes = new byte[nBits / 8 + 1];
    }

    public void set(int num) {
        if (num > nBits) return;
        // 找到第几个字节
        int byteIndex = num / 8;
        // 找到第几位
        int bitIndex = num % 8;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean contains(int target) {
        if (target > nBits) return false;
        // 找到第几个字节
        int byteIndex = target / 8;
        // 找到第几位
        int bitIndex = target % 8;
        return ((1 << bitIndex) & bytes[byteIndex]) != 0;
    }

    public static void main(String[] args) {
        int[] data = new int[] {2, 7, 2, 5, 3};
        int target = 2;

        BitMap bitMap1 = new BitMap(8);
        for (int i = 0; i < data.length; i++) {
            bitMap1.set(data[i]);
        }

        System.out.println(bitMap1);

        if (bitMap1.contains(target)) {
            System.out.println("存在目标值：" + target);
        }
    }
}
