package de.iainschmidt.inf.textgame;

import de.iainschmidt.inf.textgame.game.GraphicalUserInterface;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.frames.HomeScreen;
import de.iainschmidt.inf.textgame.game.specialrooms.ABouroEntry;

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

    private final List<Item> inventory = new ArrayList<>();

    private int tipCount = 0;
    private long startTimestamp;

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public static void main(String[] args) {
        instance = new TextGame();
        instance.loadGame();
    }

    public static TextGame getInstance() {
        return instance;
    }


    // Getter & Setter

    private void loadGame() {
        gui = new GraphicalUserInterface(new HomeScreen());
        System.out.println("[INFO] PIN fürs Büro: " + ABouroEntry.passcode);
        startTimestamp = System.currentTimeMillis();
    }

    public GraphicalUserInterface getGui() {
        return gui;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addTippCount() {
        tipCount++;
    }

    public int getTipCount() {
        return tipCount;
    }

    public void setTipCount(int tipCount) {
        this.tipCount = tipCount;
    }
}
