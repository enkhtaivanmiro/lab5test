package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Test for both LinkedIntQueue and ArrayIntQueue
 */
public class IntQueueTest {

    private IntQueue ArrayIntQueue; // Test Interface
    private List<Integer> testList;

    @Before
    public void setUp() {
        // For LinkedIntQueue:
        ArrayIntQueue = new LinkedIntQueue();
        // For ArrayIntQueue:
        // ArrayIntQueue = new ArrayIntQueue();

        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(ArrayIntQueue.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        ArrayIntQueue.enqueue(5);
        assertFalse(ArrayIntQueue.isEmpty());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertNull(ArrayIntQueue.peek());
    }

    @Test
    public void testPeekNoEmptyQueue() {
        ArrayIntQueue.enqueue(10);
        ArrayIntQueue.enqueue(20);
        assertEquals(Integer.valueOf(10), ArrayIntQueue.peek());
    }

    @Test
    public void testEnqueue() {
        for (int i = 0; i < testList.size(); i++) {
            ArrayIntQueue.enqueue(testList.get(i));
            assertEquals(testList.get(0), ArrayIntQueue.peek());
            assertEquals(i + 1, ArrayIntQueue.size());
        }
    }

    @Test
    public void testDequeue() {
        for (int i = 0; i < testList.size(); i++) {
            ArrayIntQueue.enqueue(testList.get(i));
        }

        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testList.get(i), ArrayIntQueue.dequeue());
        }

        assertTrue(ArrayIntQueue.isEmpty());
    }

    @Test
    public void testEnsureCapacity() {
        for (int i = 0; i < 20; i++) {
            ArrayIntQueue.enqueue(i);
        }
        assertEquals(20, ArrayIntQueue.size());
    }

    @Test
    public void testClear() {
        ArrayIntQueue.enqueue(10);
        ArrayIntQueue.enqueue(20);
        ArrayIntQueue.clear();
        assertTrue(ArrayIntQueue.isEmpty());
    }
}
