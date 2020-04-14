package logic;

import domain.Action;
import domain.Node;
import domain.State;

import java.util.*;
import java.util.stream.Collectors;

import static domain.Action.*;

/**
 * Created by oliviachisman on 4/11/20
 */
public class Solver {

    private final HashMap<Integer, List<Action>> possibleActions;
    private final StateTransformer stateTransformer = new StateTransformer();
    private final State goalState;
    private final HashMap<Action, Action> oppositeActions;
    private final HashSet<State> explored = new HashSet<>();

    public Solver() {
        this.possibleActions = generatePossibleActions();
        this.goalState = new State(List.of(1, 2, 3, 8, 0, 4, 7, 6, 5));
        this.oppositeActions = getOppositeActions();
    }

    private HashMap<Action, Action> getOppositeActions() {
        HashMap<Action, Action> opposites = new HashMap<>();
        opposites.put(RIGHT, LEFT);
        opposites.put(LEFT, RIGHT);
        opposites.put(UP, DOWN);
        opposites.put(DOWN, UP);

        return opposites;
    }

    public Optional<Node> solveWithBreadthFirstSearch(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        Node current;
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (!explored.contains(current.getState())) {
                explored.add(current.getState());
                if (isGoalState(current.getState())) {
                    return Optional.of(current);
                } else {
                    queue.addAll(getChildNodes(current));
                }
            }
        }

        return Optional.empty();
    }

    private List<Node> getChildNodes(Node parentNode) {
        List<Action> actions = possibleActions.get(parentNode.getState().getBlank());
        if (parentNode.getAction() != null) {
            Action opposite = oppositeActions.get(parentNode.getAction());
            actions = actions.stream().filter(a -> !a.equals(opposite)).collect(Collectors.toList());
        }

        List<Node> childNodes = new ArrayList<>();
        for (Action action : actions) {
            State childState = stateTransformer.transform(parentNode.getState(), action);
            childNodes.add(new Node(childState, action));
        }

        return childNodes;
    }

    private boolean isGoalState(State state) {
        return state.getNums().equals(goalState.getNums()) && state.getBlank() == goalState.getBlank();
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

}
