package de.iainschmidt.inf.textgame.game.specialrooms;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;
import de.iainschmidt.inf.textgame.utils.RoomChangeButton;

import javax.swing.*;

/**
 * @author Lukas S. PrimeAPI
 * created on 29.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class ABouroEntry implements GameFrame {

    /**
     * Randomly generated {@link TextGame#loadGame()}
     */
    public static Integer passcode = 0000;
    public Integer input = null;

    @Override
    public String getRoomName() {
        return "Büro";
    }

    @Override
    public String getTitle() {
        return "Büro | Schulleitung";
    }

    @Override
    public String getText() {
        if (input == null) {
            return "Das Büro ist mit einer Pin gesichert! Irgendwo muss die Pin doch stehen.\n\n\n" +
                    "Falls du Hilfe brauchst gibt es eine Hilfestellung!";
        }

        if (passcode.equals(input)) {
            new RoomChangeAction(this, Room.A_BOURO.getFrame()).onClick();
            return "Leite weiter...";
        }
        return "Du hast eine FALSCHE Pin eingegeben! Versuche es erneut oder suche weiter!";
    }

    @Override
    public String getImgPath() {
        return "img/bouro_keypad.png";
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new RoomChangeButton("Zurück zum Flur", this, Room.A_UPSTAIRS, ButtonOrientation.RIGHT),
                new Button("PIN eingeben", this::openInput, ButtonOrientation.SPECIAL),
                new Button("Hilfe", () -> {
                    TextGame.getInstance().addTippCount();
                    JOptionPane.showMessageDialog(TextGame.getInstance().getGui(), "Informationen zum Pin findest du in den Computerräumen!", "Hilfestellung", JOptionPane.INFORMATION_MESSAGE);
                }, ButtonOrientation.SPECIAL)
        };
    }

    public void openInput() {
        try {
            input = Integer.valueOf(JOptionPane.showInputDialog("Gib die vierstellige PIN ein!"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(TextGame.getInstance().getGui(), "Dein Code darf ausschließlich aus Zahlen bestehen!", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
        }
        new RoomChangeAction(this, this).onClick();
    }

    private void checkPass() {
        if (passcode.equals(input)) {
            new RoomChangeAction(this, Room.A_BOURO.getFrame()).onClick();
        }
    }
}
