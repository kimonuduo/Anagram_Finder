//Author Yucheng Lu 28411887

public class Pair {
	
	//key is the sorted word
	char[] key;
	//word is one line in input
	String word;
	//a boolean if word is anagram
	int next;
	
	public Pair(char[] key, String word){
		this.key=key;
		this.word=word;
		next=0;
	}

}
