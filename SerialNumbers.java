import java.util.Arrays;
import java.util.Comparator;

public class SerialNumbers {
    public String[] sortSerials(String[] numbers) {
        Serial[] serials = new Serial[numbers.length];
        for(int i=0; i < numbers.length; i++){
            serials[i] = new Serial(numbers[i]);
        }
        Comparator<Serial> byLength = Comparator.comparing(Serial::getLength);
        Comparator<Serial> bySumOfDigits = Comparator.comparing(Serial::getSumOfDigits);
        Comparator<Serial> byAlphaOrder = Comparator.comparing(Serial::getSerialCode);
        Comparator<Serial> comper = byLength.thenComparing(bySumOfDigits).thenComparing(byAlphaOrder);
        Arrays.sort(serials, comper);
        for(int j=0; j < numbers.length; j++){
            numbers[j] = serials[j].getSerialCode();
        }
        return numbers;
    }

    public class Serial{
        private int sumOfDigits, sumOfDigitsState, length;
        private String serialCode;

        public Serial(String serialCode){
            this.serialCode = serialCode;
            sumOfDigits = 0;
            sumOfDigitsState = 0;
            length = serialCode.length();
        }

        public int getSumOfDigits(){
            if(sumOfDigitsState != 0){
                return sumOfDigits;
            }
            char[] chars = serialCode.toCharArray();
            for (char symbol : chars) {
                if(Character.isDigit(symbol)){
                    sumOfDigits += symbol - '0';
                }
            }
            sumOfDigitsState++;
            return sumOfDigits;
        }
        public String getSerialCode(){
            return serialCode;
        }
        public int getLength(){
            return length;
        }
    }
}