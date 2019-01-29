package com.leetcode.strringpro;

/**
 * @author zlCalma
 * @date 2019/1/3 18:14.
 * 待优化
 */
public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        int [] res = new int[word2.length()+1];
        for(int i=0;i<=word2.length();i++){
            res[i] = i;
        }

        for(int i=1;i<=word1.length();i++){
            int prev = res[0];
            res[0]=i;
            for(int j=1;j<=word2.length();j++){
                int tmp = res[j];
                res[j] = Math.min(res[j-1],res[j])+1;
                res[j] = Math.min(res[j],prev+(word1.charAt(i-1)==word2.charAt(j-1)?0:1));
                prev = tmp;
            }
        }

        return res[word2.length()];
    }
}
