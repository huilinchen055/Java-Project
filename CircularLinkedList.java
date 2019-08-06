package LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class CircularLinkedList {
    private Node<Integer> head;
    private Node<Integer> tail;
    private int size = 0;


    public CircularLinkedList(){
        head = null;
        tail = null;
        size =0;
    }

    public boolean add(int item){
        this.add(size,item);
        return true;
    }

    public Integer get(int index){
        if(index < 0){ //O(1)
            throw new IndexOutOfBoundsException("Not a valid index :(");
        }
        return getNode(index).item;
    }

    public Integer set(int index,int item){
        if(index < 0){ //O(1)
            throw new IndexOutOfBoundsException("Not a valid index :(");
        }
        Node<Integer> node = getNode(index); //O(n)
        int toReturn =node.item;
        node.item= item;
        return getNode(index).item;
    }

    public void add(int index, Integer item){
        //Scenario 1: Out of bounds
        if (index < 0){
            throw new IndexOutOfBoundsException("Aren't we tired of errors?");
        }
        Node<Integer> temp = new Node<Integer>(item);
        // Scenario 2: Adding the very first item with the item size 0
        if (size ==0){
            this.head = temp;
            this.tail = temp;
            temp.next=head;
        }
        // Scenario 3: Adding a new head
        else if (index ==0){
            temp.next = head;
            head = temp;
            tail.next = temp;
        }
        // Scenario 4: Adding a new tail
        else if (index == size){
            tail.next = temp;
            temp.next = head;
            tail = temp;
        }
        // Scenario 5: Any other case
        else {
            Node<Integer> before = this.getNode(index-1);
            temp.next = before.next;
            before.next = temp;
        }
        size++;
    }

    public int remove(int index){
        int toReturn = 0;
        // out of bounds
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Can't remove that.");
        }

        //removing the head
        if (index==0){
            toReturn = head.item;
            head = head.next;
            tail.next=head;
        }

        //removing any other index
        else{
            Node<Integer> before = getNode(index-1);
            toReturn = before.next.item;
            before.next = before.next.next;

        }

        size--;
        return toReturn;
    }

    private Node<Integer> getNode(int index){ //O(n) I have manually walk to it since there is no index
        Node<Integer> current = head;
        for (int i =0; i< index; i++){
            current = current.next;
        }
        return current;
    }

    public void swap(int a, int b){
        int first= getNode(a).item;
        int second = getNode(b).item;
        set(a, second);
        set(b, first);
    }

    public int size(){ //O(1)
        return this.size;
    }

    private static class Node<Integer>{
        int item;
        Node<Integer> next;

        public Node(int item) {this.item=item;}
    }

    public int find1stJoker(CircularLinkedList l) {
        Node Current = l.head;
        int i = 0;
        while (Current.item != 27 && Current.item != 28) {
            Current=Current.next;
            i++;
        }
        return i;
    }

    public int find2ndJoker(CircularLinkedList l){
        Node Current = l.getNode(find1stJoker(l)+1);
        int i = find1stJoker(l)+1;
        while (Current.item != 27 && Current.item != 28) {
            Current=Current.next;
            i++;
        }
        return i;
    }

    public CircularLinkedList tripleCut (CircularLinkedList l){
        if (find1stJoker(l) == 0 || find2ndJoker(l) == l.size-1){
        }
        else if (find1stJoker(l)==0){
            l.tail.next = l.head;
            Node Current = l.getNode(find2ndJoker(l));
            l.head = Current.next;
            l.tail=Current;
        }
        else if (find2ndJoker(l)==l.size-1){
            l.tail = l.getNode(find1stJoker(l)-1);
            l.head = l.getNode(find1stJoker(l));
        }
        else {
           Node newhead = l.getNode(find2ndJoker(l)).next;
           Node newtail = l.getNode(find1stJoker(l)-1);
           tail.next = l.getNode(find1stJoker(l));
           l.getNode(find2ndJoker(l)).next = l.head;
           l.tail = newtail;
           l.head = newhead;
           tail.next=head;
        }
        return l;
    }



    public static CircularLinkedList deckMaker() {
        CircularLinkedList l = new CircularLinkedList();
        l.add(0, 1);
        l.add(1, 4);
        l.add(2, 7);
        l.add(3, 10);
        l.add(4, 13);
        l.add(5, 16);
        l.add(6, 19);
        l.add(7, 22);
        l.add(8, 25);
        l.add(9, 28);
        l.add(10, 3);
        l.add(11, 6);
        l.add(12, 9);
        l.add(13, 12);
        l.add(14, 15);
        l.add(15, 18);
        l.add(16, 21);
        l.add(17, 24);
        l.add(18, 27);
        l.add(19, 2);
        l.add(20, 5);
        l.add(21, 8);
        l.add(22, 11);
        l.add(23, 14);
        l.add(24, 17);
        l.add(25, 20);
        l.add(26, 23);
        l.add(27, 26);
        return l;
    }

    public static CircularLinkedList getKey(CircularLinkedList l){
        for (int i= 0; i <l.size;i++) {
            if (l.getNode(i).item == 27)
            {l.swap(i,i+1);
                break;}
        }

        for (int i= 0; i <l.size;i++) {
            if (l.getNode(i).item == 28)
            {l.swap(i,i+2);
                l.swap(i,i+1);
                break;}
        }
        l.tripleCut(l);

        int botton = l.get(l.size-1);
        for (int i=0;i<botton;i++){
            l.add(l.size-1,l.get(0));
            l.remove(0);
        }
        return l;
    }

    public static int[] generateKey(int length){
        int[] keys = new int [length];
        CircularLinkedList l = getKey(deckMaker());
        int top = l.get(0);
        int key = l.get(top);
        keys[0]=key;
        for (int i =1; i < length;i++){
            l = getKey(l);
            key = l.get(l.get(0));
            keys[i]=key;
        }
        return keys;
    }
    public static void encryption() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please enter a message to encrypt");
        String input = scanner.nextLine();
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-z]","");
        //int[] keyStream = generateKey(input.length());
        int [] keyStream = {21,6,2,19,15,18,12,23,23,5,1,7,14,6,13,1,26,16,12,20};
        int addOn = input.length() % 5;
        for (int i =0; i< 5-addOn;i++){
            input=input+"X";
        }
        int[] encrypted = new int[input.length()];
        for (int i = 0; i<input.length();i++){
            char c = input.charAt(i);
            int newC = c -'A' + 1;
            if ((newC + keyStream[i]) % 26 ==0){
                encrypted[i] = 26;
            }
            else {
                encrypted[i]= (newC + keyStream[i]) % 26; }
        }
        String newMessage = "";
        for (int i =0; i<encrypted.length;i++){
            char newA = (char)(encrypted[i]+'A'-1);
            newMessage = newMessage + newA;
        }
        System.out.println(newMessage);
    }

    public static void decryption(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please enter a message to decrypt");
        String input = scanner.nextLine();
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-z]","");
        System.out.println(input);
        //int[] keyStream = generateKey(input.length());
        int [] keyStream = {21,6,2,19,15,18,12,23,23,5,1,7,14,6,13,1,26,16,12,20};
        int[] encrypted = new int[input.length()];
        for (int i = 0; i<input.length();i++){
            char c = input.charAt(i);
            int newC = c -'A' + 1;
            if (newC - keyStream[i] <=0){
                encrypted[i] = 26+newC - keyStream[i];
            }
            else {
                encrypted[i]= newC - keyStream[i];}
        }
        String newMessage = "";
        for (int i =0; i<encrypted.length;i++){
            char newA = (char)(encrypted[i]+'A'-1);
            newMessage = newMessage + newA;
        }
        System.out.println(newMessage);
    }

    public static void main(String[] args) {
        encryption();
        decryption();
    }

}
