package de.iainschmidt.inf.textgame.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public enum Item {

    KEYS_MASTER("Hausmeister Schlüssel", KeyLevel.MASTER, KeyLevel.BIOLOGY, KeyLevel.CHEMISTRY, KeyLevel.PHYSICS, KeyLevel.COMPUTER, KeyLevel.ART, KeyLevel.NORMAL),
    KEY_ART("Kunstlehrer Schlüssel", KeyLevel.ART, KeyLevel.NORMAL),
    KEY_BIO("Biolehrer Schlüssel", KeyLevel.BIOLOGY, KeyLevel.NORMAL),
    KEY_UNKNOWN("Unbekannter Schlüssel",KeyLevel.COMPUTER, KeyLevel.NORMAL),
    KEY_INF("Informatiklehrer Schlüssel", KeyLevel.COMPUTER, KeyLevel.NORMAL),
    KEY_NORMAL("Schlüssel", KeyLevel.NORMAL),
    FOOD("Brotdose"),
    GUITARR("Gitarre"),
    KLANGSTAEBE("Klangstäbe")
    ;


    String displayname;
    KeyLevel[] keyLevels = new KeyLevel[]{};

    Item(String displayname) {
        this.displayname = displayname;
    }

    Item(String displayname, KeyLevel... keyLevels) {
        this.displayname = displayname;
        this.keyLevels = keyLevels;
    }

    public String getDisplayname() {
        return displayname;
    }

    public KeyLevel[] getKeyLevels() {
        return keyLevels;
    }
    public List<KeyLevel> getKeyLevelsList() {
        return Arrays.asList(keyLevels);
    }

    @Override
    public String toString() {
        return getDisplayname();
    }
}
