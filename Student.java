import java.util.ArrayList;

public class Student {

    private String name;
    private String letterGrade;
    private ArrayList<Assignment> assignments;

    public Student(String n) {

        name = n;
        letterGrade = "";
        assignments = new ArrayList<>();

    }

    public void addAssignment(Assignment a) { assignments.add(a); }

    public void setLetterGrade(String l) { letterGrade = l; }

    public ArrayList<Assignment> getAssignements() { return assignments; }

    public String getLetterGrade(){ return letterGrade; }

    public String toString() {

        String name = this.name.length() >= 14 ?  this.name + ": \t" : this.name + ": \t\t";

        return name + letterGrade;

    }

    /* 
     * use for testing if needed
     * 
    public String getStudentRecord() { 

        String record = name.length() >= 14 ?  name + ": \t" : name + ": \t\t";
        for(int i = 0; i < assignments.size(); i++) {

            if(i < assignments.size()-1)
                record += assignments.get(i).getAssignment() + " = " + assignments.get(i).getGrade() + " | ";
            else
                record += assignments.get(i).getAssignment() + " = " + assignments.get(i).getGrade();
        }

        return record;

    }
    */


}
