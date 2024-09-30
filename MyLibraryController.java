
/*
 * This is where the rating and adding can be made.
 */
import java.util.ArrayList;

public class MyLibraryController{
	
	public class addBooks{
		/*
		 * I was thinking of nesting this class so that there would be 
		 * books added easily without the inclusion of the uneeded methods in
		 * this Controller.
		 */
		public ArrayList<String> getList(String fileName){
			try {
				ArrayList<String> library = new ArrayList<>();
				//Read the file by lines and skipping the first line if it's "Title;Author"
				return library;
			} catch{
				//If file not found...
				System.out.print("Error: File has not been found.");
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}