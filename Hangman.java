import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hangman {

    public static Map<String, List<String>> wordsort(char guess, List<String> words, String reveal) {
        Map<String, List<String>> map = new HashMap<>();
        String temp=reveal;
        for (String word : words) {
            int i =0;
            reveal = temp;
            for (char letter : word.toLowerCase().toCharArray()) {
                if (letter == guess) {
                    char[] revealChars = reveal.toCharArray();
                    revealChars[i] = guess;
                    reveal = String.valueOf(revealChars);
                }
                i++;
            }
            if (!map.containsKey(reveal)) {
                map.put(reveal, new ArrayList<>());
            }
            map.get(reveal).add(word);
        }
        return map;
    }


    public static Map<Integer, List<String>> wordLength(List<String> words) {
        Map<Integer, List<String>> wordsbysize = new HashMap<>();
        for (String word : words) {
            if (!wordsbysize.containsKey(word.length())) {
                wordsbysize.put(word.length(), new ArrayList<>());
            }
            wordsbysize.get(word.length()).add(word);
        }
        return wordsbysize;
    }

    public static List<String> allWords() {
        List<String> allwords = new ArrayList<>();
        File file = new File("src/dictionary.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                allwords.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allwords;
    }

    public static int largestlength() {
        int length = 5;
        for (String word : allWords()) {
            if (word.length() > length) {
                length = word.length();
            }
        }
        return length;
    }

    public static int getSize(List<Integer> sizes) {
        System.out.println("What's the size of the hidden word? Please enter an integer between 1 to 28 and there are words of that length!");
        Scanner scanner = new Scanner(System.in);
        Integer input = 99;
        while (!sizes.contains(input)) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                String k = scanner.nextLine();
            }
        }
        System.out.println("The size of the hidden word is " + input);
        return input;
    }

    public static int getGuessNum() {
        System.out.println("How many wrong guesses you get to have before you lose? Please enter an integer!");
        Scanner scanner = new Scanner(System.in);
        Integer input = 99;
        while (input.compareTo(28) > 0 || input.compareTo(0) < 0) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                String k = scanner.nextLine();
            }
        }
        System.out.println("The number of guess is " + input);
        return input;
    }

    public static boolean contains(String reveal, char guess){
        for (char letter:reveal.toCharArray()) {
            if (letter==guess){
                return true;
            }
        }
        return false;
    }

    public static char getguess(){
        System.out.println("Please choose a word.");
        Scanner scanner = new Scanner(System.in);
        char input = '{';
        while (input <'a' ||input>'z'){
            input =scanner.next().toLowerCase().charAt(0);
        }
        return input;
    }


    public static List<String> getlongest(Map<String, List<String>> map){
        List<String> newlist = new ArrayList<>();
        for (String thing:map.keySet()) {
            if (map.get(thing).size() > newlist.size()) {
                newlist = map.get(thing);
            }
        }
        return newlist;
    }

    public static String getreveal(Map<String, List<String>> map){
        List<String> newlist = new ArrayList<>();
        String reveal = "";
        for (String thing:map.keySet()) {
            if (map.get(thing).size() > newlist.size()) {
                newlist = map.get(thing);
                reveal = thing;
            }
        }
        return reveal;
    }

    public static void hangman() {
        List<String> allwords = allWords();
        Map<Integer, List<String>> map = wordLength(allwords);
        List<Integer> sizes = new ArrayList<>();
        for (Integer thing:map.keySet()) {
            sizes.add(thing);
        }
        int size = getSize(sizes);
        int guessNum = getGuessNum();
        List<Character> wrongguess= new ArrayList<>();
        List<String> list = map.get(size);
        String reveal = "";
        for (int i = 0; i < size; i++) {
            reveal=reveal+"_";
        }
        while(guessNum>0){
            char guess = getguess();
            while (wrongguess.contains(guess)|| reveal.contains(Character.toString(guess))){
                guess = getguess();
            }
            Map<String, List<String>> wordsort= wordsort(guess,list, reveal);
            list = getlongest(wordsort);
            reveal=getreveal(wordsort);
            System.out.println(reveal);
            if(!contains(reveal,guess)){
                wrongguess.add(guess);
            }
            System.out.println("Wrong Guess: " + wrongguess.toString());
            if (!contains(reveal,'_')){
                System.out.println("You Win!!!");
                break;}
            guessNum--;
            }
        String hidden = list.get(0);
        if (guessNum==0){
            System.out.println("You lose!!! The hidden word is " + hidden);
        }
    }

    public static void main(String[] args) {
        int i =0;
        while (i<2){
        System.out.println("Do you wanna play Hangman? Answer yes or no.");
        Scanner scanner = new Scanner(System.in);
        String input="";
        while (!input.toLowerCase().equals("no") && !input.toLowerCase().equals("yes")){
            input=scanner.nextLine();
        }
        if (input.toLowerCase().equals("no")){
        break;
        }
        else{hangman();
        }
        }
        System.out.println("The End");
    }
}



