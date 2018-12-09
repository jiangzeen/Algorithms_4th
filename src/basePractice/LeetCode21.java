package basePractice;

/**
 * @author: 蒋泽恩
 * @date: 2018/12/5 22:21
 * @description:
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
