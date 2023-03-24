import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;

public class Grader {    

    public static void main(String[] args) {

        try {

            String fileName = args[0];
            File listOfStudents = new File(fileName);
            // File listOfStudents = new File("student_grades.csv");
            Scanner scan = new Scanner(listOfStudents);

            //Parse first table header (assignment ttitles)
            String header;
            if(scan.hasNextLine())
                header = scan.nextLine();
            else {
                scan.close();
                throw new IllegalAccessError("The file is empty");                
            }                
            ArrayList<String> assignments = getAssignmentTitles(header);

            // Parse second table header (assignment weights)
            if(scan.hasNextLine())
                header = scan.nextLine();
            else {
                scan.close();
                throw new IllegalAccessError("Could not find weights line");                
            }                
            ArrayList<Integer> weights = getAssignmentWeights(header);

            // Set up list of students
            ArrayList<Student> students = new ArrayList<>();

            // Parse the rest of the table
            while(scan.hasNextLine()) {
                
                String[] studentRec = scan.nextLine().split(",");
                Student newStudent = new Student(studentRec[0]);

                for(int i = 0; i < assignments.size(); i++) {
                    String assignment = assignments.get(i);
                    int weight = weights.get(i);
                    int grade = Integer.parseInt(studentRec[i+1]);
                    Assignment newAssignment = new Assignment(assignment, grade, weight);
                    newStudent.addAssignment(newAssignment);
                }

                students.add(newStudent);

            }

            setLetterGrades(students);

            for(Student s: students)
                System.out.println(s);
            
            scan.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter a command line argument");
        } catch(FileNotFoundException f) {
            System.out.println("No such file exists at the given path");
        } 
        
    }



    /*
     *
     ************************************************************************************
     * Below are all the static methods of this class (Grader) that we'll use statically 
     * in main() (i.e. without needing to instantiate an object of type Grader)
     ************************************************************************************
     *  
     */

    private static ArrayList<String> getAssignmentTitles(String header) {

        String[] temp_assignments = header.split(",");
        ArrayList<String> assignments = new ArrayList<>();       
        for(String s: temp_assignments)
            if(s.length() > 0)
                assignments.add(s);
            
        return assignments;
        
    }

    private static ArrayList<Integer> getAssignmentWeights(String header) {

        String[] temp_assignments = header.split(",");
        ArrayList<Integer> weights = new ArrayList<>();
        for(String s: temp_assignments)
            if(s.length() > 0)
                weights.add(Integer.parseInt(s));
            
        return weights;

    }

    private static void setLetterGrades(ArrayList<Student> students) {

        int finalGrade = 0;
        for(Student student: students) {

            for(Assignment assignment: student.getAssignements())
                finalGrade += assignment.getGrade() * ((double) assignment.getWeight()/100);

            student.setLetterGrade(defineLetter(finalGrade));
            
            finalGrade = 0;

        }

    }

    private static String defineLetter(int numGrade) {
        
        if(numGrade < 0 || numGrade > 100)
            throw new IllegalArgumentException("Grade must be in range [0,100]");

        if(numGrade >= 93)
            return "A+";
        else if(numGrade >= 88)
            return "A";
        else if(numGrade >= 83)
            return "A-";
        else if(numGrade >= 77)
            return "B+";
        else if(numGrade >= 73)
            return "B";
        else if(numGrade >= 67)
            return "B-";
        else if(numGrade >= 57)
            return "C+";
        else if(numGrade >= 53)
            return "C";
        else if(numGrade >= 47)
            return "C-";
        else if(numGrade >= 30)
            return "D";
        else
            return "F";

    }

}
