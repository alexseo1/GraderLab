# GraderLab
Grader.java
This parses a comma separated value (CSV) File from the command line which has the names and weights of Assignments on lines 1 and 2, along with a list of
students and their grades for each of the Assignments on the rest of the lines. 

Assignment.java
A simple class, with accessor methods, that represents an “Assignment” Object (with an Assignment weight, grade, and title).

Student.java
A Student class, with a String name, ArrayList of Assignments, and an overall letterGrade String.
Includes a toString() method, accessor methods, mutator methods, and an addAssignment(Assignment a) method which adds to the underlying ArrayList of Assignments.
