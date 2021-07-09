import java.util.Arrays;
import java.util.HashSet;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
        HashSet<String> avail = new HashSet<>(Arrays.asList(available));
        //System.out.println(avail.toString());
        for(int i=0; i < orders.length; i++) {
            String[] item = orders[i].split(" ");
            //System.out.println(Arrays.toString(item));
            //System.out.println(checkItem(avail, item));
            if(checkItem(avail, item)){
                return i;
            }
        }
        return -1;
    }
    private boolean checkItem(HashSet<String> avail, String[] item){
        for (String ingredient : item) {
            if(! avail.contains(ingredient)){
                return false;
            }
        }
        return true;
    }
}
