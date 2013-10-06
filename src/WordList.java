import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WordList {
	
	 public Word[] getFrequentWords(ArrayList<String> list2){
		 
	        HashMap<String,Word> map = new HashMap<String,Word>();
	        for(String s:list2){
	            Word w = map.get(s);
	            if(w==null)
	                w = new Word(s,1);
	            else
	                w.count++;
	            map.put(s, w);
	        }
	        Word[] list = map.values().toArray(new Word[]{});
	        Arrays.sort(list);
	        return list;
	  }

}
