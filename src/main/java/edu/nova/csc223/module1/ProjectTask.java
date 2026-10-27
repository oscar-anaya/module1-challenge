/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package main.java.edu.nova.csc223.module1;

import java.util.Objects;

public final class ProjectTask implements Comparable<ProjectTask> {
    private final String taskId;
    private final String title;
    private final int priority;

    public ProjectTask(
            String taskId,
            String title,
            int priority) {

        validateTaskId(taskId);
        validateTitle(title);
        validatePriority(priority);

        this.taskId = taskId;
        this.title = title;
        this.priority = priority;
    }

    /**
     * Getter methods for taskID, title, priority
     * @return String
     */
    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    /**
     *The class must implement Comparable<ProjectTask>
     * - Natural order is based on taskId
     *
     * @param other
     * @return int
     */
    @Override
    public int compareTo(ProjectTask other) {
        Objects.requireNonNull(other, "Other task cannot be null.");

        return taskId.compareTo(other.taskId);
    }

    /**
     * Logical equality must be based on task ID
     *
     * @param object
     * @return int
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ProjectTask other)) {
            return false;
        }

        return taskId.equals(other.taskId);
    }

    /**
     * hashCode must remain consistent with equals
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    /**
     *The class must provide a readable toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return getTaskId() + " | priority=" + getPriority() + " | " + getTitle();
    }


    /**
     * Validate taskID for constructor
     * - Must not be null or blank
     *
     * @param taskId
     */
    private static void validateTaskId(String taskId) {
        if (taskId == null || taskId.isBlank()) {
            throw new IllegalArgumentException( "Task ID is required.");
        }
    }

    /**
     * Validate title for constructor
     * - Must not be null or blank
     *
     * @param title
     */
    private static void validateTitle(String title) {

        if (title == null || title.isBlank()) {

            throw new IllegalArgumentException( "Title is required.");
        }
    }

    /**
     * validate priority for constructor.
     * - Must be between 1 and 5
     *
     * @param priority
     */
    private static void validatePriority(int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 1 and 5.");
        }
    }
}
