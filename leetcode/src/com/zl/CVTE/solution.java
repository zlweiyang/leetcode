package com.zl.CVTE;

import com.zl.Solution;

/**
 * @author zlCalma
 * @date 2018/11/16 18:44.
 */
public class solution {

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        solution s = new solution();
        System.out.println( s.isPalindrome(str));
    }
    public boolean isPalindrome(String s) {

        StringBuffer str = new StringBuffer();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='z'&& s.charAt(i)>='a'||s.charAt(i)<='Z'&&s.charAt(i)>='A'||s.charAt(i)>='0'&&s.charAt(i)<='9'){
                str.append(s.charAt(i));
            }
        }
        String sb = str.toString().toLowerCase();
        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
