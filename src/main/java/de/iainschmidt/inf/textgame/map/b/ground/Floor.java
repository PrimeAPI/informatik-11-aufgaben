package de.iainschmidt.inf.textgame.map.b.ground;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrameImpl;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

import java.util.ArrayList;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class Floor extends GameFrameImpl {
    @Override
    public String getRoomName() {
        return "Flur";
    }

    @Override
    public String getTitle() {
        return "Flur - B Gebäude";
    }

    @Override
    public String getText() {
        return "Du bist im Flur. Du kannst von hier aus in Klassenräume und von die Kunsträume gehen!";
    }

    @Override
    public String getImgPath() {
        return "img/floor.png";
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("B02", this, Room.B_02.getFrame(), ButtonOrientation.LEFT),
                new RoomChangeButton("Foryer", this, Room.B_FORYER.getFrame(), ButtonOrientation.LEFT),
                new RoomChangeButton("B03", this, Room.B_03, ButtonOrientation.TOP),
                new RoomChangeButton("B05", this, Room.B_05, ButtonOrientation.RIGHT),
                new RoomChangeButton("B08 (Kustsammlung)", this, Room.B_08_SAMMLUNG.getFrame(), ButtonOrientation.LEFT),
                new RoomChangeButton("B07 (Kustsammlung)", this, Room.B_07, ButtonOrientation.BUTTON),
                new RoomChangeButton("B06 (Kunstraum)", this, Room.B_06, ButtonOrientation.RIGHT)
        };
    }

    @Override
    public ArrayList<Item> getItems() {
        return null;
    }

    @Override
    public void removeItem(Item item) {

    }
}
