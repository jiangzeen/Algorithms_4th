package basePractice;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表
 * @author: 蒋泽恩
 * @date: 2018/10/20 19:52
 * @description:
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode tempNode = list;
        int sum, temp = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 != null? l1.var:0) + (l2 != null? l2.var:0) + temp;
            //保存进位
            temp = sum / 10;
            ListNode node = new ListNode(sum % 10);
            //头插法创建新链表,引入一个新的临时链表
            tempNode.next = node;
            //指向链表尾
            tempNode = node;
            l1 = l1 != null?l1.next:null;
            l2 = l2 != null?l2.next:null;

        }
        if(temp > 0){
            ListNode node = new ListNode(temp);
            tempNode.next = node;
        }
        return list.next;
    }
}
class ListNode{
    int var;
    ListNode next;
    ListNode(int x){
        var = x;
    }
}