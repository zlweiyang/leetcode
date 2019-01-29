package com.leetcode.strringpro;

/**
 * @author zlCalma
 * @date 2019/1/3 17:21.
 * 本方法勉强通过
 * dp效果较好，待优化
 */
public class RegularExpressionMatching10 {

    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0)||p.charAt(0)=='.'));

        if(p.length() >= 2 && p.charAt(1)=='*'){
            if(isMatch(s,p.substring(2))){
                return true;
            }else{
                return first_match && isMatch(s.substring(1),p);
            }
        }else{
            return first_match && isMatch(s.substring(1),p.substring(1));
        }

    }
}
