package app;

import domain.Node;
import domain.State;
import logic.*;

import java.util.List;

/**
 * Created by oliviachisman on 4/22/20
 */
public class QuickRunner {

    public void run() {
        for (int j = 1; j < 4; j++) {
            for (int i = 1; i < 7; i++) {
                Solver solver = getSolver(i);
                Node solution = solver.solve(getRoot(j)).get();

                System.out.println("Found solution for " + solver.getClass().getName() + ", difficulty " + j);
                System.out.println("LENGTH: " + solution.getPathLength());
                System.out.println("COST: " + solution.getPathCost());
                System.out.println("TIME: " + solver.getTime());
                System.out.println("SPACE: " + solver.getSpace());
            }
        }
    }

    private Node getRoot(int difficulty) {
        switch (difficulty) {
            case 2:
                return new Node(new State(List.of(2, 8, 1, 0, 4, 3, 7, 6, 5)));
            case 3:
                return new Node(new State(List.of(5, 6, 7, 4, 0, 8, 3, 2, 1)));
            default:
                return new Node(new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5)));
        }
    }

    private Solver getSolver(int solverChoice) {
        switch (solverChoice) {
            case 1:
                return new BreadthFirstSolver();
            case 2:
                return new DepthFirstSolver();
            case 3:
                return new UniformCostSolver();
            case 4:
                return new GreedyBestFirstSolver();
            case 5:
                return new AStarMisplacedSolver();
            default:
                return new AStarManhattanSolver();
        }
    }
}
