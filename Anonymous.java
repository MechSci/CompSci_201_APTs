import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        Map<String, Integer> hMap = new HashMap<>();
        String hChain = String.join("", headlines);
        ArrayList<HashMap<String, Integer>> mList = new ArrayList<>();
        int cannot = 0;
        for(int i=0; i < hChain.length(); i++){
            String current = Character.toString(hChain.charAt(i)).toLowerCase();
            if(! current.equals(" ")){
                hMap.putIfAbsent(current, 0);
                hMap.put(current, hMap.get(current) + 1);
            }
        }
        for(int i=0; i < messages.length; i++){
            mList.add(new HashMap<>());
        }
        for(int i=0; i < messages.length; i++){
            for(int j=0; j < messages[i].length(); j++){
                String current = Character.toString(messages[i].charAt(j)).toLowerCase();
                if(! current.equals(" ")){
                    mList.get(i).putIfAbsent(current, 0);
                    mList.get(i).put(current, mList.get(i).get(current) + 1);
                }
            }
        }
        for (HashMap<String, Integer> mMap : mList) {
            for (String s : mMap.keySet()) {
                if(! hMap.containsKey(s)){
                    cannot++;
                    break;
                }
                if(hMap.get(s) < mMap.get(s)){
                    cannot++;
                    break;
                }
            }
        }
        int can = messages.length - cannot;
        return can;
    }
}
