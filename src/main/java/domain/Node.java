package domain;

import java.util.List;

/**
 * Created by oliviachisman on 4/11/20
 */
public class Node {

    private final State state;
    private final Action action;
    private final int pathCost;
    private final int misplacedTiles;
    private final int manhattanDistance;
    private List<Node> children;

    public Node(State state, Action action, int pathCost, int misplacedTiles, int manhattanDistance) {
        this.state = state;
        this.action = action;
        this.pathCost = pathCost;
        this.misplacedTiles = misplacedTiles;
        this.manhattanDistance = manhattanDistance;
    }

    public int getManhattanDistance() {
        return manhattanDistance;
    }

    public int getMisplacedTiles() {
        return misplacedTiles;
    }

    public int getPathCost() {
        return pathCost;
    }

    public State getState() {
        return state;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Action getAction() {
        return action;
    }


}
