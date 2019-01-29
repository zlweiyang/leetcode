package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/1 16:33.
 */
public class MergeIntervals56 {

    class Interval{
        int start;
        int end;
        Interval(){
            start=0;
            end=0;
        }
        Interval(int s,int e){
            start = s;
            end = e;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];
        for(int i=0;i<len;i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res = new ArrayList<Interval>();
        for(int i=0,j=0;i<len;i++){
            if(i==len-1 || starts[i+1]>ends[i]){
                res.add(new Interval(starts[j],ends[i]));
                j=i+1;
            }
        }
        return res;
    }
}
