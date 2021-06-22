package de.iainschmidt.inf.textgame.framework;

import de.iainschmidt.inf.textgame.game.Room;

/**
 * @author Lukas S. PrimeAPI
 * created on 21.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class SimpleButton {

    String title;
    Room target;
    ButtonOrientation orientation;

    public SimpleButton(String title, Room target, ButtonOrientation orientation) {
        this.title = title;
        this.target = target;
        this.orientation = orientation;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Room getTarget() {
        return target;
    }

    public void setTarget(Room target) {
        this.target = target;
    }

    public ButtonOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(ButtonOrientation orientation) {
        this.orientation = orientation;
    }
}
