package de.iainschmidt.inf.textgame.utils;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.ButtonAction;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.Lockable;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.frames.ErrorScreen;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class RoomChangeAction implements ButtonAction {

    public GameFrame from;
    public GameFrame to;
    public boolean ignoreKey = false;

    public RoomChangeAction(GameFrame from, GameFrame to) {
        this.from = from;
        this.to = to;
    }

    public RoomChangeAction(GameFrame from, GameFrame to, boolean ignoreKey) {
        this.from = from;
        this.to = to;
        this.ignoreKey = ignoreKey;
    }

    @Override
    public void onClick() {
        if(to instanceof Lockable){
            System.out.println("is lockable");
            Lockable lockable = (Lockable) to;
            boolean pass = false;
            for (Item item : TextGame.getInstance().getInventory()) {
                System.out.println(item.getDisplayname());
                if(item.getKeyLevelsList().contains(lockable.getKeyLevel())){
                    System.out.println("yes");
                    pass = true;
                }
            }
            System.out.println("pass = " + pass);
            if(!pass && !ignoreKey){
                TextGame.getInstance().getGui().update(new ErrorScreen("Du hast keinen Schlüssel für diesen Raum!", from));
                return;
            }
        }
        System.out.println("change from " + from.getTitle() + " to " + to.getTitle());
        TextGame.getInstance().getGui().update(to);
    }
}
