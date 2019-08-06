import java.util.*;


public class Mergesort {
    static int compCounter = 0;
    static int exchangeCounter = 0;

    public static <T extends Comparable<T>> List<T> mergesort(List<T> list){
        if(list.size()<= 1 ){
            return list;
        }
        int size = list.size();
        List<T> left = new ArrayList<T>();
        for (int i = 0; i < size/2; i++) {
            left.add(list.get(i));
        }
        List<T> right = new ArrayList<T>();
        for (int i = size/2; i < size; i++) {
            right.add(list.get(i));
        }
        left = mergesort(left);
        right = mergesort(right);
        int i =0;
        int j=0;
        List<T> newlist=new ArrayList<T>();
        int k =0;
        while (i<size/2 ||j<size-size/2){
            if(i<size/2 && j<size-size/2 && left.get(i).compareTo(right.get(j))<0){
                newlist.add(left.get(i));
                i++;
                compCounter+=1;
            }
            else if(i<size/2 && j<size-size/2 && left.get(i).compareTo(right.get(j))>=0){
                newlist.add(right.get(j));
                j++;
                compCounter+=1;
            }
            else if (i>=size/2 && j<size-size/2){
                while (j<size-size/2){
                    newlist.add(right.get(j));
                    j++;
                }
            }
            else{
                while(i<size/2){
                    newlist.add(left.get(i));
                    i++;
                }
            }
            if(!list.get(k).equals(newlist.get(k))){
                exchangeCounter+=1;//merge sort creates an extra list. So no actual exchange is needed.
            }
            k++;
        }
        return newlist;
    }


    public static void main(String[] args) {
        //for i = 10 ; i <= 1000; i= i*10
        //make list(i)
        //Testing list of size 10: Need to test on 100 different lists of size 10
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
            System.out.println(mergesort(list));
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
