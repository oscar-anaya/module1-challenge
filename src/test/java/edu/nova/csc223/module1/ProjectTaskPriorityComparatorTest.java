/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package test.java.edu.nova.csc223.module1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import main.java.edu.nova.csc223.module1.*;

public class ProjectTaskPriorityComparatorTest {
    private final Comparator<ProjectTask> comparator = new ProjectTaskPriorityComparator();

    /**
     * Test priority ordering
     */
    @Test
    void higherPriorityComesFirst() {
        ProjectTask high = new ProjectTask("T-200", "High", 5);

        ProjectTask low = new ProjectTask("T-100", "Low", 1);

        assertTrue(comparator.compare(high, low) < 0);
    }

    /**
     * Test priority task-breaking by task Id
     */
    @Test
    void equalPriorityUsesTaskId() {
        ProjectTask first = new ProjectTask("T-101", "First", 3);

        ProjectTask second = new ProjectTask("T-102", "Second", 3);

        assertTrue(comparator.compare(first, second) < 0);
    }

    /**
     * Test a task compared against itself
     */
    @Test
    void sameTaskComparesAsEqual() {
        ProjectTask task = new ProjectTask("T-101", "Task", 3);

        assertEquals(0, comparator.compare(task, task));
    }
}
