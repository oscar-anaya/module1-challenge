/**
 * CSC 223 - Data Structures and Algorithms
 * Programming Challenge Module 1 - Generic task sequence and search
 *
 * @author Oscar Anaya
 */

package main.java.edu.nova.csc223.module1;

import java.util.Arrays;

public class ResizableTaskSequence<T> implements TaskSequence<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size;

    /**
     * Default constructor
     */
    public ResizableTaskSequence() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor
     * @param initialCapacity
     */
    public ResizableTaskSequence(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive.");
        }

        elements = new Object[initialCapacity];
        size = 0;

        verifyInvariant();
    }

    /**
     * Add elements at the end
     */
    @Override
    public void add(T element) {
        validateElement(element);
        ensureCapacity();

        elements[size] = element;
        size++;

        verifyInvariant();
    }

    /**
     * Retrieve elements by zero-based index
     *
     * @param index zero-based index
     * @return
     */
    @Override
    public T get(int index) {
        validateIndex(index);
        return elementAt(index);
    }

    /**
     * Remove elements by zero-based index.
     * - Shifts later elements left after removal
     * - Clears the unused final array position.
     *
     * @param index zero-based index
     * @return
     */
    @Override
    public T remove(int index) {
        validateIndex(index);

        T removed = elementAt(index);

        for (int current = index; current < size -1; current++) {
            elements[current] = elements[current + 1];
        }

            elements[size - 1] = null;
            size--;

            verifyInvariant();

            return removed;
        }

    @Override
    public int size() {
        return size;
    }

    /**
     * Invariant verification
     *     - Size cannot be less than 0 or larger than capacity(array length)
     *     - Active index cannot contain a null element
     *     - Index with deleted element must contain a null value (must be empty)
     */
    private void verifyInvariant() {
        assert size >= 0: "Size cannot be negative.";

        assert size <= elements.length: "Size cannot exceed capacity.";

        for (int index = 0; index < size; index++) {

            assert elements[index] != null: "Active position contains null.";
        }

        for (int index = size; index < elements.length; index++) {

            assert elements[index] == null: "Unused position contains an active value.";
        }
    }

    /**
     * Helper method to validate the element. Make sure element is not null
     * @param element
     */
    private void validateElement(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }
    }

    /**
     * Helper method to ensure capacity.
     * - Makes sure size does not exceed capacity
     * - Doubles the internal capacity when full.
     * - Preserves all existing elements during resizing.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;

            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Helper method to validate index. Makes sure index is within range
     *
     * @param index
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is outside the valid range."
            );
        }
    }

    /**
     * Helper method to retrieve and cast an object element
     *
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        return (T) elements[index];
    }
}
