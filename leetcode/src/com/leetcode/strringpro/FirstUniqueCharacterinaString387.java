package com.leetcode.strringpro;

/**
 * @author zlCalma
 * @date 2019/1/29 22:11.
 */
public class FirstUniqueCharacterinaString387 {
    public int firstUniqChar(String s) {
        if(s.length() == 0){
            return -1;
        }
        int [] count = new int[255];
        for(int i=0;i<255;i++){
            count[i] = 0;
        }
        for(int j=0;j<s.length();j++){
            count[s.charAt(j) - '\0']++;
        }
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i) - '\0'] == 1){
                return i;
            }
        }
        return -1;
    }
}
