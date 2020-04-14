package domain;

import java.util.List;

/**
 * Created by oliviachisman on 4/11/20
 */
public class Node implements Comparable {

    private State state;
    private List<Node> children;
    private Action action;

    public Node(State state, Action action) {
        this.state = state;
        this.action = action;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public void setAction(Action action) {
        this.action = action;
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
