public class List2Long {
    public long convert(ListNode list) {
        long total = 0;
        while(list != null){
            total = total*10 + list.info;
            list = list.next;
        }
        return total;
    }
}
