package de.iainschmidt.inf.textgame.framework;

/**
 * @author Lukas S. PrimeAPI
 * created on 30.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public enum Image {

    CLASSROOM_1("img/classroom-1.png"),
    CLASSROOM_2("img/classroom-2.png"),
    CLASSROOM_3("img/classroom-3.png"),
    ;

    String url;

    Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
