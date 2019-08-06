import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class LookingOutForNumber1 {

    public static int countDigits(int num){
        int digit = 0;
        while (num != 0) {
            num /= 10;
            digit += 1;
        }
        return digit;
    }

    public static int nthDigitBack(int n, int num){
        int divisions =0;
        while(divisions < n){
            num/=10;
            divisions++;
        }
        return num % 10;
    }

    public static int nthDigit(int n , int num) {
        return nthDigitBack( countDigits(num) -( n+1) ,num);
    }

    public static void updateTally(int n, int num, int[] tally) {
        int digit = nthDigit(n,num);
        tally[digit] +=1;

    }

    public static int[] nthDigitTally(int n, int[] nums) {
        int[] tally = new int[10];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            updateTally(n,num,tally);
        }
        return tally;
    }

    public static void readMysteriousNumbers(int [] Tally) {
        File target = new File("inputFile.txt");
        try {
            Scanner scanner = new Scanner(target);
            int i = 0;
            while (scanner.hasNextLine()) {
                Tally[i] = Integer.parseInt(scanner.nextLine());
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        int[] Tally = new int[1879];
        readMysteriousNumbers(Tally);
        System.out.println(Arrays.toString(nthDigitTally(1,Tally)));

    }


}
