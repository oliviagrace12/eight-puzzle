package domain;

/**
 * Created by oliviachisman on 4/11/20
 */
public class Node {

    private final State state;
    private final Action action;
    private final int pathCost;
    private final int misplacedTiles;
    private final int manhattanDistance;
    private final Node parent;

    public Node(State state, Action action, int pathCost, int misplacedTiles, int manhattanDistance, Node parent) {
        this.state = state;
        this.action = action;
        this.pathCost = pathCost;
        this.misplacedTiles = misplacedTiles;
        this.manhattanDistance = manhattanDistance;
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
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

    public Action getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=\n" + state + "\n" +
                ", action=" + action +
                ", pathCost=" + pathCost +
                ", misplacedTiles=" + misplacedTiles +
                ", manhattanDistance=" + manhattanDistance +
                '}' + "\n" +
                parent;
    }
}
