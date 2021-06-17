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
public class InventoryFrame implements GameFrame {

    GameFrame prev;

    public InventoryFrame(GameFrame prev) {
        this.prev = prev;
    }

    @Override
    public String getRoomName() {
        return "INVENTORY";
    }

    @Override
    public String getTitle() {
        return "Dein Inventar";
    }

    @Override
    public String getText() {
        return "Du hast folgende Items dabei: Bla Bla Bla Bla Bla";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new Button("Zurück", new RoomChangeAction(this, prev), ButtonOrientation.TOP)
        };
    }
}
