public class RemoveN {
    /*
    public static void main(String[] args) {
        RemoveN a = new RemoveN();
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        a.move(list, 2, 2);
    }
     */

    public ListNode move(ListNode list, int remove, int n) {
        ListNode first = list;
        ListNode startPrev, start, endShuffle;
        boolean firstFalse = true;
        if(list == null){
            return list;
        }
        if(list.next == null){
            return first;
        }
        if(list.info == remove){
            firstFalse = false;
        }
        if(firstFalse){
            list = list.next;
            while(list.info != remove){
                list = list.next;
                if(list == null){
                    return first;
                }
            }
        }
        startPrev = list;
        start = list.next;
        int count = 0;
        if(start == null){
            return first;
        }
        while(count < n){
            list = list.next;
            count++;
            if(list.next == null){
                return first;
            }
        }
        endShuffle = list;
        while(list.next != null){
            list = list.next;
        }
        startPrev.next = endShuffle.next;
        list.next = start;
        endShuffle.next = null;
        return first;
    }
}
