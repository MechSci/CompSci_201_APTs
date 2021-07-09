public class ListStretch {
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

    public ListNode stretch (ListNode list, int amount){
        if(list == null){
            return null;
        }
        ListNode done = stretch(list.next, amount);
        ListNode currFirst = list;
        for(int i=1; i < amount; i++){
            list.next = new ListNode(list.info, null);
            list = list.next;
        }
        list.next = done;
        return currFirst;
    }
}
