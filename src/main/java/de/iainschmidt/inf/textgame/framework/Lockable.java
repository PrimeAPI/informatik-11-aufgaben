package de.iainschmidt.inf.textgame.framework;

import de.iainschmidt.inf.textgame.game.KeyLevel;

/**
 * @author Iain Schmidt
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 * <br>
 * Interface for Rooms which are only accessable with an according key
 */
public interface Lockable {

    KeyLevel getKeyLevel();


}
