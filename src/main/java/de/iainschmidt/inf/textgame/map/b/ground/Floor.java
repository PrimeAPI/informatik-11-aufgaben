package de.iainschmidt.inf.textgame.map.b.ground;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class Floor implements GameFrame {
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
        return "null";
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("B02", this, null, ButtonOrientation.LEFT),
                new RoomChangeButton("B03", this, null, ButtonOrientation.TOP),
                new RoomChangeButton("B05", this, null, ButtonOrientation.RIGHT),
                new RoomChangeButton("B08 (Kustsammlung)", this, null, ButtonOrientation.LEFT),
                new RoomChangeButton("B07 (Kustsammlung)", this, null, ButtonOrientation.BUTTON),
                new RoomChangeButton("B06 (Kunstraum)", this, null, ButtonOrientation.RIGHT)
        };
    }
}
