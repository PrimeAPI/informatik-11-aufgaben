package de.iainschmidt.inf.textgame.game;

import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.map.b.firstog.BUpstairs;
import de.iainschmidt.inf.textgame.map.b.ground.*;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public enum Room {

    B_FORYER(new Foryer()),
    B_08(new B08Room()),
    B_08_SAMMLUNG(new B08Sammlung()),
    B_FLOOR(new Floor()),
    B_07(new B07Sammlung()),
    B_06(null),
    B_05(null),
    B_03(null),
    B_02(null),
    B_01(null),

    B_UPSTAIRS(new BUpstairs()),
    B_101(null),
    B_102(null),
    B_103(null),
    B_108(null),
    B_107(null),
    B_106(null),

    A_STAIRCASE(null),


    HAUPTHOF(null),

    ;


    GameFrame frame;

    Room(GameFrame frame) {
        this.frame = frame;
    }

    public GameFrame getFrame() {
        return frame;
    }
}
