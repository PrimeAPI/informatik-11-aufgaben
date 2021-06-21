package de.iainschmidt.inf.textgame.map.b.ground;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.Inventoryable;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B06Room implements GameFrame, Inventoryable {
    @Override
    public String getRoomName() {
        return "B06";
    }

    @Override
    public String getTitle() {
        return "B06 - Kunstraum";
    }

    @Override
    public String getText() {
        return "Du bist in einem Kunstraum. Hier hatte Le0mann ihren Schlüssel liegen gelassen\n" +
                "";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("B07 (Kunstsammlung)", this, Room.B_07, ButtonOrientation.LEFT),
                new RoomChangeButton("Flur", this, Room.B_FLOOR, ButtonOrientation.TOP),
        };
    }

    ArrayList<Item> items = new ArrayList<>(Arrays.asList(new Item[]{
            Item.KEY_ART
    }));

    @Override
    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }
}
