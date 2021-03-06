package de.iainschmidt.inf.textgame.utils;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.ButtonAction;
import de.iainschmidt.inf.textgame.framework.DisplayableFrame;
import de.iainschmidt.inf.textgame.framework.Lockable;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.game.frames.ErrorScreen;

/**
 * @author Iain Schmidt
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 *
 * This {@link ButtonAction} is used to easely create an action to change Rooms.
 * It checks if the Player has the Pemrission ({@link de.iainschmidt.inf.textgame.game.KeyLevel} to enter the Room
 *
 */
public class RoomChangeAction implements ButtonAction {

    public final DisplayableFrame from;
    public DisplayableFrame to;
    public Room room;
    public boolean ignoreKey = false;

    public RoomChangeAction(DisplayableFrame from, DisplayableFrame to) {
        this.from = from;
        this.to = to;
    }

    public RoomChangeAction(DisplayableFrame from, DisplayableFrame to, boolean ignoreKey) {
        this.from = from;
        this.to = to;
        this.ignoreKey = ignoreKey;
    }

    public RoomChangeAction(DisplayableFrame from, Room to, boolean ignoreKey) {
        this.from = from;
        this.room = to;
        this.ignoreKey = ignoreKey;
    }

    @Override
    public void onClick() {
        if (to == null) {
            to = room.getFrame();
        }
        if (to instanceof Lockable lockable) {
            System.out.println("is lockable");
            boolean pass = false;
            for (Item item : TextGame.getInstance().getInventory()) {
                System.out.println(item.getDisplayname());
                if (item.getKeyLevelsList().contains(lockable.getKeyLevel())) {
                    System.out.println("yes");
                    pass = true;
                }
            }
            System.out.println("pass = " + pass);
            if (!pass && !ignoreKey) {
                TextGame.getInstance().getGui().update(new ErrorScreen("Du hast keinen Schl??ssel f??r diesen Raum!", from));
                return;
            }
        }
        System.out.println("change from " + from.getTitle() + " to " + to.getTitle());
        TextGame.getInstance().getGui().update(to);
    }
}
