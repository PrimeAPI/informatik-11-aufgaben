package de.iainschmidt.inf.textgame.framework;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public interface DisplayableFrame {

    String getRoomName();

    String getTitle();

    String getText();


    String getImgPath();

    Button[] getButtons();


    boolean isVisited();

    void setVisited(boolean visited);

}
