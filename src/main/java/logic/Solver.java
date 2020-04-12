package main.java.logic;

import main.java.domain.Action;
import main.java.domain.Node;
import main.java.domain.State;

import java.util.HashMap;
import java.util.List;

import static main.java.domain.Action.*;

/**
 * Created by oliviachisman on 4/11/20
 */
public class Solver {

    private final HashMap<Integer, List<Action>> possibleActions;
    private final StateTransformer stateTransformer = new StateTransformer();

    public Solver() {
        this.possibleActions = generatePossibleActions();
    }

    private HashMap<Integer, List<Action>> generatePossibleActions() {
        HashMap<Integer, List<Action>> actions = new HashMap<>();

        actions.put(0, List.of(DOWN, RIGHT));
        actions.put(1, List.of(LEFT, DOWN, RIGHT));
        actions.put(2, List.of(LEFT, DOWN));
        actions.put(3, List.of(UP, RIGHT, DOWN));
        actions.put(4, List.of(LEFT, UP, DOWN, RIGHT));
        actions.put(5, List.of(LEFT, UP, DOWN));
        actions.put(6, List.of(UP, RIGHT));
        actions.put(7, List.of(LEFT, UP, RIGHT));
        actions.put(8, List.of(LEFT, UP));

        return actions;
    }

    private Node generateNode(State state, Action action, int depth, int pathCost, boolean expanded) {
        return new Node(state, getChildren(state), action, depth, pathCost, expanded);
    }

    private List<Node> getChildren(State state) {
        List<Action> actions = possibleActions.get(state.getBlank());

        for (Action action : actions) {

        }

        return null;
    }

}
