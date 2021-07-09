public class ListCount {
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

    public int count (ListNode list) {
        if(list == null){
            return 0;
        }
        return count(list.next) + 1;
    }
}
