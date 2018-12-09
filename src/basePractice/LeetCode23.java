package basePractice;

import java.util.List;

/**
 * 合并K个有序链表
 * @author: 蒋泽恩
 * @date: 2018/12/6 17:00
 * @description:
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size == 0){
            return null;
        }
        if(size == 1){
            return lists[0];
        }
        ListNode head = null;
        head = mergeTwoLists(lists[0],lists[1]);
        for (int i = 1; i < size - 1; i++) {
            head = mergeTwoLists(head, lists[i+1]);
        }
        return head;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**判断是否为空**/
        if(l1== null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode l3 = null;
        /**确定头结点**/
        if(l1.var <= l2.var){
            l3 = l1;
            l1 = l1.next;
        }else{
            l3 = l2;
            l2 = l2.next;
        }
        ListNode temp = l3;
        while (l1 != null && l2 != null){
            if(l1.var <= l2.var){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1==null?l2:l1;
        return l3;
    }
}
