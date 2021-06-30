package de.iainschmidt.inf.textgame.utils;

/**
 * @author Iain Schmidt
 * created on 30.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class TimeUtils {

    /**
     * Translate a long of millies to a human readable form
     * @param remaining The Time
     * @param displaySeconds True if seconds sould be displayed
     * @return The translated String
     */
    public static String unixToRemaining(long remaining, boolean displaySeconds){
        if(remaining == -1) return "Unendlich";
        String msg = "";

        long seconds = (remaining / 1000);

        if (seconds >= 60 * 60 * 24) {
            long days = seconds / (60 * 60 * 24);
            seconds = seconds % (60 * 60 * 24);
            msg += days + " Tag(e) ";

        }
        if (seconds >= 60 * 60) {
            long h = seconds / (60 * 60);
            seconds = seconds % (60 * 60);
            msg += h + " Stunde(n) ";
        }
        if (seconds >= 60) {
            long min = seconds / 60;
            seconds = seconds % 60;
            msg += min + " Minute(n) ";
        }
        if(displaySeconds){
            msg += seconds + " Sekunde(n) ";
        }

        return msg;
    }

}
