package app;

import domain.Node;
import domain.State;
import logic.Solver;

import java.util.List;

/**
 * Created by oliviachisman on 4/10/20
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting up Eight Puzzle Solver");

        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));

        Node root = new Node(initState, null);

        Node solution = new Solver().solveWithBreadthFirstSearch(root).get();

        System.out.println("Solution: \n" + solution);
    }
}
