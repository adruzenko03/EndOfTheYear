package PowerSchool;

public class Grade {
    /* Grades must be between 0 and 1000 (which represents a score of 100%. A grade of 957
     * would represent a score of 95.7%) (inclusive) */
    private int grade;
    /* Audited classes are not counted in a Student’s GPA or class rank. A Student may audit
     * a class even if other Students in the same class are not auditing. */
    private boolean audit;
    /* Honors classes have a 5% boost to the grade. */
    private boolean honors;
    /* The course for which this grade has been assigned. */
    public Course course;
    // If the grade provided is out of range, the closest in-range grade is entered
    public Grade (boolean honors, boolean audited, int grade, Course course){
        if(grade>1000)
            this.grade=1000;
        else if (grade<0)
            this.grade=0;
        else
            this.grade=grade;
        this.course=course;
        this.audit=audited;
        this.honors=honors;

    }
    // Returns the grade.
    public int gradeValue(){
        if(honors)
            return (int)(grade+grade*.05);
        else
            return grade;
    }
    public boolean honors(){
        return honors;
    }
    public boolean audited(){
        return audit;
    }

}
