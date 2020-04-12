package main.java.domain;

import java.util.Arrays;
import java.util.List;

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
    public String toString() {
        return "\t[" + nums.get(0) + " " + nums.get(1) + " " + nums.get(2) + "]\n" +
                "\t[" + nums.get(3) + " " + nums.get(4) + " " + nums.get(5) + "]\n" +
                "\t[" + nums.get(6) + " " + nums.get(7) + " " + nums.get(8) + "]\n" +
                "blank location: " + blank + "\n";
    }



}
