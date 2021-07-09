import java.util.LinkedList;
import java.util.Queue;

public class FloodRelief {
    private int[][] startGrid;
    private int[][] calcGrid;
    public static final int FILLED = 1;
    private Queue<int[]> bfsHelp = new LinkedList<>();
    int lowestOpenCurr = 'a';

    public int minimumPumps(String[] heights){
        int minPumps = 0;
        startGrid = new int[heights.length][heights[0].length()];
        for(int row = 0; row < heights.length; row++){
            char[] currentRow = heights[row].toCharArray();
            for(int col = 0; col < heights[0].length(); col++){
                startGrid[row][col] = currentRow[col];
            }
        }
        calcGrid = new int[startGrid.length][startGrid[0].length];

        while(! isFullyCovered()){
            blobFill();
            minPumps++;
        }
        return minPumps;
    }
    private void blobFill(){
        bfsHelp.add(findNextLowest());
        int[] currentCell = bfsHelp.peek();
        calcGrid[currentCell[0]][currentCell[1]] = FILLED;
        while(bfsHelp.size() != 0){
            currentCell = bfsHelp.poll();
            int currRow = currentCell[0];
            int currCol = currentCell[1];
            boolean[] upDownLeftRight = canCover(currRow, currCol);
            if(upDownLeftRight[0] && calcGrid[currRow - 1][currCol] == 0){
                bfsHelp.add(new int[]{currRow - 1, currCol});
                calcGrid[currRow - 1][currCol] = FILLED;
            }
            if(upDownLeftRight[1] && calcGrid[currRow + 1][currCol] == 0){
                bfsHelp.add(new int[]{currRow + 1, currCol});
                calcGrid[currRow + 1][currCol] = FILLED;
            }
            if(upDownLeftRight[2] && calcGrid[currRow][currCol - 1] == 0){
                bfsHelp.add(new int[]{currRow, currCol - 1});
                calcGrid[currRow][currCol - 1] = FILLED;
            }
            if(upDownLeftRight[3] && calcGrid[currRow][currCol + 1] == 0){
                bfsHelp.add(new int[]{currRow, currCol + 1});
                calcGrid[currRow][currCol + 1] = FILLED;
            }
        }
    }
    private boolean[] canCover(int row, int col){
        boolean[] upDownLeftRight = new boolean[4];
        if(inBounds(row - 1, col) && startGrid[row - 1][col] >= startGrid[row][col]){
            upDownLeftRight[0] = true;
        }
        if(inBounds(row + 1, col) && startGrid[row + 1][col] >= startGrid[row][col]){
            upDownLeftRight[1] = true;
        }
        if(inBounds(row, col - 1) && startGrid[row][col - 1] >= startGrid[row][col]){
            upDownLeftRight[2] = true;
        }
        if(inBounds(row, col + 1) && startGrid[row][col + 1] >= startGrid[row][col]){
            upDownLeftRight[3] = true;
        }
        return upDownLeftRight;
    }
    private int[] findNextLowest(){
        int currentMin = 130;
        int[] lowest = new int[2];
        for(int row = 0; row < startGrid.length; row++){
            for(int col = 0; col < startGrid[0].length; col++){
                if(startGrid[row][col] == lowestOpenCurr && calcGrid[row][col] == 0){
                    lowest[0] = row;
                    lowest[1] = col;
                    return lowest;
                }
                if(startGrid[row][col] < currentMin && calcGrid[row][col] == 0){
                    lowest[0] = row;
                    lowest[1] = col;
                    currentMin = startGrid[row][col];
                }
            }
        }
        lowestOpenCurr = currentMin;
        return lowest;
    }

    private boolean isFullyCovered(){
        for(int row = 0; row < startGrid.length; row++){
            for(int col = 0; col < startGrid[0].length; col++){
                if(calcGrid[row][col] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean inBounds(int row, int col){
        if(row < 0){
            return false;
        }
        if(row >= startGrid.length){
            return false;
        }
        if(col < 0){
            return false;
        }
        if(col >= startGrid[0].length){
            return false;
        }
        return true;
    }
}