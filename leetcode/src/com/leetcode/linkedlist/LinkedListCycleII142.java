package com.leetcode.linkedlist;

import com.weiyang.leetcode.linklist.ListNode;

/**
 * @author zlCalma
 * @date 2019/1/27 20:03.
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。



示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {
        if(!isCycle(head)){
            return null;
        }else{
            //利用快慢指针，找到快慢指针相遇点
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next.next;
            }
            //计算出环中节点个数
            ListNode tmp = slow.next;
            int count = 1;
            while(tmp != fast){
                count++;
                tmp = tmp.next;
            }
            //从头重新开始遍历。前指针先走count步，慢指针再开始走
            ListNode pre = head;
            for(int i=0;i<count;i++){
                pre = pre.next;
            }
            while(head != pre){
                head = head.next;
                pre = pre.next;
            }
            return pre;
        }
    }
    //判断是否有环
    public boolean isCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
