import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlphaPath {
    public String hasPath(String[] maze) {
        char charLetter;
        Map<Character, ArrayList<Character>> adjList = new HashMap<>();
        int entryCounter = -1;
        int posCounter;
        for (String s : maze) {
            entryCounter++;
            posCounter = -1;
            for (String letter : s.split("")) {
                posCounter++;
                charLetter = letter.charAt(0);
                if(isCapLetter(charLetter)){
                    adjList.putIfAbsent(charLetter, new ArrayList<Character>());
                    adjSearch(adjList, charLetter, entryCounter, posCounter, maze);
                }
            }
        }
        char start = 'A';
        char current = 'B';
        while(true){
            if(! adjList.get(start).contains(current)){
                return "NO";
            }
            if(current == 'Z'){
                return "YES";
            }
            start++;
            current++;
        }
    }
    private void adjSearch(Map<Character, ArrayList<Character>> adjList, char letter, int entryCounter, int posCounter, String[] maze){
        if(posCounter != maze[entryCounter].length() - 1){
            char rightChar = maze[entryCounter].charAt(posCounter + 1);
            if(isCapLetter(rightChar)){
                adjList.get(letter).add(rightChar);
            }
        }
        if(posCounter != 0){
            char leftChar = maze[entryCounter].charAt(posCounter - 1);
            if(isCapLetter(leftChar)){
                adjList.get(letter).add(leftChar);
            }
        }
        if(entryCounter != maze.length - 1){
            char downChar = maze[entryCounter + 1].charAt(posCounter);
            if(isCapLetter(downChar)){
                adjList.get(letter).add(downChar);
            }
        }
        if(entryCounter != 0){
            char upChar = maze[entryCounter - 1].charAt(posCounter);
            if(isCapLetter(upChar)){
                adjList.get(letter).add(upChar);
            }
        }
    }

    private boolean isCapLetter(char letter){
        if(letter >= 65 && letter <= 90){
            return true;
        }
        return false;
    }
}