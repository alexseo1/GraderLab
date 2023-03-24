public class Assignment {

    // This class defines an Assignment. 
    // Take a moment to be familiar with this Object type!
    
    private String title;
    private int grade;
    private int weight;

    public Assignment(String t, int g, int w) {

        title = t;
        grade = g;
        weight = w;

    }

    public String getAssignment() { 
        
        return title; 
        
    }

    public int getGrade() { 
        
        return grade; 
        
    }

    public int getWeight() { 
        
        return weight; 
    }

}
