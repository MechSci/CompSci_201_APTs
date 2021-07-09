import java.util.ArrayList;
import java.util.Arrays;

public class CodeCompression {
    public String compress(String message){
        ArrayList<String> letters = new ArrayList<>(Arrays.asList(message.split("")));
        int size = 1;
        String prev = letters.get(0);
        StringBuilder compressed = new StringBuilder("");
        if(letters.size() == 1){
            compressed.append(letters.get(0));
            compressed.append(1);
        }
        for(int i=1; i < letters.size(); i++){
            if(letters.get(i).equals(prev) && i != letters.size() - 1){
                size++;
            }
            else{
                compressed.append(prev);
                if(i == letters.size() - 1){
                    size++;
                }
                compressed.append(size);
                size = 1;
            }
            prev = letters.get(i);
        }
        return compressed.toString();
    }
}

/*
    public String compress(String message){
        ArrayList<String> letters = new ArrayList<>(Arrays.asList(message.split("")));
        String prev = "";
        String current;
        ArrayList<Integer> freq = new ArrayList<>();
        freq.add(0);
        for(int i=0; i < letters.size() - 1; i++) {
            if(letters.get(i).equals(letters.get(i+1))){
                letters.remove(i+1);
                freq.add(i, freq.get(i) + 1);
            }
            else{
                if()
                    freq.add(0);
            }
        }
        StringBuilder compressed = new StringBuilder("");
        for(int i=0; i < message.length(); i++){
            current = letters[i];
            if(! prev.equals(current)){
                compressed.append(current);
                compressed.append(chars.get(current));
            }
            prev = current;
        }
        return compressed.toString();
    }
}
*/