/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package main.java.edu.nova.csc223.module1;

public interface TaskSequence<T> {

    /**
     * Adds a non-null element to the end.
     *
     * @param element the element to add
     * @throws IllegalArgumentException
     *         if element is null
     */
    void add(T element);

    /**
     * Returns the element at a valid index.
     *
     * @param index zero-based index
     * @return the element at index
     * @throws IndexOutOfBoundsException
     *         if index is invalid
     */
    T get(int index);

    /**
     * Removes and returns the element at a valid index.
     *
     * @param index zero-based index
     * @return the removed element
     * @throws IndexOutOfBoundsException
     *         if index is invalid
     */
    T remove(int index);

    /**
     * Returns the number of active elements.
     */
    int size();

    /**
     * Returns true when no active elements are stored.
     */
    default boolean isEmpty() {
        return size() == 0;
    }

}
