package com.leetcode.strringpro;

/**
 * @author zlCalma
 * @date 2018/12/28 13:34.
 * 中心扩展法
 */
public class LongestPalindromicSubstring5 {

    public String res = "";

    public String longestPalindrome(String s) {

        if(s == null ||s.length() == 0){
            return res;
        }
        if(s.length() == 1){
            return s;
        }
        for(int i=1;i<s.length();i++){
            helper(s,i,i);
            helper(s,i-1,i);
        }

        return res;
    }

    public void helper(String s,int left,int right){
        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1,right);
        if(cur.length() > res.length()){
            res = cur;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring5 l = new LongestPalindromicSubstring5();
        System.out.println(l.longestPalindrome("abbc"));
        System.out.println(l.longestPalindrome("babad"));
    }
}
