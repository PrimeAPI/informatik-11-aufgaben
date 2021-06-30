package de.iainschmidt.inf.textgame.game.frames;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class InventoryFrame implements GameFrame {

    public final GameFrame prev;

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
        StringBuilder s = new StringBuilder("Du hast folgende Items in deiner Tasche:\n");
        for (Item item : TextGame.getInstance().getInventory()) {
            s.append("- 1x ").append(item.getDisplayname()).append("\n");
        }
        return s.toString();
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



    @Override
    public boolean isVisited() {
        return false;
    }

    @Override
    public void setVisited(boolean visited) {}
}
