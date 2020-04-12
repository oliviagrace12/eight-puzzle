package main.java;

import main.java.domain.Node;
import main.java.domain.State;
import main.java.logic.StateTransformer;

import java.util.List;

import static main.java.domain.Action.DOWN;
import static main.java.domain.Action.UP;

/**
 * Created by oliviachisman on 4/10/20
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting up Eight Puzzle Solver");

        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));
        System.out.println(initState);
        StateTransformer transformer = new StateTransformer();
        State state2 = transformer.transform(initState, UP);

//        Node root = new Node(initState, null, );

        System.out.println(state2);

        State state3 = transformer.transform(state2, DOWN);

        System.out.println(state3);

    }
}
