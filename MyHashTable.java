import java.util.Arrays;

//Author Yucheng Lu 28411887
public class MyHashTable {
	
	static int TableSize = 10000000;
	//a table to store all the words
	Pair table[] = new Pair[TableSize];
	
	//function to hash string
	//@param char[] temp, such as char[] "abc"
	//will be hash into integer 123123
	public static int myhashCode(char[] temp) {
		final int prime = 43;
		int result = 1;
		int length = temp.length;
		for(int i=0;i<length;i++){
			int a = temp[i]-96;
			result = prime*result+a;
			}
		return result;
	}
	
	//return the index number of the word of the hash table
	public static int getIndex(char[] key){
		return Math.abs(myhashCode(key)%(TableSize));
	}
	
	static int hashindex;
	static Pair newPar;
	static Pair temp;
	
	//This function will insert the word Pair into the hash table
	public void insert(char[] key, String word){
		
		//the table index of the word
		hashindex = getIndex(key);
		
		newPar = new Pair(key,word);
		
		//If the element in table is empty. just add the Pair into it.
		if(table[hashindex]==null){
			table[hashindex]=newPar;
			table[hashindex].word=table[hashindex].word;
		}
		//If the element in table is not empty, check if the word is 
		//an anagram of the existing word. If they are anagram, add the 
		//word word to the current element, if not, go to next element.
		else{
			temp=table[hashindex];
			while(temp!=null){
				if(Arrays.equals(temp.key,key)){
					table[hashindex].next=1;
					table[hashindex].word=word+" "+table[hashindex].word;
					break;
				}
				else{
					hashindex++;
					temp=table[hashindex];
				}
			}
			if(table[hashindex]==null){
				table[hashindex]=newPar;
				table[hashindex].word=table[hashindex].word;}
			
		}
	}
}
