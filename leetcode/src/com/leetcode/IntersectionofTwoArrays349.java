package com.leetcode;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zlCalma
 * @date 2019/1/10 22:47.
 */
public class IntersectionofTwoArrays349 {

    public int[] intersection(int [] nums1,int nums2[]){
        Set set1 = new HashSet();
        Set set2 = new HashSet();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        int count=0;
        Iterator <Integer>iterator = set2.iterator();
        while(iterator.hasNext()){
            res[count++] = iterator.next().intValue();
        }
         return res;
    }

    public static void main(String[] args) {
        int [] nums1= {1,2,2,1};
        int [] nums2={2,2};
        int [] res = new int[4];
        IntersectionofTwoArrays349 inter = new IntersectionofTwoArrays349();
        res = inter.intersection(nums1,nums2);
        for(int i:res){
            System.out.println(i);
        }
    }
}
