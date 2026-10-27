/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package main.java.edu.nova.csc223.module1;

import java.util.Comparator;
import java.util.Objects;

public class ProjectTaskPriorityComparator implements Comparator<ProjectTask> {

    @Override
    public int compare(ProjectTask first, ProjectTask second) {
        Objects.requireNonNull(first, "First task cannot be null.");

        Objects.requireNonNull(second, "Second task cannot be null.");

        int priorityResult = Integer.compare(second.getPriority(), first.getPriority());

        if (priorityResult != 0) {
            return priorityResult;
        }

        return first.getTaskId().compareTo(second.getTaskId());
    }

}
