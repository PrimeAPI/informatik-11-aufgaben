package de.iainschmidt.inf.textgame.framework;

/**
 * @author Iain Schmidt
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 * <br>
 * Base interface used to render content to the User
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
