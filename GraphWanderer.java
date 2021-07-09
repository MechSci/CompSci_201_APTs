import java.util.*;

public class GraphWanderer {
    public int pathLength(String[] connections, int start){
        Set<Integer> visited = new HashSet<>();
        Map<Integer, TreeSet<Integer>> adjList = new HashMap<>();

        String[] connectedVertices;
        TreeSet<Integer> currentList;
        for(int vertex = 0; vertex < connections.length; vertex++){
            connectedVertices = connections[vertex].split(" ");
            adjList.put(vertex, new TreeSet<>());
            currentList = adjList.get(vertex);
            for (String connectedVertex : connectedVertices) {
                currentList.add(Integer.parseInt(connectedVertex));
            }
        }

        Stack<Integer> dfsHelp = new Stack<>();
        dfsHelp.push(start);
        boolean state = true;
        int current;
        int visitCount = 0;
        NavigableSet<Integer> currentConnects;
        while(dfsHelp.size() != 0 && state){
            state = false;
            current = dfsHelp.pop();
            visitCount++;
            visited.add(current);
            currentConnects = adjList.get(current).descendingSet();
            for (Integer currentConnect : currentConnects) {
                if(! visited.contains(currentConnect)){
                    dfsHelp.push(currentConnect);
                    state = true;
                }
            }
        }
        return visitCount;
    }
}
