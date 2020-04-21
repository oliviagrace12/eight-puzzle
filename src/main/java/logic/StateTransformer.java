package logic;

import domain.Action;
import domain.Node;
import domain.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by oliviachisman on 4/11/20
 */
public class StateTransformer {

    private State goalState = new State(List.of(1, 2, 3, 8, 0, 4, 7, 6, 5));

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

        State newState = new State(newNums);

        return new Node(newState, Action.UP, valueToMove, findNumberMisplacedTiles(newState), findSumOfManhattanDistances(newState));
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

        State newState = new State(newNums);

        return new Node(newState, Action.DOWN, valueToMove, findNumberMisplacedTiles(newState), findSumOfManhattanDistances(newState));
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

        State newState = new State(newNums);

        return new Node(newState, Action.LEFT, valueToMove, findNumberMisplacedTiles(newState), findSumOfManhattanDistances(newState));
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

        State newState = new State(newNums);

        return new Node(newState, Action.RIGHT, valueToMove, findNumberMisplacedTiles(newState), findSumOfManhattanDistances(newState));
    }

    public int findNumberMisplacedTiles(State state) {
        int misplaced = 0;
        for (int i = 0; i < state.getNums().size() - 1; i++) {
            if (!state.getNums().get(i).equals(goalState.getNums().get(i))) {
                misplaced++;
            }
        }
        return misplaced;
    }

    public int findSumOfManhattanDistances(State state) {
        int sum = 0;
        for (int i = 0; i < state.getNums().size(); i++) {
            int goalPosition = goalState.getNums().indexOf(state.getNums().get(i));
            sum += getDistance(i, goalPosition);
        }
        return sum;
    }

    private int getDistance(int currentPosition, int goalPosition) {
        int x1 = getRow(currentPosition);
        int y1 = getCol(currentPosition);
        int x2 = getRow(goalPosition);
        int y2 = getCol(goalPosition);
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    private int getCol(int position) {
        switch (position) {
            case 0:
            case 3:
            case 6:
                return 0;
            case 1:
            case 4:
            case 7:
                return 1;
            case 2:
            case 5:
            case 8:
                return 2;
        }
        return 0;
    }

    private int getRow(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
            case 5:
                return 1;
            case 6:
            case 7:
            case 8:
                return 2;
        }
        return 0;
    }
}
