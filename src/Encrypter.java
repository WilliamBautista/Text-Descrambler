import org.jasypt.util.text.*;
import java.util.ArrayList;


public class Encrypter{


    public static void main(String[] args){


        //file_write.write_file(pass, "test.txt");

       ArrayList<String> re = Writer.get_text("murr.txt");


        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        String myEncryptionPassword = "quinn99??";

        textEncryptor.setPassword(myEncryptionPassword);



        /* 
        if (myEncryptionPassword.equals(plainText)){
            System.out.println("Yes it does");

        }
        */

        
        for(String str: re) {

            String plaText = textEncryptor.decrypt(str);

            System.out.println(plaText);
  
          }
          

        //Writer.write_file(plainText + "/n", "test.txt");





            /* 
    
            System.out.println(plainText);
    
            System.out.println(myEncryptedText);

            Writer.write_file(myEncryptedText+"\n", "test.txt");

            System.out.println("True");
            */





    



    }

}
