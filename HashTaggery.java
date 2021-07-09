import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashTaggery {
    public String maxTag(String[] tags, String[] messages) {
        double covered = 0.0;
        Set<String> allTags = new HashSet<>(Arrays.asList(tags));
        for (String message : messages) {
            for (String word : message.split(" ")) {
                if(allTags.contains(word)){
                    covered += 1.0;
                    break;
                }
            }
        }
        double totMes = messages.length;
        if(covered / totMes >= 0.75){
            return "tagged";
        }
        return "missed";
    }
}
