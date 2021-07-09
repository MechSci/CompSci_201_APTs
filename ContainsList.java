public class ContainsList {
    public String check(ListNode first, ListNode second){
        while(first != null){
            if(first.info == second.info){
                ListNode checkFirst = first;
                ListNode checkSecond = second;
                while(checkFirst.info == checkSecond.info){
                    checkFirst = checkFirst.next;
                    checkSecond = checkSecond.next;
                    if(checkSecond == null){
                        return "YES";
                    }
                    if(checkFirst == null){
                        return "NO";
                    }
                }
            }
            first = first.next;
        }
        return "NO";
    }
}
