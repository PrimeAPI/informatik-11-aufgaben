package de.iainschmidt.inf.textgame.game.frames;

import de.iainschmidt.inf.textgame.framework.Button;
import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.DisplayableFrame;
import de.iainschmidt.inf.textgame.game.Room;
import de.iainschmidt.inf.textgame.utils.RoomChangeAction;

/**
 * @author Iain Schmidt
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class HomeScreen implements DisplayableFrame {

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
        return """
                Escape the Maxe!
                
                Vorgeschichte:
                Es ist Samstag. Den Tag zuvor hattest du Kunstunterricht in B08. Dieser war so langweilig, dass du einfach eingeschlafen bist.
                Als Scherz, und um zu gucken wann du wach werden würdest, haben dich deine Mitschüler und der Lehrer schlafen lassen. Sie haben
                dich aber vergessen! Es gibt verschiedene Wege raus, jedoch wurdest du eingeschlossen. Vielleicht, hat Frau Wutschke einen 2. Schlüssel
                in ihrem Büro....
                """;
    }

    @Override
    public String getImgPath() {
        return "img/school.png";
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                new Button("Loglegen", new RoomChangeAction(this, Room.B_08, true), ButtonOrientation.SPECIAL)
        };
    }



    @Override
    public boolean isVisited() {
        return false;
    }

    @Override
    public void setVisited(boolean visited) {}
}
