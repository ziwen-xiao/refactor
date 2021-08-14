package com.twu.refactoring;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public Direction turnRight() {
        switch (direction) {
            case 'N':
                return new Direction('E');
            case 'S':
                return new Direction('W');
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft() {
        switch (direction) {
            case 'N':
                return new Direction('W');
            case 'S':
                return new Direction('E');
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }

}
