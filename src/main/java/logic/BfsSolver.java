package logic;

import domain.Action;
import domain.Node;
import domain.State;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;

/**
 * Created by oliviachisman on 4/14/20
 */
public class BfsSolver extends Solver {

    @Override
    public Optional<Node> solve(Node root) {
        if (isGoalState(root.getState())) {
            return Optional.of(root);
        }

        HashSet<State> explored = new HashSet<>();
        Queue<Node> toExplore = new ArrayDeque<>();
        toExplore.add(root);

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

}
