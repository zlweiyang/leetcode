package com.leetcode.linkedlist;

import com.weiyang.leetcode.linklist.ListNode;

/**
 * @author zlCalma
 * @date 2019/1/28 21:34.
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else{
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
        }
        ListNode l3 = null;//建立一个新链表用于存储新的链表
        if(l1.val < l2.val){
            l3 = l1;//保存小的递归下一个
            l3.next = mergeTwoLists(l1.next,l2);
        }else{
            l3 = l2;
            l3.next = mergeTwoLists(l1,l2.next);
        }
        return l3;
    }
}
