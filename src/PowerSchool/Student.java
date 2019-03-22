package PowerSchool;

public class Student implements Comparable<Student>{

    /* When you declare the Student class, declare it as:
     * public class Student implements Comparable<Student>{
     * This is your promise to include the compareTo() method.
     */
    private String Name;
    private int gradYear;
    private School Academy;
    Course[] schedule; // Contains no more than ten courses.
    public Student (String name, int gradYear, School Academy){
        Name=name;
        this.gradYear=gradYear;
        this.Academy=Academy;
    }
    public String getName(){
        return Name;
    }
    public int getGradYear(){
        return gradYear;
    }
    public School getAcademy(){
        return Academy;
    }
    // Calculates GPA as average of classes
    public double getGPA(){}
    // Returns compareTo value for the GPAs of the two students
    public int compareTo(Student someOtherKid){
        /*
        * Dumb Option 1
        * if(getGPA()-someOtherKid.getGPA())==0)
        * return 0;
        * return (int) ((getGPA() - someOtherKid.getGPA()) * (1 / Math.abs(getGPA() - someOtherKid.getGPA())));
        */

        /*
         * Dumb Option 2
         * return (getGPA()-someOtherKid.getGPA())==0?0:(int) ((getGPA() - someOtherKid.getGPA()) * (1 / Math.abs(getGPA() - someOtherKid.getGPA())));*/

        int val=(int)getGPA()-someOtherKid.getGPA()
        if(val==0)
            return 0;
        if (val<0)
            return -1;
        return 1;

    }
    /* Adds course and returns true if successful.
     * Returns false if: course would brings classes to more than
     * 10, or student is already enrolled. */
    public boolean addCourse(Course someCourse){}
    /* Removes course and returns true if successful.
     * Returns false if: course was not on student’s schedule.
     */
    public boolean dropCourse(Course someCourse){}

}
