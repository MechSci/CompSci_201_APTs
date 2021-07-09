import java.util.ArrayList;

public class WorkerNode {
    public int info;
    public int index;
    public WorkerNode up;
    public ArrayList<WorkerNode> down;

    public WorkerNode(int val, int i, WorkerNode supervisor, ArrayList<WorkerNode> subordinate){
        info = val;
        this.index = i;
        this.up = supervisor;
        this.down = subordinate;
    }
    public WorkerNode(int i){
        this(0, i, null, null);
    }
    public WorkerNode(){
        this(0, 0, null, null);
    }
}
