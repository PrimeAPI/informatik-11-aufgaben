package de.iainschmidt.inf.textgame.game.frames;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.DisplayableFrame;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class ErrorScreen implements DisplayableFrame {

    final String message;
    final DisplayableFrame from;

    public ErrorScreen(String message, DisplayableFrame from) {
        this.message = message;
        this.from = from;
    }

    @Override
    public String getRoomName() {
        return "ERROR";
    }

    @Override
    public String getTitle() {
        return "Hier kannst du nicht rein";
    }

    @Override
    public String getText() {
        return message;
    }

    @Override
    public String getImgPath() {
        return "img/lock.png";
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new Button("Zurück", new RoomChangeAction(this, from), ButtonOrientation.TOP)
        };
    }

    @Override
    public boolean isVisited() {
        return false;
    }

    @Override
    public void setVisited(boolean visited) {}
}
