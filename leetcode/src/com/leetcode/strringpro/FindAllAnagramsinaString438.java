package com.leetcode.strringpro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/22 23:34.
 */
public class FindAllAnagramsinaString438 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<Integer>();
            int slen = s.length();
            int plen = p.length();
            int[] arr = new int[26];
            for(int i=0;i<plen;i++){
                arr[p.charAt(i)-'a']++;
            }
            int start=0;
            int end=0;
            int diff = plen;
            while(end<slen&&start<=end){
                if(--arr[s.charAt(end)-'a'] >= 0){
                    diff--;
                }
                while(diff==0){
                    int len = end-start+1;
                    if(len == plen){
                        res.add(start);
                    }
                    if(++arr[s.charAt(start)-'a']>0){
                        diff++;
                    }
                    start++;
                }
                end++;
            }
            return res;
        }

    public static void main(String[] args) {
        FindAllAnagramsinaString438 f = new FindAllAnagramsinaString438();
        f.findAnagrams("cbaebabacd","abc");
    }
    }

