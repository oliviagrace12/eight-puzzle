package logic;

import domain.Action;
import domain.Node;
import domain.State;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 * Created by oliviachisman on 4/14/20
 */
public class AStarMisplacedSolver extends Solver {

    @Override
    public Optional<Node> solve(Node node) {
        if (isGoalState(node.getState())) {
            return Optional.of(node);
        }

        HashSet<State> explored = new HashSet<>();
        PriorityQueue<Node> toExplore = new PriorityQueue<>(Comparator.comparing(n -> n.getPathCost() + n.getMisplacedTiles()));
        toExplore.add(node);

        Node current;
        while (!toExplore.isEmpty()) {
            current = toExplore.remove();
            explored.add(current.getState());

            for (Action action : possibleActions.get(current.getState().getBlank())) {
                Node childNode = stateTransformer.transform(current.getState(), action);
                if (!explored.contains(childNode.getState()) && !toExplore.contains(childNode)) {
                    if (isGoalState(childNode.getState())) {
                        return Optional.of(childNode);
                    } else {
                        toExplore.add(childNode);
                    }
                }
            }
        }

        return Optional.empty();
    }

}
