package com.leetcode.bit;

/**
 * @author zlCalma
 * @date 2019/1/25 23:10.
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int a = x^y;//将x和y中的1的位置映射同一个变量中
        int count =0;
        for(int i=0;i<32;i++) {
            //将变量逐一右移一位并与1相与累加
            count += a & 1;
            a = a >> 1;

        }
        return count;
    }
}
