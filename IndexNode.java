package indexNode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class IndexNode  {
	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list;

	IndexNode left;
	IndexNode right;
	
	
	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1

	public  IndexNode(String word, int lineNum){
		this.word = word;
		this.occurences=1;
		this.list = new ArrayList<Integer>();
		this.list.add(lineNum);
		left=null;
		right=null;

	}
	
	
	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line

	public String toString(){
		return list.toString()+"/"+occurences+" "+word;

    }
}
