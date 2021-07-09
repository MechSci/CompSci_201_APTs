public class ListEveryK {
    public int sumTheKth(ListNode list, int k){
        return helper(list, k, k);
    }
    private int helper(ListNode list, int realK, int currentK){
        if(list == null){
            return 0;
        }

        if(currentK == 1){
            return list.info + helper(list.next, realK, realK);
        }
        return helper(list.next, realK, currentK - 1);
    }
}
