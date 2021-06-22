package de.iainschmidt.inf.textgame.game.frames;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.Lockable;
import de.iainschmidt.inf.textgame.game.KeyLevel;

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
        return "Du bist entkommen";
    }

    @Override
    public String getText() {
        return "Du hast es geschafft!";
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
}
