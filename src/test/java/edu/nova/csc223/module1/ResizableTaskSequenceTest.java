package test.java.edu.nova.csc223.module1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.java.edu.nova.csc223.module1.*;

public class ResizableTaskSequenceTest {

    /**
     * Test New sequence size and empty state
     */
    @Test
    void newSequenceIsEmpty() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        assertTrue(sequence.isEmpty());
        assertEquals(0, sequence.size());
    }

    /**
     * Test addition and insertion-order retrieval
     */
    @Test
    void addStoresElementsInInsertionOrder() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");
        sequence.add("Beta");
        sequence.add("Gamma");

        assertEquals(3, sequence.size());
        assertEquals("Alpha", sequence.get(0));
        assertEquals("Beta", sequence.get(1));
        assertEquals("Gamma", sequence.get(2));
    }

    /**
     * Test null addition with unchanged state
     */
    @Test
    void addRejectsNullWithoutChangingState() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        assertThrows(IllegalArgumentException.class, () -> sequence.add(null));

        assertTrue(sequence.isEmpty());
        assertEquals(0, sequence.size());
    }

    /**
     *Test index immediately below the valid range
     */
     @Test
    void getRejectsIndexBelowRange() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");

        assertThrows(IndexOutOfBoundsException.class, () -> sequence.get(-1));
    }

    /**
     * Test index immediately above the valid range
     */
    @Test
    void getRejectsIndexAboveRange() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");

        assertThrows(IndexOutOfBoundsException.class, () -> sequence.get(1));
    }

    /**
     * Test first and last valid index
     */
    @Test
    void getRetrievesFirstAndLastValidIndex() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();
        sequence.add("Alpha");
        sequence.add("Beta");
        sequence.add("Gamma");

        assertEquals("Alpha", sequence.get(0));
        assertEquals("Gamma", sequence.get(2));
    }


    /**
     * Test removal from the first position
     */
    @Test
    void removeFirstElementUpdatesState() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");
        sequence.add("Beta");

        String removed = sequence.remove(0);

        assertEquals("Alpha", removed);
        assertEquals(1, sequence.size());
        assertEquals("Beta", sequence.get(0));
    }

    /**
     * Test removal from a middle position
     */
    @Test
    void removeMiddlePreservesRemainingOrder() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");
        sequence.add("Beta");
        sequence.add("Gamma");

        String removed = sequence.remove(1);

        assertEquals("Beta", removed);
        assertEquals(2, sequence.size());
        assertEquals("Alpha", sequence.get(0));
        assertEquals("Gamma", sequence.get(1));
    }


    /**
     * Test removal from last position
     */
    @Test
    void removeLastElementUpdatesState() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");
        sequence.add("Beta");

        String removed = sequence.remove(1);

        assertEquals("Beta", removed);
        assertEquals(1, sequence.size());
        assertEquals("Alpha", sequence.get(0));
    }

    /**
     * Test resizing with full data preservation
     */
    @Test
    void resizingPreservesAllElements() {
        TaskSequence<Integer> sequence = new ResizableTaskSequence<>(2);

        for (int value = 1; value <= 8; value++) {

            sequence.add(value);
        }

        assertEquals(8, sequence.size());

        for (int index = 0; index < 8; index++) {

            assertEquals(index + 1, sequence.get(index));
        }
    }
}
