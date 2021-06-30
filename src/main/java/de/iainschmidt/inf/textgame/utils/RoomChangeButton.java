package de.iainschmidt.inf.textgame.utils;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.DisplayableFrame;
import de.iainschmidt.inf.textgame.game.Room;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class RoomChangeButton extends Button {
    public RoomChangeButton(String text, DisplayableFrame from, DisplayableFrame to, ButtonOrientation orientation) {
        super(text, new RoomChangeAction(from, to, false), orientation);
    }

    public RoomChangeButton(String text, DisplayableFrame from, Room to, ButtonOrientation orientation) {
        super(text, new RoomChangeAction(from, to, false), orientation);
    }
}
