package com.zl.CVTE;

import java.util.*;

/**
 * @author zlCalma
 * @date 2018/11/15 21:53.
 */
public class CharOfFirst {

//    public char FirstNotRepeatingChar(String str) {
//        Map<Character,Integer> map = new HashMap<Character,Integer>();
//        for(int i=0;i<str.length();i++){
//            Integer value = map.get(str.charAt(i));
//            map.put(str.charAt(i),(value == null? 0:value)+1);
//        }
//        List<Character> list = new ArrayList<Character>();
//        for(Map.Entry<Character,Integer> entry : map.entrySet()){
//            if(entry.getValue() == 1){
//                list.add(entry.getKey());
//            }
//        }
//        if(list.isEmpty()){
//            return '\0';
//        }
//        for(int j=0;j<str.length();j++){
//            for(int i=0;i<list.size();i++){
//                if(str.charAt(j) == list.get(i)){
//                    return str.charAt(j);
//                }
//            }
//        }
//        return '\0';
//    }

    public static void main(String[] args){
        CharOfFirst cof = new CharOfFirst();
        Scanner in = new Scanner(System.in);
        String str = null;
        if(in.hasNext()){
            str = in.nextLine();
        }
        System.out.println(cof.FirstNotRepeatingChar(str));
    }

    private char FirstNotRepeatingChar(String str) {
        if(str.length() == 0){
            return '\0';
        }
        int [] count  = new int[255];
        for(int i=0;i<255;i++){
            count[i] = 0;
        }
        for (int j = 0;j<str.length();j++){
            count[str.charAt(j)-'\0']++;
        }
        for (int i=0;i<str.length();i++){
            if(count[str.charAt(i) - '\0'] == 1){
                return str.charAt(i);
                //break;
            }
        }
        return '\0';
    }
}
