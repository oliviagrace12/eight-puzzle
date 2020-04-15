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

    public Solver() {
        this.possibleActions = generatePossibleActions();
        this.goalState = new State(List.of(1, 2, 3, 8, 0, 4, 7, 6, 5));
    }

    public Optional<Node> solveWithBreadthFirstSearch(Node node) {
        if (isGoalState(node.getState())) {
            return Optional.of(node);
        }

        HashSet<State> explored = new HashSet<>();
        Queue<Node> toExplore = new ArrayDeque<>();
        toExplore.add(node);

        Node current;
        while (!toExplore.isEmpty()) {
            current = toExplore.remove();
            explored.add(current.getState());

            for (Action action : possibleActions.get(current.getState().getBlank())) {
                State childState = stateTransformer.transform(current.getState(), action);
                if (!explored.contains(childState)) {
                    Node childNode = new Node(childState, action);
                    if (!toExplore.contains(childNode)) {
                        if (isGoalState(childState)) {
                            return Optional.of(childNode);
                        } else {
                            toExplore.add(childNode);
                        }
                    }
                }
            }
        }

        return Optional.empty();
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
