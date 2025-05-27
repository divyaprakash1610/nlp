import java.util.*;
import java.util.regex.*;

public class AcceptStr {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter regex: ");
            Pattern p = Pattern.compile(sc.nextLine(), Pattern.CASE_INSENSITIVE);
            System.out.print("Enter string: ");
            System.out.println(
                    p.matcher(sc.nextLine()).matches() ? "String matches pattern." : "String does not match pattern.");
        }
    }
}
