package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/1 17:46.
 */
public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {

        if(s==null || s.length()==0 || t==null || t.length()==0){
            return "";
        }
        char[] target = t.toCharArray();
        char[] source = s.toCharArray();
        int[] count = new int[128];
        //目标字符串长度
        int targetCount = -t.length();
        //目标字符个数
        for(char ch:target){
            count[ch] -=1;
        }

        int left=0;
        int minlen = Integer.MAX_VALUE;
        //定义截取字符串起点
        int start=0;

        for(int right=0;right<source.length;right++){
            char ch = source[right];
            count[ch] +=1;
            //只有当count[ch]==0时正好
            if(count[ch]<=0){
                targetCount++;
            }

            if(targetCount==0){
                while(left<=right && targetCount==0){
                    //更新截取长度，以及起点
                    if(right-left+1<minlen){
                        minlen=Math.min(minlen,right-left+1);
                        start=left;
                    }

                    char l = source[left];
                    count[l] -=1;
                    if(count[l]<0){
                        targetCount--;
                    }
                    left++;
                }
            }
        }

        return minlen == Integer.MAX_VALUE? "":s.substring(start,start+minlen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring76 m = new MinimumWindowSubstring76();
        System.out.println(m.minWindow("ADOBECODEBANC","ABC"));
    }
}
