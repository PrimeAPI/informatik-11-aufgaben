package de.iainschmidt.inf.textgame.map.b.ground;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class B08Room implements GameFrame {
    @Override
    public String getRoomName() {
        return "B08";
    }

    @Override
    public String getTitle() {
        return "B08 - Kunstraum";
    }

    @Override
    public String getText() {
        return "Du bist im Kunstraum blla bla bla";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("B-Foryer", this, Room.B_FORYER.getFrame(), ButtonOrientation.TOP),
                new RoomChangeButton("B08 (Kunstsammlung)", this, Room.B_08_SAMMLUNG.getFrame(), ButtonOrientation.RIGHT),
        };
    }
}
