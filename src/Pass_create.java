import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pass_create {

    public static final int password_min = 8;

    public static boolean password_checker(String password) {

        if (password.length() >= 8) {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher letter_check = letter.matcher(password);
            Matcher digit_check = digit.matcher(password);
            Matcher special_check = special.matcher(password);

            return letter_check.find() && digit_check.find() && special_check.find();

        } else {
            return false;
        }

    }

}

