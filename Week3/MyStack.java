package Week3;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private final List<Integer> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    public void push(int value) {
        stackValues.add(value);
    }

    public Integer pop() {
        if (stackValues.isEmpty()) return null;
        return stackValues.remove(stackValues.size() - 1);
    }

    public Integer get() {
        if (stackValues.isEmpty()) return null;
        return stackValues.get(stackValues.size() - 1);
    }

    public boolean isEmpty() {
        return stackValues.isEmpty();
    }

    public List<Integer> getAllValues() {
        return new ArrayList<>(stackValues); // tránh lộ nội dung gốc
    }
}
