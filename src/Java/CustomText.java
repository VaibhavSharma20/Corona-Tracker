package Java;
import java.util.Scanner;

public class CustomText {
    public static String writeMail () {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWhat you wanna send in mail ? ");
        String content = "";
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("*")) break;
            content = content + s + "\n";
        }
        return content;
    }
}
