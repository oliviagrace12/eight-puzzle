package app;

import domain.Node;
import domain.State;
import logic.AStarManhattanSolver;
import logic.BreadthFirstSolver;

import java.util.List;

/**
 * Created by oliviachisman on 4/10/20
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting up Eight Puzzle Solver");

        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));

        Node root = new Node(initState, null, 0, 0, 0, null);

        Node solution = new AStarManhattanSolver().solve(root).get();

        System.out.println("Solution: \n" + solution);
    }
}
