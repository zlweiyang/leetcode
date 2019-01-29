package com.leetcode.linkedlist;

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
            if (lists == null || lists.length == 0) {
                return null;
            }
            return sort(lists, 0, lists.length - 1);
        }
        public ListNode sort (ListNode[]lists,int low, int high){
            if (low >= high) {
                return lists[low];
            }
            int mid = (low + high) / 2;
            ListNode l1 = sort(lists, low, mid);
            ListNode l2 = sort(lists, mid + 1, high);
            return merge(l1, l2);
        }
        public ListNode merge (ListNode l1, ListNode l2){
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            } else {
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }
    }
