import java.util.*;

public class Quicksort {
    static int compCounter = 0;
    static int exchangeCounter = 0;

    public static <T extends Comparable<T>> List<T> quicksort(List<T> list){
        if(list.size()<= 1 ){
            return list;
        }
        T pivot = list.get(0);
        List<T> left = new ArrayList<T>();
        List<T> right = new ArrayList<T>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(pivot)<0){
                left.add(list.get(i));
                exchangeCounter+=i;
                compCounter+=i;
            }
            else {
                right.add(list.get(i));
                compCounter+=1;
            }
        }
        left=quicksort(left);
        right=quicksort(right);
        for (int i = 0; i < left.size(); i++) {
            list.set(i,left.get(i));
        }
        list.set(left.size(),pivot);
        for (int i = 0; i < right.size(); i++) {
            list.set(i+left.size()+1,right.get(i));
        }
        return list;
    }
    public static void main(String[] args) {
        long compsum=0;
        long exchangesum=0;
        int time =0;
        for (int j = 0; j < 100 ; j++) {
            List<Integer> list=new ArrayList<Integer>();
            int i =0;
            while(i<10000){
                list.add(new Random().nextInt());
                i++;
            }
            long start = System.currentTimeMillis();
            System.out.println(quicksort(list));
            long end = System.currentTimeMillis();
            time += end-start;
            compsum += compCounter;
            exchangesum += exchangeCounter;
        }
        System.out.println(exchangesum/100);
        System.out.println(compsum/100);
        System.out.println(time/100);
    }
}
