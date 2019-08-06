package indexNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	
	// Make your constructor
	// It doesn't need to do anything

	public IndexTree(){}



	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		this.root = add(this.root,word,lineNumber);
	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if (root==null){
			return new IndexNode(word, lineNumber);
		}
		else if (word.compareTo(root.word)==0){
			root.list.add(lineNumber);
			root.occurences++;
			return root;
		} else if (word.compareTo(root.word)<0){
			root.left=add(root.left, word, lineNumber);
			return root;
		} else{
			root.right=add(root.right, word, lineNumber);
			return root;
		}
	}
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
		if (word.compareTo(root.word)==0){
			return true;
		}
		return false;
	}
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		this.root=delete(this.root,word);
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word){
		if(root==null){
			//item is not in the tree
			return root;
		}
		//Search for item to delete
		if(word.compareTo(root.word)<0){
			root.left=delete(root.left,word);
			return root;
		} else if (word.compareTo(root.word)>0){
			root.right=delete(root.right,word);
			return root;
		}else{
			if(root.left==null){
				return root.right;
			}else if (root.right ==null){
				return root.left;
			}else{
				if(root.left.right ==null){
					root.word = root.left.word;
					root.left=root.left.left;
					return root;
				}else{
					root.word=findLargestChild(root.left);
					return root;
				}
			}
		}
	}

	private String findLargestChild(IndexNode parent){
		if(parent.right.right==null){
			String returnValue = parent.right.word;
			parent.right=parent.right.left;
			return returnValue;
		} else{
			return findLargestChild(parent.right);
		}
	}
	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(IndexNode root){
		if (root==null){
			return;
		}
		printIndex(root.left);
		System.out.println(root.toString());
		printIndex(root.right);
	}

	public void printIndex(){
		printIndex(this.root);
	}
	
	public static void main(String[] args){
		IndexTree index = new IndexTree();
		
		// add all the words to the tree
		
		// print out the index
		
		// test removing a word from the index

		File file =new File("src/shake.txt");
		try{
			Scanner sc = new Scanner(file);
			int lineNum =0;
			while(sc.hasNextLine()){
				String line = sc.nextLine().toLowerCase();
				lineNum++;
				String [] words = line.split("\\s+");
				for(String word : words){
						word = word.replaceAll("[^a-zA-Z]","");
					index.add(word,lineNum);
					}
				}
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		index.printIndex();
	}
	}

