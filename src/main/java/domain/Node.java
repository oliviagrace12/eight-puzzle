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

    public Node(State state) {
        this(state, null, 0, 0, 0, null);
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

    public int getPathLength() {
        if (parent == null) {
            return 0;
        } else {
            return 1 + parent.getPathCost();
        }
    }

    @Override
    public String toString() {
        return "Node{" + "\n" +
                "\tstate=\n" + state + "\n" +
                "\taction=" + action + "\n" +
                "\tpathCost=" + pathCost + "\n" +
                "\tmisplacedTiles=" + misplacedTiles + "\n" +
                "\tmanhattanDistance=" + manhattanDistance + "\n" +
                '}' + "\n" +
                parent;
    }
}
