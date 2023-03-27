import org.jasypt.util.text.*;
import java.util.ArrayList;

public class Encrypter{

    public static ArrayList<String> de_list (ArrayList <String> list, String pass){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        ArrayList<String> writ = new ArrayList<String>();

        textEncryptor.setPassword(pass);

        for(String str: list) {
            String deText = textEncryptor.decrypt(str);
            writ.add(deText);
          }
          return writ;
    }
}
