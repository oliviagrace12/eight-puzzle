import domain.Node;
import domain.State;
import logic.AStarMisplacedSolver;
import org.junit.Test;

import java.util.List;

/**
 * Created by oliviachisman on 4/14/20
 */
public class AStarMisplacedSolverTest {

    private final List<Integer> solution = List.of(1, 2, 3, 8, 0, 4, 7, 6, 5);

    @Test
    public void testAStarEasy() {
        State initState = new State(List.of(1, 3, 4, 8, 6, 2, 7, 0, 5));
        Node root = new Node(initState, null, 0, 0, 0);

        Node result = new AStarMisplacedSolver().solve(root).get();

        assert result.getState().getNums().equals(solution);
    }

    @Test
    public void testAStarMedium() {
        State initState = new State(List.of(2, 8, 1, 0, 4, 3, 7, 6, 5));
        Node root = new Node(initState, null, 0, 0, 0);

        Node result = new AStarMisplacedSolver().solve(root).get();

        assert result.getState().getNums().equals(solution);
    }

    @Test
    public void testAStarHard() {
        State initState = new State(List.of(5, 6, 7, 4, 0, 8, 3, 2, 1));
        Node root = new Node(initState, null, 0, 0, 0);

        Node result = new AStarMisplacedSolver().solve(root).get();

        assert result.getState().getNums().equals(solution);
    }
}
