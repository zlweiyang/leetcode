package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2019/1/25 23:39.
 */
public class JewelsandStones771 {
    public int numJewelsInStones(String J, String S) {
        int sum=0;
        for(int i=0;i<J.length();i++){
            for(int j=0;j<S.length();j++){
                if(J.charAt(i) == S.charAt(j)){
                    sum++;
                }
            }
        }
        return sum;
    }
}
