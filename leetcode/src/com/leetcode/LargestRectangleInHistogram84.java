package com.leetcode;

import java.util.Stack;

/**
 * @author zlCalma
 * @date 2018/12/20 22:24.
 */
public class LargestRectangleInHistogram84 {

    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<=heights.length;i++){
            int h = i==heights.length? 0:heights[i];
            while(!stack.isEmpty()&&h<heights[stack.peek()]){
                int height = heights[stack.pop()];
                int start = stack.isEmpty()? -1:stack.peek();
                int area = height*(i-start-1);
                res = Math.max(res,area);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram84 ex = new LargestRectangleInHistogram84();
        int []arr  = {2,1,5,6,2,3};
        ex.largestRectangleArea(arr);
    }

}
