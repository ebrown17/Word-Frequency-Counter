import java.io.File;


public class GetFileLocation {
	
	public static String[] listFiles(String folderLoc) {			
	   	
  		 File folder = new File(folderLoc);   	 
  		 File[] listOfFiles = folder.listFiles();
  		 int numOfFiles = listOfFiles.length ;
  		 String[] fileArray= new String[numOfFiles];
  		 
  		for (int i = 0; i < listOfFiles.length; i++) {
		      if ((listOfFiles[i].isFile()) ) {
		    	 
		        fileArray[i]=listOfFiles[i].getName();	        
		    	
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Looking in directory " + listOfFiles[i].getName());
		      }
		    }   		
  	 
  	return fileArray;
  	 
	}	

}
