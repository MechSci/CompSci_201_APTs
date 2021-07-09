public class ListsEqual {
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

    public int equal (ListNode a1, ListNode a2) {
        while(a1 != null){
            if(a2 == null){
                return 0;
            }
            if(a1.info != a2.info){
                return 0;
            }
            a1 = a1.next;
            a2 = a2.next;
        }
        if(a2 != null){
            return 0;
        }
        return 1;
    }
}
