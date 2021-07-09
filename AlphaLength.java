import java.util.*;

public class AlphaLength {
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

    public ListNode create (String[] words) {
        Set<String> noDupes = new HashSet<>(Arrays.asList(words));
        ArrayList<String> sorting = new ArrayList<>(noDupes);
        Collections.sort(sorting);
        ListNode list = new ListNode(sorting.get(0).length(), null);
        ListNode first = list;
        for(int i=1; i < sorting.size(); i++){
            list.next = new ListNode(sorting.get(i).length(), null);
            list = list.next;
        }
        return first;
    }
}
