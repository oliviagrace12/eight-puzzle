import domain.Node;
import domain.State;
import logic.StateTransformer;
import org.junit.Test;

import java.util.List;

import static domain.Action.*;

/**
 * Created by oliviachisman on 4/13/20
 */
public class StateTransformerTest {

    @Test
    public void testUpDown() {
        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));
        System.out.println(initState);

        StateTransformer transformer = new StateTransformer();
        Node node2 = transformer.transform(initState, UP);
        System.out.println(node2);

        Node node3 = transformer.transform(node2.getState(), DOWN);
        System.out.println(node3);

        assert node2.getState().getNums().equals(List.of(1, 3, 4, 8, 0, 2, 7, 6, 5));
        assert node3.getState().getNums().equals(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));
    }

    @Test
    public void testLeft() {
        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));
        System.out.println(initState);

        StateTransformer transformer = new StateTransformer();
        Node node2 = transformer.transform(initState, LEFT);
        System.out.println(node2.getState());

        assert node2.getState().getNums().equals(List.of(1, 3, 4, 8, 6, 2, 0, 7, 5));
    }

    @Test
    public void testRight() {
        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));
        System.out.println(initState);

        StateTransformer transformer = new StateTransformer();
        Node node2 = transformer.transform(initState, RIGHT);
        System.out.println(node2.getState());

        assert node2.getState().getNums().equals(List.of(1, 3, 4, 8, 6, 2, 7, 5, 0));
    }

    @Test
    public void testNumberMisplaced() {
        State initState = new State(List.of(7, 2, 3, 8, 0, 4, 1, 6, 5));
        StateTransformer transformer = new StateTransformer();

        assert transformer.findNumberMisplacedTiles(initState) == 2;
    }

    @Test
    public void testManhattanDistance() {
        State initState = new State(List.of(7, 2, 3, 8, 0, 4, 1, 6, 5));
        StateTransformer transformer = new StateTransformer();

        assert transformer.findSumOfManhattanDistances(initState) == 4;
    }

    @Test
    public void testManhattanDistance2() {
        State initState = new State(List.of(5, 2, 3, 8, 0, 4, 7, 6, 1));
        StateTransformer transformer = new StateTransformer();

        assert transformer.findSumOfManhattanDistances(initState) == 8;
    }
}
