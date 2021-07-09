public class VoteRigging {
    public int minimumVotes(int[] votes) {
        int winner = findMax(votes);
        int changed = 0;
        while(winner != 0){
            changed++;
            votes[0]++;
            votes[winner]--;
            winner = findMax(votes);
        }
        return changed;
    }

    private int findMax(int[] votes){
        int maxIndex = -1;
        int max = -1;
        for(int i=0; i < votes.length; i++){
            if(votes[i] >= max){
                maxIndex = i;
                max = votes[i];
            }
        }
        return maxIndex;
    }
}
