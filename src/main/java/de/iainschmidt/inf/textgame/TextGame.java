package de.iainschmidt.inf.textgame;

import de.iainschmidt.inf.textgame.game.GraphicalUserInterface;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.frames.HomeScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas S.
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class TextGame {

    private static TextGame instance;

    private GraphicalUserInterface gui;

    private List<Item> inventory = new ArrayList<>();

    public static void main(String[] args) {
        instance = new TextGame();
        instance.loadGame();
    }


    private void loadGame(){
        gui = new GraphicalUserInterface(new HomeScreen());
        inventory.add(Item.KEY_ART);
    }





    // Getter & Setter


    public static TextGame getInstance() {
        return instance;
    }

    public GraphicalUserInterface getGui() {
        return gui;
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
