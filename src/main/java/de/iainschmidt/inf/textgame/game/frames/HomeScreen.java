package de.iainschmidt.inf.textgame.game.frames;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;

/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class HomeScreen implements GameFrame {

    @Override
    public String getRoomName() {
        return "HOME";
    }

    @Override
    public String getTitle() {
        return "Ein Textadvanture";
    }

    @Override
    public String getText() {
        return "Escape the Maxe! \n" +
                "Um zu beginnen, wähle zunächst dein Lieblingsfach aus!";
    }

    @Override
    public String getImgPath() {
        return null;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new Button("Kunst", new RoomChangeAction(this, new StartFrame(Room.B_08.getFrame()), true), ButtonOrientation.TOP)
        };
    }
}
