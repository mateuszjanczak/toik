package com.mateuszjanczak;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stack implements StackOperations {

    private final ArrayList<String> stackList;

    public Stack() {
        this.stackList = new ArrayList<>();
    }

    @Override
    public List<String> get() {
        return stackList;
    }

    @Override
    public Optional<String> pop() {
        if(stackList.isEmpty()) {
            return Optional.empty();
        }
        Optional<String> lastItem = Optional.of(stackList.get(stackList.size() - 1));
        stackList.remove(stackList.size() - 1);
        return lastItem;
    }

    @Override
    public void push(String item) {
        stackList.add(item);
    }
}
