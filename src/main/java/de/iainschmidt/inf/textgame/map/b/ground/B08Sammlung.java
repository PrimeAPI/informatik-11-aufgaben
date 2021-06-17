package de.iainschmidt.inf.textgame.map.b.ground;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.Lockable;
import de.iainschmidt.inf.textgame.game.KeyLevel;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class B08Sammlung implements GameFrame, Lockable {
    @Override
    public String getRoomName() {
        return "B08 - Sammlung";
    }

    @Override
    public String getTitle() {
        return "B08 - Kunstsammlung";
    }

    @Override
    public String getText() {
        return "Hier stehen einige Sachen";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("B08 (Kunstraum)", this, Room.B_08.getFrame(), ButtonOrientation.LEFT),
                new RoomChangeButton("Flur", this, null, ButtonOrientation.TOP),
                new RoomChangeButton("B07 (Kunstsammlung)", this, null, ButtonOrientation.LEFT)
        };
    }

    @Override
    public KeyLevel getKeyLevel() {
        return KeyLevel.ART;
    }
}
