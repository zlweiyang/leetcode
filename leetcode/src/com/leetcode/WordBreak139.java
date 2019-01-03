package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/2 22:48.
 * 效率不高，有待优化
 */
public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] res = new boolean[s.length()+1];
        res[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String tmp = s.substring(j,i);
                if(res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }

        return res[s.length()];
    }

    public static void main(String[] args) {
        List<String> temp = new ArrayList<>();
        temp.add("leet");
        temp.add("code");
        WordBreak139 w = new WordBreak139();
        System.out.println(w.wordBreak("leetcode",temp));
    }
}
