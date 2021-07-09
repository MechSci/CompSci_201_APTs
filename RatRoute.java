import java.util.Stack;

public class RatRoute {
    private int goalX, goalY;
    private int[][] grid;
    public static final int BLOCKED = 3;
    public static final int RAT = 1;
    public static final int CHEESE = 2;
    public static final int OPEN = 0;

    public int numRoutes(String[] enc) {
        int x = 0;
        int y = 0;
        char[] symbolicRow;
        grid = new int[enc.length][enc[0].length()];
        for(int row=0; row < enc.length; row++){
            symbolicRow = enc[row].toCharArray();
            for(int pos=0; pos < enc[0].length(); pos++){
                if(symbolicRow[pos] == '.'){
                    grid[row][pos] = OPEN;
                }
                else if(symbolicRow[pos] == 'R'){
                    grid[row][pos] = RAT;
                    y = row;
                    x = pos;
                }
                else if(symbolicRow[pos] == 'C'){
                    grid[row][pos] = CHEESE;
                    goalX = pos;
                    goalY = row;
                }
                else{
                    grid[row][pos] = BLOCKED;
                }
            }
        }
        Stack<int[]> looking = new Stack<>();
        looking.push(new int[]{x, y});
        int[] currentLoc;
        boolean[] adjCells;
        int paths = 0;
        while(looking.size() != 0){
            currentLoc = looking.pop();
            int currentX = currentLoc[0];
            int currentY = currentLoc[1];
            adjCells = whichWay(currentX, currentY);
            if(currentX == goalX && currentY == goalY){
                paths++;
            }
            if(currentY != 0 && adjCells[0] && isOpen(currentX, currentY - 1)){
                looking.push(new int[]{currentX, currentY - 1});
            }
            if(currentY != enc.length - 1 && adjCells[1] && isOpen(currentX, currentY + 1)){
                looking.push(new int[]{currentX, currentY + 1});
            }
            if(currentX != 0 && adjCells[2] && isOpen(currentX - 1, currentY)){
                looking.push(new int[]{currentX - 1, currentY});
            }
            if(currentX != enc[0].length() - 1 && adjCells[3] && isOpen(currentX + 1, currentY)){
                looking.push(new int[]{currentX + 1, currentY});
            }
        }
        return paths;
    }
    private int calcDist(int x, int y){
        return Math.abs(goalY - y) + Math.abs(goalX - x);
    }
    private boolean[] whichWay(int x, int y){
        int currentDist = calcDist(x, y);
        boolean[] upDownLeftRight = new boolean[]{false, false, false, false};
        if(calcDist(x, y-1) < currentDist){
            upDownLeftRight[0] = true;
        }
        if(calcDist(x, y+1) < currentDist){
            upDownLeftRight[1] = true;
        }
        if(calcDist(x-1, y) < currentDist){
            upDownLeftRight[2] = true;
        }
        if(calcDist(x+1, y) < currentDist){
            upDownLeftRight[3] = true;
        }
        return upDownLeftRight;
    }

    private boolean isOpen(int x, int y){
        if(grid[y][x] == BLOCKED){
            return false;
        }
        return true;
    }
}
