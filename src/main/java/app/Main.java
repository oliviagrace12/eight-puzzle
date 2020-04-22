package app;

import domain.Node;
import domain.State;
import logic.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

/**
 * Created by oliviachisman on 4/10/20
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting up Eight Puzzle Solver");
        System.out.println("Type <quit> to exit \n");

        HashMap<Integer, Node> rootNodes = new HashMap<>();
        rootNodes.put(1, new Node(new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5))));
        rootNodes.put(2, new Node(new State(List.of(2, 8, 1, 0, 4, 3, 7, 6, 5))));
        rootNodes.put(3, new Node(new State(List.of(5, 6, 7, 4, 0, 8, 3, 2, 1))));

        HashMap<Integer, Solver> solvers = new HashMap<>();
        solvers.put(1, new BreadthFirstSolver());
        solvers.put(2, new DepthFirstSolver());
        solvers.put(3, new UniformCostSolver());
        solvers.put(4, new GreedyBestFirstSolver());
        solvers.put(5, new AStarMisplacedSolver());
        solvers.put(6, new AStarManhattanSolver());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Choose your solver by typing a number from the following:");
            System.out.println("(1) Breadth-First Search");
            System.out.println("(2) Depth-First Search");
            System.out.println("(3) Uniform Cost Search");
            System.out.println("(4) Greedy Best-First Search");
            System.out.println("(5) A* Search (heuristic: number of misplaced tiles)");
            System.out.println("(6) A* Search (heuristic: sum Manhattan distances of all tiles from goal locations");

            String solverChoice = reader.readLine();
            Solver solver = solvers.get(Integer.parseInt(solverChoice));

            System.out.println("Choose the difficulty or your starting state:");
            System.out.println("(1) Easy");
            System.out.println("(2) Medium");
            System.out.println("(3) Hard");

            String difficultyChoice = reader.readLine();
            Node root = rootNodes.get(Integer.parseInt(difficultyChoice));

            Node solution = solver.solve(root).get();

            System.out.println("Found solution: ");
            System.out.println("---------------SOLUTION---------------");
            System.out.println(solution);
            System.out.println("-------------END SOLUTION-------------");
            System.out.println("\n");
        }

    }

}
