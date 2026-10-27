/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package test.java.edu.nova.csc223.module1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.java.edu.nova.csc223.module1.*;

public class SequenceSearchTest {

    /**
     * Test search target found
     */
    @Test
    void sequentialSearchReturnsMatchingIndex() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");
        sequence.add("Beta");
        sequence.add("Gamma");

        int index =
                SequenceSearch.findFirst(sequence, "Beta");

        assertEquals(1, index);
    }

    /**
     * Test search target missing
     */
    @Test
    void sequentialSearchReturnsMinusOneWhenMissing() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");

        int index = SequenceSearch.findFirst(sequence, "Gamma");

        assertEquals(-1, index);
    }

    /**
     * Test duplicate search target returns first match
     */
    @Test
    void sequentialSearchReturnsFirstDuplicate() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        sequence.add("Alpha");
        sequence.add("Beta");
        sequence.add("Alpha");

        int index =
                SequenceSearch.findFirst(sequence, "Alpha");

        assertEquals(0, index);
    }

    /**
     * Test search works with task equality
     */
    @Test
    void sequentialSearchWorksWithTaskEquality() {
        TaskSequence<ProjectTask> sequence = new ResizableTaskSequence<>();

        sequence.add( new ProjectTask("T-101", "Original", 2));

        ProjectTask equivalent = new ProjectTask("T-101", "Different text", 5);

        int index = SequenceSearch.findFirst(sequence, equivalent);

        assertEquals(0, index);
    }

    /**
     * Test search of an empty sequence
     */
    @Test
    void sequentialSearchReturnsMinusOneForEmptySequence() {
        TaskSequence<String> sequence = new ResizableTaskSequence<>();

        int index = SequenceSearch.findFirst(sequence, "Alpha");

        assertEquals(-1, index);
    }

    /**
     * Test null sequence rejection
     */
    @Test
    void sequentialSearchRejectsNullSequence() {
        assertThrows(IllegalArgumentException.class, () -> SequenceSearch.findFirst(null, "Alpha"));
    }
}
