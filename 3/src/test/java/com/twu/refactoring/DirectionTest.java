package com.twu.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;

    @BeforeEach
    public void setUp() throws Exception {
        north = new Direction('N');
        east = new Direction('E');
    }

    @Test
    public void shouldTurnEastWhenTurnRightFromNorth() {
        Direction east = north.turnRight();
        Assertions.assertEquals('E', east.getDirection());
    }

    @Test
    public void shouldTurnWestWhenTurnLeftFromNorth() {
        Direction west = north.turnLeft();
        Assertions.assertEquals('W', west.getDirection());

    }

    @Test
    public void shouldTurnNorthWhenTurnLeftFromEast() {
        Direction north = east.turnLeft();
        Assertions.assertEquals('N', north.getDirection());
    }
}
