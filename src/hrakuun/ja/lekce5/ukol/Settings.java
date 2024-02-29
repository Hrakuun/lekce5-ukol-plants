package hrakuun.ja.lekce5.ukol;

public class Settings {

    private static final String FILENAME = "data/kvetiny.txt";
    private static final String WRONGFILENAME = "data/kvetiny-spatne-datum.txt";
    private static final String WRONGFILENAME2 = "data/kvetiny-spatne-frekvence.txt";
    private static final String NEWFILENAME = "data/new_kvetiny.txt";

    private static final String DELIMITER = "\t";

    public static String getFilename() {
        return FILENAME;
    }

    public static String getWrongFilename() {
        return WRONGFILENAME;
    }

    public static String getWrongFilename2() {
        return WRONGFILENAME2;
    }


    public static String getNewfilename() {
        return NEWFILENAME;
    }

    public static String getDelimiter() {
        return DELIMITER;
    }
}
