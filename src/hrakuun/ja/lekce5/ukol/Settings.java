package hrakuun.ja.lekce5.ukol;

public class Settings {

    private static final String FILENAME = "data/kvetiny.txt";
    private static final String DELIMITER = "\t";

    public static String getFilename(){
        return FILENAME;
    }
    public static String getDelimiter(){
        return DELIMITER;
    }
}