package com.twu.refactoring;

import java.util.HashMap;
import java.util.Map;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        Map<Character, Character> turnR = new HashMap<>();
        turnR.put('N', 'E');
        turnR.put('S', 'W');
        turnR.put('E', 'N');
        turnR.put('W', 'S');
        if (turnR.containsKey(direction)) {
            return new Direction(turnR.get(direction));
        }
        throw new IllegalArgumentException();
    }

    public Direction turnLeft() {
        Map<Character, Character> turnL = new HashMap<>();
        turnL.put('N', 'W');
        turnL.put('S', 'E');
        turnL.put('E', 'N');
        turnL.put('W', 'S');
        if (turnL.containsKey(direction)) {
            return new Direction(turnL.get(direction));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
