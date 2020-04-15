package logic;

import domain.Action;
import domain.Node;
import domain.State;

import java.util.*;

/**
 * Created by oliviachisman on 4/14/20
 */
public class DfsSolver extends Solver {
    @Override
    public Optional<Node> solve(Node node) {
        if (isGoalState(node.getState())) {
            return Optional.of(node);
        }

        HashSet<State> explored = new HashSet<>();
        Stack<Node> toExplore = new Stack<>();
        toExplore.add(node);

        Node current;
        while (!toExplore.isEmpty()) {
            current = toExplore.pop();
            explored.add(current.getState());

            for (Action action : possibleActions.get(current.getState().getBlank())) {
                State childState = stateTransformer.transform(current.getState(), action);
                if (!explored.contains(childState)) {
                    Node childNode = new Node(childState, action);
                    if (!toExplore.contains(childNode)) {
                        if (isGoalState(childState)) {
                            return Optional.of(childNode);
                        } else {
                            toExplore.push(childNode);
                        }
                    }
                }
            }
        }

        return Optional.empty();
    }

}
