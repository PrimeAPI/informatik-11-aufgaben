package de.iainschmidt.inf.textgame.framework;


/**
 * @author Iain Schmidt
 * created on 21.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public abstract class GameFrameImplLockable implements DisplayableFrame, Inventoryable, Lockable {


    boolean visited = false;

    @Override
    public boolean isVisited() {
        return visited;
    }

    @Override
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
