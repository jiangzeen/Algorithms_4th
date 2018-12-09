package basePractice;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例:给定一个链表: 1->2->3->4->5, 和 n = 2.当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @author: 蒋泽恩
 * @date: 2018/12/5 21:44
 * @description:
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode l1 = head,temp = null;
          while (head != null){
              i++;
              head = head.next;
          }
          i = i - n;
          if(i == 0){
              return l1.next;
          }
          head = l1;
          temp = head;
          while (i > 1){
              temp = head.next;
              head = temp;
              i--;
          }
          temp.next = temp.next.next;
          return l1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = new LeetCode19().removeNthFromEnd(node1,5);
        while (node != null){
            System.out.println(node.var);
            node = node.next;
        }
    }
}