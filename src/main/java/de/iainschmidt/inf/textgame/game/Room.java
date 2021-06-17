package de.iainschmidt.inf.textgame.game;

import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.map.b.ground.B08Room;
import de.iainschmidt.inf.textgame.map.b.ground.B08Sammlung;
import de.iainschmidt.inf.textgame.map.b.ground.Foryer;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public enum Room {

    B_FORYER(new Foryer()),
    B_08(new B08Room()),
    B_08_SAMMLUNG(new B08Sammlung()),

    ;


    GameFrame frame;

    Room(GameFrame frame) {
        this.frame = frame;
    }

    public GameFrame getFrame() {
        return frame;
    }
}
