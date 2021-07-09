public class PellSequence {
    public String isPellLike(int[] seq){
        boolean state = true;
        int exp;
        for(int i=2; i < seq.length; i++){
            exp = 2*seq[i-1] + seq[i-2];
            if(seq[i] != exp){
                return "No";
            }
        }
        return "Yes";
    }
}
