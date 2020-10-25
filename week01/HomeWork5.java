
class ListNode {
    int val;
    ListNode next;
   ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


/**
 *  合并两个有序链表
 */
public class HomeWork5 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 建立头节点
        ListNode head = new ListNode();
        compareAndLink(head , l1 , l2 );
        return head.next;
    }

    // 比较 并 建立连接
    public void  compareAndLink(ListNode current , ListNode l1 , ListNode l2){
        if(l1 == null) {
            current.next = l2;
            return;
        }
        if(l2 == null) {
            current.next = l1;
            return;
        }
        // 比较值 并连接
        if(l1.val <= l2.val){
            current.next = l1;
            compareAndLink(current.next , l1.next , l2);
        }else{
            current.next = l2;
            compareAndLink(current.next , l1 , l2.next);
        }
    }


}
