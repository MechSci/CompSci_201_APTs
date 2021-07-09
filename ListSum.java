public class ListSum {
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

    public int sum(ListNode list, int thresh) {
        if(list == null){
            return 0;
        }
        int currentSum = sum(list.next, thresh);
        if(list.info > thresh){
            return list.info + currentSum;
        }
        return currentSum;
    }
}
