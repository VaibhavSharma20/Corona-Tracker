package Java;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static Java.CoronaDetails.stateAWT;

public class CovidAPI {
    private static HttpURLConnection connection;
    public static String mailMessage ;
    public static String mailState = stateAWT;
    public static String getStateMailMessage () {
        fetchAPI();
        return mailMessage;
    }
    public static void fetchAPI () {
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            if (status > 299) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
//            System.out.println(responseContent.toString());
            parse(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
    public static int getState (String stateName) {
        int stateNum = 0;
        String[] str = stateName.split(" ");
        String state = str[0];
        String[] stateArray = {"Andaman","Andhra","Arunachal","Assam","Bihar","Chandigarh","Chhattisgarh","Dadra",
                "Delhi","Goa","Gujarat","Haryana","Himachal","Jammu","Jharkhand","Karnataka","Kerala","Ladakh",
                "Lakshadweep","Madhya","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Puducherry",
                "Punjab","Rajasthan","Sikkim","Tamil","Telengana","Tripura","Uttarakhand","Uttar","West"};
        for (int i = 0; i < 29; i++) {
            if (state.equals(stateArray[i])) {
                stateNum = i;
                break;
            }
        }
        return stateNum;
    }
    public static String parse (String responseBody) {
        JSONObject covidDetail = new JSONObject(responseBody);
        JSONArray states = covidDetail.getJSONArray("regionData");
        int index = getState(mailState);
        JSONObject state = states.getJSONObject(index);
        String region = state.getString("region");
        BigInteger totalInfected = state.getBigInteger("totalInfected");
        BigInteger newInfected = state.getBigInteger("newInfected");
        BigInteger recovered = state.getBigInteger("recovered");
        BigInteger newRecovered = state.getBigInteger("newRecovered");
        BigInteger deceased = state.getBigInteger("deceased");
        BigInteger newDeceased = state.getBigInteger("newDeceased");
        mailMessage = "" +
                "\n*****************************************************" +
                "\n********COVID CASES STATE DETAILS********" +
                "\n*****************************************************" +
                "\nRegion         : " + region +
                "\nTotal Infected : " + totalInfected +
                "\nNew Infected   : " + newInfected +
                "\nRecovered      : " + recovered +
                "\nNew Recovered  : " + newRecovered +
                "\nDeceased       : " + deceased +
                "\nNew Deceased   : " + newDeceased;
        return null;
    }
}
