package de.iainschmidt.inf.textgame.map.b.ground;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class Foryer implements GameFrame {
    @Override
    public String getRoomName() {
        return "B-Foryer";
    }

    @Override
    public String getTitle() {
        return "B Gebäuse: Foryer";
    }

    @Override
    public String getText() {
        return "Du bist nun im B-Gebäude! Von hier kannst du nach oben, zum A-Gebäude oder zu Klassenräumen gehen!";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("A-Gebäude", this, Room.A_STAIRCASE, ButtonOrientation.TOP),
                new RoomChangeButton("Treppen hoch gehen", this, Room.B_UPSTAIRS, ButtonOrientation.TOP),
                new RoomChangeButton("Pausenhof betreten", this, Room.HAUPTHOF, ButtonOrientation.LEFT),
                new RoomChangeButton("Flur betreten", this, Room.B_FLOOR.getFrame(), ButtonOrientation.RIGHT),
                new RoomChangeButton("B08 (Kunstraum betreten)", this, Room.B_08.getFrame(), ButtonOrientation.BUTTON)
        };
    }
}
