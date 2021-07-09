public class MergeLists {
    /*
    public class ListNode {
        int info;
        ListNode next;
        ListNode(int x){
            info = x;
        }
        ListNode(int x, ListNode node){
            info = x;
            next = node;
        }
    }
     */

    public ListNode weave (ListNode a, ListNode b) {
        ListNode first = a;
        while(a != null){
            ListNode tempA = a.next;
            ListNode tempB = b.next;
            a.next = b;
            b.next = tempA;
            a = b.next;
            b = tempB;
        }
        return first;
    }
}
