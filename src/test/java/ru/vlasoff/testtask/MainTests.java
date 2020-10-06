package ru.vlasoff.testtask;

import static org.junit.Assert.*;

import org.junit.Test;

// немного тестов
// просто чтоб было
public class MainTests {

    @Test
    public void test1() {
        int[] testArray = Main.getArr(15);
        int[] testArrayAfterDelete = Main.deleteRandomElement(testArray);
        assertEquals(testArrayAfterDelete.length, testArray.length - 1);
    }
}
