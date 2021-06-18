package de.iainschmidt.inf.textgame.map.b.ground;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.Lockable;
import de.iainschmidt.inf.textgame.game.KeyLevel;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

public class B07Sammlung implements GameFrame, Lockable {
    @Override
    public String getRoomName() {
        return "B07";
    }

    @Override
    public String getTitle() {
        return "B07 - Kunstsammlung";
    }

    @Override
    public String getText() {
        return "Du bist in einer 2. Knstsammlung";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("B08 (Kunstsammlung)", this, Room.B_08_SAMMLUNG.getFrame(), ButtonOrientation.LEFT),
                new RoomChangeButton("Flutr", this, Room.B_FLOOR.getFrame(), ButtonOrientation.TOP),
                new RoomChangeButton("B06 (Kunstraum)", this, Room.B_06.getFrame(), ButtonOrientation.RIGHT),
        };
    }

    @Override
    public KeyLevel getKeyLevel() {
        return KeyLevel.ART;
    }
}
