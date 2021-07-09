import java.util.*;

public class SpreadingNews {
    int numPeople;
    Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    public int minTime(int[] supervisors){
        numPeople = supervisors.length;
        for(int i=0; i < numPeople; i++){
            adjList.put(i, new ArrayList<>());
        }

        makeList(supervisors);

        int[] timeToSpread = new int[numPeople];
        for(int i=0; i < numPeople; i++){
            timeToSpread[i] = -1;
        }

        while(timeToSpread[0] == -1){
            for(int i=0; i < numPeople; i++){
                if(allKnown(i, timeToSpread) && timeToSpread[i] == -1){
                    if(adjList.get(i).size() == 0){
                        timeToSpread[i] = 0;
                    }
                    else{
                        timeToSpread[i] = calcSpread(i, timeToSpread);
                    }
                }
            }
        }
        return timeToSpread[0];
    }
    private void makeList(int[] workOrder){
        for(int i=1; i < numPeople; i++){
            adjList.get(workOrder[i]).add(i);
        }
    }
    private int calcSpread(int index, int[] timeToSpread){
        int numSubs = adjList.get(index).size();
        int[] sortTimes = new int[numSubs];
        for(int i=0; i < numSubs; i++){
            sortTimes[i] = timeToSpread[adjList.get(index).get(i)];
        }
        Arrays.sort(sortTimes);
        int maxVal = 0;
        for(int i=0; i < numSubs; i++){
            sortTimes[i] += numSubs - i;
            if(maxVal < sortTimes[i]){
                maxVal = sortTimes[i];
            }
        }
        return maxVal;
    }

    private boolean allKnown(int index, int[] timeToSpread){
        if(adjList.get(index).size() == 0){
            return true;
        }
        for (Integer sub : adjList.get(index)) {
            if(timeToSpread[sub] == -1){
                return false;
            }
        }
        return true;
    }
}

    /*
    private int numWorkers;
    boolean[] prevState;
    boolean[] currentState;
    boolean[] alreadyCalling;

    public static void main(String[] args) {
        int[] supervisors = {-1, 0, 0, 2, 2};
        SpreadingNews test = new SpreadingNews();
        test.minTime(supervisors);
    }

    public int minTime(int[] supervisors) {
        numWorkers = supervisors.length;
        prevState = new boolean[numWorkers];
        currentState = new boolean[numWorkers];
        alreadyCalling = new boolean[numWorkers];
        prevState[0] = true;
        currentState[0] = true;
        int time = 0;
        while(! isAllTrue()){
            passTime(supervisors);
            time++;
        }
        return time;
    }
    private void passTime(int[] supervisors){
        int indexSuper;
        for(int i=1; i < numWorkers; i++){
            if(! prevState[i]){
                indexSuper = supervisors[i];
                if(prevState[indexSuper] && ! alreadyCalling[indexSuper]){
                    currentState[i] = true;
                    alreadyCalling[indexSuper] = true;
                }
            }
        }
        for(int i=0; i < numWorkers; i++){
            alreadyCalling[i] = false;
        }
        for(int i=1; i < numWorkers; i++){
            prevState[i] = currentState[i];
        }
    }

    private boolean isAllTrue(){
        for (boolean state : currentState) {
            if(! state){
                return false;
            }
        }
        return true;
    }
    private WorkerNode makeTree(int[] supervisors){
        WorkerNode root = new WorkerNode(0);
        int currRefInd = 0;
        for(int ind=1; ind < numWorkers; ind++){
            if(supervisors[ind] == currRefInd){
                if(root.down == null){
                    root.down = new ArrayList<>();
                    root.down.add(new WorkerNode())
                }
            }
        }
    }
}

     */