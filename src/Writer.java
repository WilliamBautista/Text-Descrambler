import java.io.File;
import java.io.FileWriter;  
import java.io.BufferedWriter; 
import java.io.IOException; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;  

public class Writer{

    public static boolean create_file(String file_name){
        try{
            File new_file = new File(file_name);
            if (new_file.createNewFile()) {
                System.out.println("\nA file has been created!\n");
                return true;
              } else {
                System.out.println("\nA file already exists!\n");
                return false;

              }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
            return false;
        }
        
    }

    public static void write_file(String text,String file){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            BufferedWriter buffer = new BufferedWriter(myWriter);
            buffer.write(text);
            buffer.close();

          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static void empty(String file){
      try{
        PrintWriter wri = new PrintWriter(file);
        wri.close();
        }catch(Exception e){

          System.out.println("An error occured");

        }

    }

    public static ArrayList<String> get_text (String file){
      ArrayList<String> writ = new ArrayList<String>();
      try {
        File myObj = new File(file);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          writ.add(data);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      return writ;

    }
