package de.iainschmidt.inf.textgame.framework;

/**
 * @author Iain Schmidt
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public class Button {

    String text;
    ButtonAction action;
    ButtonOrientation orientation;

    public Button(String text, ButtonAction action, ButtonOrientation orientation) {
        this.text = text;
        this.action = action;
        this.orientation = orientation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ButtonAction getAction() {
        return action;
    }

    public void setAction(ButtonAction action) {
        this.action = action;
    }

    public ButtonOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(ButtonOrientation orientation) {
        this.orientation = orientation;
    }

}
