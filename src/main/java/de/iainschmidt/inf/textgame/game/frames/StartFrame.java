package de.iainschmidt.inf.textgame.game.frames;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class StartFrame implements GameFrame {

    GameFrame nextRoom;

    public StartFrame(GameFrame nextRoom) {
        this.nextRoom = nextRoom;
    }

    @Override
    public String getTitle() {
        return "Eingesperrt in der Schule";
    }

    @Override
    public String getText() {
        return "yeye jetzt gehts los";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        Button[] buttons = {
                new Button("Start!", new RoomChangeAction(this, nextRoom, true), ButtonOrientation.TOP),
        };
        return buttons;
    }

    @Override
    public String getRoomName() {
        return "START";
    }



    @Override
    public boolean isVisited() {
        return false;
    }

    @Override
    public void setVisited(boolean visited) {}
}
