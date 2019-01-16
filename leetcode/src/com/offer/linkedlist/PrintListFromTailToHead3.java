package com.offer.linkedlist;

import com.weiyang.leetcode.linklist.ListNode;

import java.util.ArrayList;

/**
 * @author zlCalma
 * @date 2019/1/14 23:30.
 *
 * 充分说明递归调用值的顺序是逆序的
 */
public class PrintListFromTailToHead3 {

    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if(listNode != null){
            printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }
}
