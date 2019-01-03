package com.leetcode;

import com.weiyang.leetcode.linklist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zlCalma
 * @date 2019/1/1 17:04.
 * 最好使用分而治之的方法
 */
public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null||lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1,ListNode l2){
                if(l1.val<l2.val){
                    return -1;
                }
                else if(l1.val==l2.val){
                    return 0;
                }else{
                    return 1;
                }
            }
        });

        ListNode temp = new ListNode(0);
        ListNode tail = temp;

        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if(tail.next!=null){
                queue.add(tail.next);
            }
        }
        return temp.next;
    }

}
