package Java;
import java.util.Scanner;
import static Java.CoronaDetails.emailAWT;
import static Java.CovidAPI.getStateMailMessage;
import static Java.CovidUtility.displayCovidPrecaution;
import static Java.Links.mailAWT;

public class finalMail {
    public static void sendFinalMail(String type) {
        try {
            String emailID = "";
            if (type.equals("Links")) {
                emailID = mailAWT;
            }
            if (type.equals("covidStateDetail")) {
                emailID = emailAWT;
            }
            JavaMailUtil.sendMail(emailID, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
