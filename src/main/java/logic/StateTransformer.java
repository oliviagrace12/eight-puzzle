package logic;

import domain.Action;
import domain.Node;
import domain.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliviachisman on 4/11/20
 */
public class StateTransformer {

    public Node transform(State initState, Action action) {

        switch (action) {
            case UP:
                return moveUp(initState);
            case DOWN:
                return moveDown(initState);
            case LEFT:
                return modeLeft(initState);
            case RIGHT:
                return moveRight(initState);
        }

        return null;
    }

    private Node moveUp(State initState) {
        int initBlank = initState.getBlank();
        if (initBlank == 0 || initBlank == 1 || initBlank == 2) {
            System.out.println("ERROR: Cannot move up from top row");
            return null;
        }
        List<Integer> newNums = new ArrayList<>(initState.getNums());
        int newBlankIndex = initBlank - 3;
        int valueToMove = initState.getNums().get(newBlankIndex);

        newNums.set(newBlankIndex, 0);
        newNums.set(initBlank, valueToMove);

        return new Node(new State(newNums), Action.UP, valueToMove);
    }

    private Node moveDown(State initState) {
        int initBlank = initState.getBlank();
        if (initBlank == 6 || initBlank == 7 || initBlank == 8) {
            System.out.println("ERROR: Cannot move down from bottom row");
            return null;
        }
        List<Integer> newNums = new ArrayList<>(initState.getNums());
        int newBlankIndex = initBlank + 3;
        int valueToMove = initState.getNums().get(newBlankIndex);

        newNums.set(newBlankIndex, 0);
        newNums.set(initBlank, valueToMove);

        return new Node(new State(newNums), Action.DOWN, valueToMove);
    }

    private Node modeLeft(State initState) {
        int initBlank = initState.getBlank();
        if (initBlank == 0 || initBlank == 3 || initBlank == 6) {
            System.out.println("ERROR: Cannot move left from leftmost row");
            return null;
        }
        List<Integer> newNums = new ArrayList<>(initState.getNums());
        int newBlankIndex = initBlank - 1;

        int valueToMove = initState.getNums().get(newBlankIndex);

        newNums.set(newBlankIndex, 0);
        newNums.set(initBlank, valueToMove);

        return new Node(new State(newNums), Action.LEFT, valueToMove);
    }

    private Node moveRight(State initState) {
        int initBlank = initState.getBlank();
        if (initBlank == 2 || initBlank == 5 || initBlank == 8) {
            System.out.println("ERROR: Cannot move left from leftmost row");
            return null;
        }
        List<Integer> newNums = new ArrayList<>(initState.getNums());
        int newBlankIndex = initBlank + 1;

        int valueToMove = initState.getNums().get(newBlankIndex);

        newNums.set(newBlankIndex, 0);
        newNums.set(initBlank, valueToMove);

        return new Node(new State(newNums), Action.RIGHT, valueToMove);
    }

}
