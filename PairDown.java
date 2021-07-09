public class PairDown {
    public int[] fold(int[] list) {
        int[] folded = new int[(list.length + 1) / 2];
        for(int i=0; i < list.length; i+=2){
            if(i+1 > list.length - 1){
                folded[i/2] = list[i];
            }
            else{
                folded[i/2] = list[i] + list[i+1];
            }
        }
        return folded;
    }
}
