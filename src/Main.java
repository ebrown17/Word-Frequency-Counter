import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {
	
	
	
	 
	 public static void main(String[] args) throws FileNotFoundException {
	    	
	    	SetFileLocation name = new SetFileLocation();	
			System.out.println("Enter location to get files from: ");		 
			 
		   	 try{
		   		 BufferedReader readBuf = new BufferedReader(new InputStreamReader(System.in));	   		 	
		   		 String folderLoc= readBuf.readLine();	   		 
		   		 name.setFileLocation(folderLoc);
		   		 
		   	 }
		   	 catch(IOException e)
		   	 {
					e.printStackTrace();
		   	 }      	 
	   	     	 
		   	 String[] listFiles = GetFileLocation.listFiles(name.getFileLocation());
	   	 
		   	
	   	
		   	 for(int i =0; i<listFiles.length;i++){
	   		 
		   		 listFiles[i]=name.getFileLocation().concat("\\" + listFiles[i]); 	
		   	 }
	   	
		   	 name.setFulFileLoc(listFiles);
		   	 
	    	
		   	 
		    ArrayList<String> list = new ArrayList<String>();
		    int wordcount =0;
		    for(int i=0;i<listFiles.length;i++){
		   		
		   		
		   		Scanner in = new Scanner(new File(name.getFulFileLoc()[i]));
		   		
		       
		        while (in.hasNext()) {
		        	String word = in.next();
		        	wordcount++;
		        	word = word.toLowerCase();
		        	if(word.startsWith(".")||word.endsWith("."))word = word.replace(".","");
		        	if(word.startsWith(",")||word.endsWith(","))word = word.replace(",","");
		        	if(word.startsWith(".")||word.endsWith("."))word = word.replace(".","");
		        	if(word.startsWith(":")||word.endsWith(":"))word = word.replace(":","");
		        	if(word.startsWith("(")||word.endsWith("("))word = word.replace("(","");
		        	if(word.startsWith(")")||word.endsWith(")"))word = word.replace(")","");
		        	
		        	///// filter out words these words      /////////////
		        	if(!(word.equals("and")||word.equals("for")||word.equals("to")||word.equals("at")||word.equals("in")||word.equals("of"))){
		        	 list.add(word);
		        	}	        		        	
		        	
		        	
		        	
		        	
		        }in.close();
		   
		   	}
	        int unqWord = 0;
	        Word[] frequency = new WordList().getFrequentWords(list);
	        for(Word w:frequency){
	        	unqWord++;
	        	if(w.count>=15){
	            System.out.println(w.word+" = "+w.count);}
	        }System.out.println("There are " + unqWord + " unique words and "+ wordcount + " total words.");
	    }
	
	
	
	

}
