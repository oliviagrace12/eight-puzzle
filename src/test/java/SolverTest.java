import domain.Node;
import domain.State;
import logic.Solver;
import org.junit.Test;

import java.util.List;

/**
 * Created by oliviachisman on 4/14/20
 */
public class SolverTest {

    private final List<Integer> solution = List.of(1, 2, 3, 8, 0, 4, 7, 6, 5);

    @Test
    public void testBfsEasy() {
        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));
        Node root = new Node(initState, null);

        Node result = new Solver().solveWithBreadthFirstSearch(root).get();

        assert result.getState().getNums().equals(solution);
    }

    @Test
    public void testBfsMedium() {
        State initState = new State(List.of(2, 8, 1, 0, 4, 3, 7, 6, 5));
        Node root = new Node(initState, null);

        Node result = new Solver().solveWithBreadthFirstSearch(root).get();

        assert result.getState().getNums().equals(solution);
    }

    @Test
    public void testBfsHard() {
        State initState = new State(List.of(5, 6, 7, 4, 0, 8, 3, 2, 1));
        Node root = new Node(initState, null);

        Node result = new Solver().solveWithBreadthFirstSearch(root).get();

        assert result.getState().getNums().equals(solution);
    }
}
