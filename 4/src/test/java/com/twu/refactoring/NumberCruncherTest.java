package com.twu.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberCruncherTest {

    NumberCruncher numberCruncher1 = new NumberCruncher(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    NumberCruncher numberCruncher2 = new NumberCruncher(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4);

    @Test
    public void shouldCountEvenNumbers() {
        Assertions.assertEquals(5,numberCruncher1.countEven());
    }

    @Test
    public void shouldCountOddNumbers() {
        Assertions.assertEquals(6,numberCruncher1.countOdd());
    }

    @Test
    public void shouldCountPositiveNumbers() {
        Assertions.assertEquals(5,numberCruncher2.countPositive());
    }

    @Test
    public void shouldCountNegativeNumbers() {
        Assertions.assertEquals(5,numberCruncher2.countNegative());
    }
}
