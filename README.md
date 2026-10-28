# Module 1 Programming Challenge: Generic Task Sequence and Search

## Project Information
Student Name: Oscar Anaya
Course: CSC 223 - Data Structures and Algorithms
Module: 1
Java Version: OpenJDK 21.0.12.1

---

## Completed Requirements Checklist

###[x]Create a class named ProjectTask
[x]It must contain: String taskId, String title, int priority
[x]The class must be immutable.
[x]Task ID and title must not be null or blank.
[x]Priority must be between 1 and 5, inclusive.
[x]Logical equality must be based on task ID.
[x]hashCode must be consistent with equals.
[x]Natural ordering must be based on task ID.
[x]The class must implement Comparable<ProjectTask>.
[x]The class must provide a readable toString method.
###[x]Create an interface named TaskSequence<T>
[x]It must declare: void add(T element);, T get(int index);, T remove(int index);, int size();, boolean isEmpty();
[x]Implemented isEmpty as a default method.
###[x]Create a class named ResizableTaskSequence<T> that implements TaskSequence<T>
[x]Use an internal array.
[x]Provide a default constructor.
[x]Provide a constructor that accepts an initial capacity.
[x]Reject a nonpositive initial capacity.
[x]Reject null elements.
[x]Add elements at the end.
[x]Retrieve elements by zero-based index.
[x]Remove elements by zero-based index.
[x]Shift later elements left after removal.
[x]Clear the unused final array position.
[x]Double the internal capacity when full.
[x]Preserve all existing elements during resizing.
###[x]Create a class named ProjectTaskPriorityComparator.
[x]It must order tasks by: Priority descending, then Task ID ascending when priorities are equal
###[x]Create a utility class named SequenceSearch.
[x]Add a generic method with behavior equivalent to: 
public static <T> 
int findFirst(TaskSequence<T> sequence, T target)
The method must:
[x]Reject a null sequence.
[x]Search from index 0 forward.
[x]Use logical equality.
[x]Return the first matching index.
[x]Return -1 when no match exists.
[x]Leave the sequence unchanged.

---

## Instructions for Compiling and Running Tests

This project contains clean source files inside ('src/') and is structured to be imported directly into a standard Java Integrated Development Environment (IDE) configured for Java 21.

### Recommended Execution: Via IntelliJ IDEA
1. Open the Project: Launch IntelliJ IDEA, click Open, and select this unzipped project root folder.
2. Verify Java Version: Ensure Project SDK/JDK is set to Java 21.0.12.1.
3. Right-click on the main.java.edu.nova.csc223.module1 package and select Build
4. Right-click on the test.java.edu.nova.csc223.module1 package and select Build
5. If Intellij IDEA IDE does not automatically add the JUnit classpath: 
    - Click the little red  bulb on a Test and select "Add JUnit to classpath"
    - The IDE will then resolve the standard JUnit 5 testing dependencies
6. Select the JUnit test class you wish to run and click on Run

### Execution via Terminal / Command Line
This approach assumes a standard java development environment with SDK Java 21 and Junit 5 libraries

1. Navigate to the directory containing the src folder with the source code. Do not enter the src folder.
2. Compile the main application code: javac -d out src/main/java/edu/nova/csc223/module1/*.java
3. Compile teh test JUnit test suite: javac -d out -cp out src/test/java/edu/nova/csc223/module1/*.java
4. Execute the JUnit tests: java --class-path out --scan-class-path

---

## Technical Reasoning Questions

### 1. What invariants define a valid ResizableTaskSequence?
1. Size cannot be less than 0 or larger than capacity(array length)
2. Active index cannot contain a null element
3. Index with deleted element cannot contain a null value (must be empty)


### 2. Why must validation occur before the structure is modified?
Validation must occur before the structure is modified to prevent a partial state change before discovering that the operation is invalid. This guarantees an all-or-nothing execution to ensure structural integrity is preserved.


### 3. Why is task ID used for equality and natural ordering?
The taskId is meant to be unique. Therefore, if 2 priorities are equal, then the taskId is the only reliable identifier to arrange the tasks.

### 4. Why is priority implemented with a comparator rather than compareTo?
Comparator is used because compareTo restricts us to arranging the object by its default natural order. By using Comparator, we have the flexibility to arrange by order of priority and taskId.

### 5. Which test provides the strongest evidence that resizing is correct, and why?
The resizingPreservesAllElements() JUnit test provides the strongest evidence because it proves that the operations to double the capacity preserve the objects in a valid state.

---

## Known Limitations
There is only one class to sort the ProjectTask objects: The ProjectTaskPriorityComparator which orders tasks by: Priority descending, then Task ID ascending when priorities are equal.
SequenceSearch finds only the index of the first matching value in the sequence. Or, returns -1 if not found.
New ProjectTask objects must contain: String taskId, String title, and int priority values between 1 and 5 inclusive.
All other known limitations are outside of normal and boundary specifications, such as rejecting null objects, empty or null values, out-of-bound indexes.

---

## Responsible AI Use Disclosure
AI-assisted work: I used Gemini for clarifying structural Java concepts, locating bugs and verifying code logic. I independently wrote, verified, tested, and can explain all submitted work.
