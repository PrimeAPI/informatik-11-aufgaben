package de.iainschmidt.inf.textgame.framework;

import de.iainschmidt.inf.textgame.game.Item;

import java.util.ArrayList;

public interface Inventoryable {

    ArrayList<Item> getItems();

    void removeItem(Item item);

}
