package main.java.logic;

import main.java.domain.Action;
import main.java.domain.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliviachisman on 4/11/20
 */
public class StateTransformer {

    public State transform(State initState, Action action) {
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

    private State moveUp(State initState) {
        int initBlank = initState.getBlank();
        if (initBlank == 0 || initBlank == 1 || initBlank == 2) {
            System.out.println("ERROR: Cannot move up from top row");
            return initState;
        }
        List<Integer> newNums = new ArrayList<>(initState.getNums());
        int newBlankIndex = initBlank - 3;
        int valueToMove = initState.getNums().get(newBlankIndex);

        newNums.set(newBlankIndex, 0);
        newNums.set(initBlank, valueToMove);

        return new State(newNums);
    }

    private State moveDown(State initState) {
        int initBlank = initState.getBlank();
        if (initBlank == 6 || initBlank == 7 || initBlank == 8) {
            System.out.println("ERROR: Cannot move down from bottom row");
            return initState;
        }
        List<Integer> newNums = new ArrayList<>(initState.getNums());
        int newBlankIndex = initBlank + 3;
        int valueToMove = initState.getNums().get(newBlankIndex);

        newNums.set(newBlankIndex, 0);
        newNums.set(initBlank, valueToMove);

        return new State(newNums);
    }

    private State modeLeft(State initState) {
        return null;
    }

    private State moveRight(State initState) {
        return null;
    }

    private State deepCopy(State initState) {
        return new State(new ArrayList<>(initState.getNums()));
    }

}
