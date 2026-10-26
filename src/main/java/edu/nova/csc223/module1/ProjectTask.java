/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package main.java.edu.nova.csc223.module1;

public class ProjectTask {
    String taskId;
    String title;
    int priority;

    public ProjectTask(
            String taskId,
            String title,
            int priority) {

        //validateTaskId(taskId);
        //validateDescription(title);
        //validatePriority(priority);

        this.taskId = taskId;
        this.title = title;
        this.priority = priority;
    }

}
