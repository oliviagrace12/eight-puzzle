package logic;

import domain.Action;
import domain.Node;
import domain.State;

import java.util.*;

/**
 * Created by oliviachisman on 4/14/20
 */
public class UniformCostSolver extends Solver {

    @Override
    public Optional<Node> solve(Node node) {
        if (isGoalState(node.getState())) {
            return Optional.of(node);
        }

        PriorityQueue<Node> toExplore = new PriorityQueue<>(Comparator.comparing(Node::getPathCost));
        toExplore.add(node);
        updateMaxQueue(toExplore.size());

        Node current;
        while (!toExplore.isEmpty()) {
            current = toExplore.remove();
            explored.add(current.getState());

            for (Action action : possibleActions.get(current.getState().getBlank())) {
                Node childNode = stateTransformer.transform(current, action);
                if (!explored.contains(childNode.getState()) && !toExplore.contains(childNode)) {
                    if (isGoalState(childNode.getState())) {
                        return Optional.of(childNode);
                    } else {
                        toExplore.add(childNode);
                        updateMaxQueue(toExplore.size());
                    }
                }
            }
        }

        return Optional.empty();
    }

}
