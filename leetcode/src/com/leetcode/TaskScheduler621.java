package com.leetcode;

import java.util.Arrays;

/**
 * @author zlCalma
 * @date 2019/1/2 18:23.
 */
public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];
        for(char ch : tasks){
            count[ch - 'A']++;
        }
        Arrays.sort(count);
        int i=25;
        while(i>=0 && count[i] == count[25]){
            i--;
        }
        return Math.max(tasks.length,(count[25]-1)*(n+1)+25-i);
    }
}
