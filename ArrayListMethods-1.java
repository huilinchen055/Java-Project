import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods {

    public static <E> boolean unique(List<E> list) {
        for (int i = 0; i<list.size();i++){
            for (int j=0; j<list.size();j++){
                E temp =list.get(i);
                if (temp.equals (list.get(j)))
                        return false;
            }
        }
    return true;}

    public static List<Integer> allMultiples(List<Integer> list, int mul){
        List<Integer> newList = new ArrayList<>();
        for (int i =0; i< list.size();i++){
            if (list.get(i) % mul == 0){
            newList.add(list.get(i));}
        }
        return newList;
    }

    public static List<String> allStringOfSize(List<String> list, int length){
        List<String> newList = new ArrayList<>();
        for (int i =0; i< list.size();i++){
            String temp = list.get(i);
            if (temp.length()==length){
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    public static List<String> stringToListOfWords(String words){
        List<String> list= new ArrayList<>();
        String[] arr = words.split(" ", -1);
        for (String a : arr){
            if (!a.equals(" "))
            {list.add(a);}}
        return list;
    }

    public static <E> void removeALLInstances(List<E> list, E item) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item)) {
                list.remove(item);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item)) {
                list.remove(item);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> listt = new ArrayList<>();
        listt.add(1);
        listt.add(25);
        listt.add(2);
        listt.add(5);
        listt.add(30);
        listt.add(19);
        listt.add(57);
        System.out.println(allMultiples(listt,5));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(5);
        list.add(5);
        list.add(2);
        removeALLInstances(list,5);
        System.out.println(list);
        System.out.println(unique(list));
        List<String> newList = new ArrayList<>();
        newList.add("I");
        newList.add("like");
        newList.add("to");
        newList.add("eat");
        newList.add("eat");
        newList.add("eat");
        newList.add("apples");
        newList.add("and");
        newList.add("bananas");
        System.out.println(allStringOfSize(newList, 3));
        System.out.println(stringToListOfWords("What's your name? I like that!"));
        long start = System.currentTimeMillis();
        stringToListOfWords("What's your name? I like that!");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
