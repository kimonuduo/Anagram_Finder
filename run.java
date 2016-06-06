import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Author Yucheng Lu 28411887

public class run {

	//This function is used to sort a word alphabetically
	//@param String a, such as "cba", will be sorted to "abc"
	//@return a char array of sorted String a 
	static char[] SortWord(String a){
		int length = a.length();
		char[] chartemp= new char[length];
		for(int i=0; i<length; i++){
			chartemp[i] = a.charAt(i);
		}
		char tmp;
		for(int j=0; j<length-1; j++){
			for(int k=0; k<length-j-1; k++){
				if(chartemp[k]>chartemp[k+1]){
					tmp=chartemp[k];
					chartemp[k]=chartemp[k+1];
					chartemp[k+1]=tmp;
				}
			}
		}
		return chartemp;
	}
	
	//Main function starts here
    public static void main(String args[]) throws IOException {
    	
    	//initialize a new hash table
    	MyHashTable newtable = new MyHashTable();
    	String path = args[0];
    	//initialize a new buffer reader
    	BufferedReader br = new BufferedReader(new FileReader(path));
    	
    	//templine is used to keep tracking every line of input
    	String templine;
    	
    	//while get a line,insert the line to hashtable
		while  ((templine=br.readLine())!=null) {
			newtable.insert(SortWord(templine),templine);
		}
		//close reading
		br.close();
		
		//begin writing
    	BufferedWriter bw = null;
    	FileWriter fw=null;
    	
    	//check the input file name
    	String output = "output";
    	if(path.equals("dict1")){
    		output="anagram1";
    	}
    	if(path.equals("dict2")){
    		output="anagram2";
    	}
    	File out = new File(output);
    	fw=new FileWriter(out);
    	bw = new BufferedWriter(fw);
    	
    	//Iterate through the hash table, if the element in table
    	//is not null, then write the line to output file
    	for(int a = 0;a<MyHashTable.TableSize;a++){
    		if(newtable.table[a]!=null){
    				//check if there is any empty line
    				if(newtable.table[a].word.equals("")){
    					continue;
    				}
    				bw.write(newtable.table[a].word);
    				bw.write("\n");	
    		}
    	}
    	bw.close();	    
    }
}