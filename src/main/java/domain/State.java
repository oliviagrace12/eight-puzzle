package domain;

import java.util.List;
import java.util.Objects;

/**
 * Created by oliviachisman on 4/11/20
 */
public class State {

    private final List<Integer> nums;
    private final int blank;

    public State(List<Integer> numbersInOrder) {
        nums = numbersInOrder;
        blank = nums.indexOf(0);
    }

    public List<Integer> getNums() {
        return nums;
    }

    public int getBlank() {
        return blank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return blank == state.blank &&
                Objects.equals(nums, state.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums, blank);
    }

    @Override
    public String toString() {
        return "\t[" + nums.get(0) + " " + nums.get(1) + " " + nums.get(2) + "]\n" +
                "\t[" + nums.get(3) + " " + nums.get(4) + " " + nums.get(5) + "]\n" +
                "\t[" + nums.get(6) + " " + nums.get(7) + " " + nums.get(8) + "]\n" +
                "blank location: " + blank + "\n";
    }


}
