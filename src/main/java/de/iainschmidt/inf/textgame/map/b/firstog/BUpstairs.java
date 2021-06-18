package de.iainschmidt.inf.textgame.map.b.firstog;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

public class BUpstairs implements GameFrame {
    @Override
    public String getRoomName() {
        return "B 1. OG";
    }

    @Override
    public String getTitle() {
        return "B-Gebäude: 1. OG";
    }

    @Override
    public String getText() {
        return "Du bist nun die Treppen hochgegangen!";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("B101 (Bioraum)", this, Room.B_101, ButtonOrientation.LEFT),
                new RoomChangeButton("B102", this, Room.B_102, ButtonOrientation.TOP),
                new RoomChangeButton("B103", this, Room.B_103, ButtonOrientation.RIGHT),
                new RoomChangeButton("B108 (Bioraum)", this, Room.B_108, ButtonOrientation.LEFT),
                new RoomChangeButton("B107 (Bio-Sammlung)", this, Room.B_107, ButtonOrientation.BUTTON),
                new RoomChangeButton("B106 (Bioraum)", this, Room.B_106, ButtonOrientation.RIGHT),
                new RoomChangeButton("Treppen Runter gehen", this, Room.B_FORYER, ButtonOrientation.BUTTON)
        };
    }
}
