package com.leetcode;

/**
 * @author zlCalma
 * @date 2018/12/25 15:42.
 * 滑动窗口法
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
        public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = -1;
        char[] arr = new char[256];
        int res = 0;
            while(left < s.length()){
            if(right+1<s.length() && arr[s.charAt(right+1)] == 0){
                arr[s.charAt(++right)]++;
            }else{
                arr[s.charAt(left++)]--;
            }

            res = Math.max(res,right-left+1);
        }
            return res;

        }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 l = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }
}
