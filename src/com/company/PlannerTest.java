package com.company;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlannerTest {

    @Test
    public void defaultConstructor() {
        Planner expected = new Planner();
        Assert.assertEquals(expected.getMonthNumber(), 1);
        String[] actual = new String[0];
        Assert.assertArrayEquals(expected.info(31), actual);
    }

    @Test
    public void constructor() {
        String[][] testDays = new String[][]{
                {"Купить пиво"},
                {"A", "Побриться", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"Помыть кота"},
        };
        Planner expected = new Planner(2, testDays);
        Assert.assertEquals(expected.getMonthNumber(), 2);
        Assert.assertArrayEquals(expected.info(28), testDays[27]);
        Assert.assertArrayEquals(expected.info(1), testDays[0]);
    }

    @Test
    public void add() {
        Planner expected = new Planner();
        String[] test = new String[0];
        String[] actual = new String[]{"Wash car"};
        Assert.assertArrayEquals(expected.info(1), test);
        expected.add(1, "Wash car");
        Assert.assertArrayEquals(expected.info(1), actual);
    }

    @Test
    public void nextUp() {
        Planner expected = new Planner(2);
        expected.add(28, "Test task 1");
        expected.next();
        String[] test = new String[]{"Test task 1"};
        String[] test2 = new String[0];
        Assert.assertArrayEquals(expected.info(28), test);
        Assert.assertArrayEquals(expected.info(31), test2);
    }

    @Test
    public void nextDown() {
        Planner expected = new Planner(3);
        expected.add(31, "Test task 1");
        expected.add(30, "Test task 2");
        expected.next();
        String[] test = new String[]{"Test task 2", "Test task 1"};
        Assert.assertArrayEquals(expected.info(30), test);
    }
}