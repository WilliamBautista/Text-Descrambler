import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import org.jasypt.util.text.*;
import java.io.File;

public class Main {

  public static void main(String[] args) {

    String pass, f_name, choice, change, line;
    int num;
    Scanner input = new Scanner(System.in);
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    ArrayList < String > writ = new ArrayList < String > ();
    ArrayList < String > detext = new ArrayList < String > ();

    System.out.println("******************************************************\n");

    System.out.println("Hello welocome to the the file encrypter writer.\nPress enter to begin!");
    System.out.println("If you would like to gain access to a file, please enter: View\n");
    System.out.println("If you would like to quit the program, please type: No\n");

    System.out.println("******************************************************\n");

    choice = input.nextLine().toUpperCase();

    if (choice.toUpperCase().equals("NO")) {
      System.out.println("Ok goodbye!");
      System.exit(0);
    } else if (choice.toUpperCase().equals("VIEW")) {

      System.out.println("Please enter the name of the file. Do not include file ending.\n");

      f_name = input.nextLine() + ".txt";

      while (!new File("directory" + f_name).isFile()) {

        System.out.print("Please try again with a different name.\n\n");
        f_name = input.nextLine() + ".txt";

      }
      System.out.print("File name is accepted.\n");

      writ = Writer.get_text(f_name);

      System.out.print("Please enter the password of the file you want to accesss.\n");

      pass = input.nextLine();

      detext = Encrypter.de_list(writ, pass);

      int i = 0;

      try {
        for (String str: detext) {
          System.out.println(i + " " + str);
          i++;
        }
      } catch (Exception e) {
        System.out.println("Error: password is incorrect. Program will shut down");
        System.exit(0);
      }
      System.out.println("\nIf you woulld like to edit the file " +
        "you will have to provide the line of the file edit\nOtherwise type" +
        " Done to finish viewing");
      choice = input.nextLine();

      while (!choice.toUpperCase().equals("DONE")) {

        i = 0;

        for (String str: detext) {
          System.out.println(i + " " + str);
          i++;
        }
        System.out.println("\nPlease select a line number from the ones listed above");
        try {
          num = input.nextInt();

        } catch (InputMismatchException e) {
          System.out.println("Input is not a number please try again!");
          num = input.nextInt();
        }
        input.nextLine();

        System.out.println("\nPlease write what you would like to replace");
        change = input.nextLine();

        try {
          detext.set(num, change);
          System.out.println("\nChange has been made would you like to continue?\nPress enter to continue or type: Done to quit");

        } catch (Exception e) {
          System.out.println("That line number does not exist");
          System.out.println("Try again? Please hit enter else type: Done");
        }

        choice = input.nextLine();
      }

      textEncryptor.setPassword(pass);

      Writer.empty(f_name);

      for (String str: detext) {
        String enText = textEncryptor.encrypt(str);
        Writer.write_file(enText + "\n", f_name);
      }
      System.exit(0);
    }

    System.out.println("Please enter the name of the file.\n");

    f_name = input.nextLine() + ".txt";

    while (!Writer.create_file(f_name)) {
      System.out.print("Please try again with a different name.\n\n");
      f_name = input.nextLine() + ".txt";
    }

    System.out.println("The next step is to now to crete a password that will lock your file.");

    System.out.print("\nA password must have:\n Must contain at least eight characters\n" +
      " Must contain letters, digits, and a special character\n Must contain at lease a digit\n\n");

    pass = input.nextLine();

    while (!Pass_create.password_checker(pass)) {

      System.out.print("\nNot a valid password!\n");
      System.out.print("Please try again.\n\n");
      pass = input.nextLine();

    }
    System.out.print("\nPasswword has been accepted\n\n");

    System.out.println("Next, please write into file:\nIf you would like to stop type: Done\n");

    textEncryptor.setPassword(pass);

    while (true) {

      line = input.nextLine();

      if (line.toUpperCase().equals("DONE")) {
        break;
      }
      writ.add(line);
    }

    for (String str: writ) {

      String enText = textEncryptor.encrypt(str);
      Writer.write_file(enText + "\n", f_name);

    }

    System.out.println("Thank you very much, your file has been created and encrypted");

    input.close();
  }
}
