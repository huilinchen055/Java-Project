import java.util.*;
public class InsertionSort {
    static int compCounter = 0;
    static int exchangeCounter = 0;

    public static <T extends Comparable<T>> List<T> insertionsort(List<T> list){
        if(list.size()<= 1 ){
            return list;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            T key = list.get(i);
            int j=i-1;
            while(key.compareTo(list.get(j))<0 && j>0){
                Collections.swap(list, j+1,j);
                list.set(j,key);
                j--;
                exchangeCounter++;
                compCounter++;
            }
            if (j!=0){
                compCounter++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int compsum=0;
        int exchangesum=0;
        int time =0;
        for (int j = 0; j < 100 ; j++) {
            List<Integer> list=new ArrayList<Integer>();
            int i =0;
            while(i<10000){
                list.add(new Random().nextInt());
                i++;
            }
            long start = System.currentTimeMillis();
            System.out.println(insertionsort(list));
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

