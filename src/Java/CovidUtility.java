package Java;
/*
1. PRECAUTIONS LINK
2. VACCINATION REGISTRATION LINK
3. AROGYA SETU LINK
*/
public class CovidUtility {
    public static String precautionLink = "https://www.ncdc.gov.in/index1.php?lang=1&level=1&sublinkid=703&lid=550";
    public static String vaccineLink = "https://www.mohfw.gov.in/covid_vaccination/vaccination/index.html";
    public static String ArogyaLink = "https://www.aarogyasetu.gov.in/";
    public static String getVaccineLink() {
        return vaccineLink;
    }
    public static String getArogyaLink() {
        return ArogyaLink;
    }
    public static String getPrecautionLink() {
        return precautionLink;
    }
    public static String displayCovidPrecaution() {
        String covidDetail;
        covidDetail = "****SOME IMPORTANT LINKS TO FIGHT CORONA VIRUS****" +
                "\n\nCOVID 19 PRECAUTIONS : " + getPrecautionLink();
        return covidDetail;
    }
    public static String displayCovidVaccine() {
        String covidDetail;
        covidDetail = "****SOME IMPORTANT LINKS TO FIGHT CORONA VIRUS****" +
                "\n\nVACCINE REGISTRATION : " + getVaccineLink();
        return covidDetail;
    }
    public static String displayCovidApp() {
        String covidDetail;
        covidDetail = "****SOME IMPORTANT LINKS TO FIGHT CORONA VIRUS****" +
                "\n\nAROGYA SETU LINK     : " + getArogyaLink();
        return covidDetail;
    }
}
