package de.iainschmidt.inf.textgame.framework;

import de.iainschmidt.inf.textgame.TextGame;

import java.util.Set;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public interface GameFrame {

    String getRoomName();

    String getTitle();

    String getText();


    String getImgPath();

    Button[] getButtons();
;
}
