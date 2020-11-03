package com.mateuszjanczak;

import java.util.List;
import java.util.Optional;

public interface StackOperations {
    List<String> get();
    Optional<String> pop();
    void push (final String item);
}
