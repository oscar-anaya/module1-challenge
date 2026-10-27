/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package test.java.edu.nova.csc223.module1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.java.edu.nova.csc223.module1.ProjectTask;

public class ProjectTaskTest {

    /**
     * Test valid task constructor
     */
    @Test
    void constructorCreatesValidTask() {
        ProjectTask task = new ProjectTask("T-101", "Resolve login issue", 5);

        assertEquals("T-101", task.getTaskId());
        assertEquals("Resolve login issue", task.getTitle());
        assertEquals(5, task.getPriority());
    }

    /**
     * Test invalid taskId
     */
    @Test
    void constructorRejectsBlankId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask(" ", "Valid title", 3));
    }

    /**
     * Test invalid priority
     */
    @Test
    void constructorRejectsInvalidPriority() {
        assertThrows(
                IllegalArgumentException.class, () -> new ProjectTask("Valid taskId", "Valid title", 6));
    }

    /**
     * Test equality and valid hash codes
     */
    @Test
    void tasksWithSameIdAreEqual() {
        ProjectTask first = new ProjectTask("T-101", "First", 2);

        ProjectTask second = new ProjectTask("T-101", "Second", 5);

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    /**
     * Test natural ordering by taskId
     */
    @Test
    void compareToUsesTaskId() {
        ProjectTask first = new ProjectTask("T-101", "First", 5);

        ProjectTask second = new ProjectTask("T-102", "Second", 1);

        assertTrue(first.compareTo(second) < 0);
        assertTrue(second.compareTo(first) > 0);
        assertEquals(0, first.compareTo(first));
    }
}
