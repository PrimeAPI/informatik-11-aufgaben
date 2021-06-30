package de.iainschmidt.inf.textgame.framework;

public abstract class GameFrameImpl implements GameFrame, Inventoryable {

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
