import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class ReadFile {
  public static void main(String[] args) {
    ArrayList<String> writ = new ArrayList<String>();
    try {
      File myObj = new File("try.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        writ.add(data);
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println(writ);
    for(String str: writ) {
        System.out.println(str);

      }
  }
}
