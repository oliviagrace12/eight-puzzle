package main.java.domain;

import java.util.List;

/**
 * Created by oliviachisman on 4/11/20
 */
public class Node {

    private State state;
    private List<Node> children;
    private Action action;
    private int depth;
    private int pathCost;
    private boolean expanded;

    public Node(State state, List<Node> children, Action action, int depth, int pathCost, boolean expanded) {
        this.state = state;
        this.children = children;
        this.action = action;
        this.depth = depth;
        this.pathCost = pathCost;
        this.expanded = expanded;
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

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", children=" + children +
                ", action=" + action +
                ", depth=" + depth +
                ", pathCost=" + pathCost +
                ", expanded=" + expanded +
                '}';
    }
}
