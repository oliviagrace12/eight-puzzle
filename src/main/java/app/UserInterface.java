package app;

import domain.Node;
import domain.State;
import logic.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by oliviachisman on 4/22/20
 */
public class UserInterface {

    public void run() throws IOException {
        System.out.println("Starting up Eight Puzzle Solver");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            askForSolverChoice();

            String solverChoice = reader.readLine();
            Solver solver = getSolver(Integer.parseInt(solverChoice));

            askForDifficultyChoice();

            String difficultyChoice = reader.readLine();
            Node root = getRoot(Integer.parseInt(difficultyChoice));

            Node solution = solver.solve(root).get();

            printSolution(solution, solver);
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

    private void askForSolverChoice() {
        System.out.println("Choose your solver by typing a number from the following:");
        System.out.println("(1) Breadth-First Search");
        System.out.println("(2) Depth-First Search");
        System.out.println("(3) Uniform Cost Search");
        System.out.println("(4) Greedy Best-First Search");
        System.out.println("(5) A* Search (heuristic: number of misplaced tiles)");
        System.out.println("(6) A* Search (heuristic: sum Manhattan distances of all tiles from goal locations");
    }

    private void askForDifficultyChoice() {
        System.out.println("Choose the difficulty or your starting state:");
        System.out.println("(1) Easy");
        System.out.println("(2) Medium");
        System.out.println("(3) Hard");
    }

    private void printSolution(Node solution, Solver solver) {
        System.out.println("Found solution: ");
        System.out.println("LENGTH: " + solution.getPathLength());
        System.out.println("COST: " + solution.getPathCost());
        System.out.println("TIME: " + solver.getTime());
        System.out.println("SPACE: " + solver.getSpace());
        System.out.println("---------------SOLUTION---------------");
        System.out.println(solution);
        System.out.println("-------------END SOLUTION-------------");
        System.out.println("\n");
    }
}
