public class Totality{
    public int sum(int[] a, String stype) {
        int oddTotal = 0;
        int evenTotal = 0;
        for(int i=0; i<a.length; i++){
            if(i%2 == 1){
                oddTotal += a[i];
            }
            else{
                evenTotal += a[i];
            }
        }
        if(stype.equals("odd")){
            return oddTotal;
        }
        else if(stype.equals("even")){
            return evenTotal;
        }
        else{
            return evenTotal + oddTotal;
        }
    }
}
