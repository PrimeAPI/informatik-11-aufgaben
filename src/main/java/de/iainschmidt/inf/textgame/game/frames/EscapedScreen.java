package de.iainschmidt.inf.textgame.game.frames;

import de.iainschmidt.inf.textgame.TextGame;
import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.Lockable;
import de.iainschmidt.inf.textgame.game.KeyLevel;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.TimeUtils;

/**
 * @author Lukas S. PrimeAPI
 * created on 22.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class EscapedScreen implements GameFrame, Lockable {
    @Override
    public String getRoomName() {
        return "ENDING";
    }

    @Override
    public String getTitle() {
        return "Du hast gewonnen!";
    }

    @Override
    public String getText() {
        StringBuilder builder = new StringBuilder("Herzlichen Glückwunsch, du hast es geschafft!\n" +
                "Du hast den Schlüssel gefunden.\n\n" +
                "Benötigte Zeit: " + TimeUtils.unixToRemaining(System.currentTimeMillis() - TextGame.getInstance().getStartTimestamp(), true) + "\n" +
                "Verwendete Hilfestellungen: " + TextGame.getInstance().getTipCount() + "\n" +
                "\n Besuchte räume:\n");
        for (Room value : Room.values()) {
            if(value.getFrame() != null){
                if(value.getFrame().isVisited()){
                    builder.append("- ").append(value.getFrame().getTitle()).append("\n");
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[0];
    }

    @Override
    public KeyLevel getKeyLevel() {
        return KeyLevel.MASTER;
    }


    @Override
    public boolean isVisited() {
        return false;
    }

    @Override
    public void setVisited(boolean visited) {}
}
