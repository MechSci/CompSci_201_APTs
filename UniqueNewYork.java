import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueNewYork {
    public int seen(String[] records) {
        Set<String> unique = new HashSet<>();
        for (String entry : records) {
            unique.addAll(Arrays.asList(entry.split(",")));
        }
        return unique.size();
    }
}
