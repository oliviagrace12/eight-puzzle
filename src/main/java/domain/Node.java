package domain;

import java.util.List;

/**
 * Created by oliviachisman on 4/11/20
 */
public class Node implements Comparable {

    private final State state;
    private final Action action;
    private final int pathCost;
    private final int heuristic;
    private List<Node> children;

    public Node(State state, Action action, int pathCost, int heuristic) {
        this.state = state;
        this.action = action;
        this.pathCost = pathCost;
        this.heuristic = heuristic;
    }

    public int getHeuristic() {
        return heuristic;
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

    @Override
    public String toString() {
        return "Node{" +
                "state=\n" + state +
                ", children=" + children +
                ", action=" + action +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Node) {
            if (this.state.equals(((Node) o).state)
                    && this.action.equals(((Node) o).action)
                    && this.children.containsAll(((Node) o).children)) {
                return 0;
            }
        }

        return-1;
}
}
