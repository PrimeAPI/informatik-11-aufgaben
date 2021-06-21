package de.iainschmidt.inf.textgame.framework;

import de.iainschmidt.inf.textgame.game.Item;

import java.util.ArrayList;
import java.util.List;

public interface Inventoryable {

     ArrayList<Item> getItems();

     void removeItem(Item item);

}
