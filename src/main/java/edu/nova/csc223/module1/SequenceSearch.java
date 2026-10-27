/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package main.java.edu.nova.csc223.module1;

import java.util.Objects;

public final class SequenceSearch {

    private SequenceSearch() {
    }

    /**
     * Generic sequence search method
     * - Reject null sequence
     * - Search from index 0 forward
     * - use logical equality
     * - Return first matching index or -1 when no match exists
     * - Leave sequence unchanged
     *
     * @param sequence
     * @param target
     * @return int
     * @param <T>
     */
    public static <T> int findFirst( TaskSequence<T> sequence, T target){

        if (sequence == null) {
            throw new IllegalArgumentException("Sequence cannot be null.");
        }

        for (int index = 0; index < sequence.size(); index++) {

            if (Objects.equals(sequence.get(index), target)) {

                return index;
            }
        }

        return -1;
    }
}
