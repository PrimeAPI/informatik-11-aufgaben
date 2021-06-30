package de.iainschmidt.inf.textgame.game.specialrooms;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.*;
import de.iainschmidt.inf.textgame.game.Item;
import de.iainschmidt.inf.textgame.game.KeyLevel;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Lukas S. PrimeAPI
 * created on 29.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class A202 extends GameFrameImplLockable {

    public static final String WLANKEY = "01437421";
    String input = null;

    @Override
    public String getRoomName() {
        return "A202";
    }

    @Override
    public String getTitle() {
        return "A202 | Informatik";
    }

    @Override
    public String getText() {
        if (input == null) {
            return """
                    Du bist im Informatikraum! Der Lehrer PC ist eingeschaltet.\s
                    Du kannst sehen, dass die letzte Lehrer noch angemeldet ist. Das WLAN ist aber deaktiviert!Du musst irgendwo das WLAN passwort finden!

                    Also ich würde es ja an einem Ort verstecken, der über allem liegt, und kein Schüler je hinkommen sollte""";
        }
        if (!input.equals(WLANKEY)) {
            return "Das Passwort ist falsch! \nDu musst nach einem neuen Passwort suchen!";
        }
        return """
                Du hast das richtige WLAN Passwort gefunden! Du kannst nun folgende E-Mails von Frau Wutschke an die Schulleitung lesen:

                1. Mail: 'Neue Klassenräume: Fr. Wriedt - B108; Fr. Labinsky - Biblio...'

                2. Mail: 'Zugang zu den Büros nun mit Pin! Ihre Pin finden sie in ihren Klassenr...'""";
    }

    @Override
    public String getImgPath() {
        if (input == null) {
            return "img/A202_login.png";
        }
        if (!input.equals(WLANKEY)) {
            return "img/A202_wrong.png";
        }
        return "img/A202_inbox.png";
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("Zurück zum Flur", this, Room.A_200, ButtonOrientation.RIGHT),
                new RoomChangeButton("A203 (Serverraum)", this, Room.A_203, ButtonOrientation.TOP),
                new RoomChangeButton("A201 (Computerraum)", this, Room.A_201, ButtonOrientation.BUTTON),
                new Button("WLAN Passwort eingeben", this::openWLAN, ButtonOrientation.SPECIAL),
                new Button("Hilfe", () -> {
                    TextGame.getInstance().addTippCount();
                    JOptionPane.showMessageDialog(TextGame.getInstance().getGui(), "Das Passwort findest du auf dem Dachboden!", "Hilfestellung", JOptionPane.INFORMATION_MESSAGE);
                }, ButtonOrientation.SPECIAL)
        };
    }

    @Override
    public KeyLevel getKeyLevel() {
        return KeyLevel.COMPUTER;
    }


    private void openWLAN() {
        input = JOptionPane.showInputDialog("Wie ist das WLAN Passwort?", null);
        new RoomChangeAction(this, this).onClick();
    }

    @Override
    public ArrayList<Item> getItems() {
        return null;
    }

    @Override
    public void removeItem(Item item) {

    }
}
