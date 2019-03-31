package PowerSchool;


import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student>{

    /* When you declare the Student class, declare it as:
     * public class Student implements Comparable<Student>{
     * This is your promise to include the compareTo() method.
     */
    private String name;
    private int gradYear;
    private School Academy;
    Course[] schedule; // Contains no more than ten courses.

    public Student (String name, int gradYear, School Academy){
        this.name=name;
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
    public double getGPA(){
        double GpaTotal=0;
        int amountofGPAclasses=schedule.length;
        int Coursegrade;


        for(int i=0;i<schedule.length;i++){
            if(schedule[i].gradeOf(this).audited()){
                amountofGPAclasses--;
            }
            else{
                Coursegrade=schedule[i].gradeOf(this).gradeValue();
                if(Coursegrade>=93)
                    GpaTotal+=4.0;
                else if(Coursegrade>=90)
                    GpaTotal+=3.7;
                else if(Coursegrade>=87)
                    GpaTotal+=3.3;
                else if(Coursegrade>=83)
                    GpaTotal+=3.0;
                else if(Coursegrade>=80)
                    GpaTotal+=2.7;
                else if(Coursegrade>=77)
                    GpaTotal+=2.3;
                else if(Coursegrade>=73)
                    GpaTotal+=2.0;
                else if(Coursegrade>=70)
                    GpaTotal+=1.7;
                else if(Coursegrade>=67)
                    GpaTotal+=1.3;
                else if(Coursegrade>=65)
                    GpaTotal+=1.0;

            }
        }
        return GpaTotal/amountofGPAclasses;
    }


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

        int val=(int)(getGPA()-someOtherKid.getGPA());
        if(val==0)
            return 0;
        if (val<0)
            return -1;
        return 1;

    }
    /* Adds course and returns true if successful.
     * Returns false if: course would brings classes to more than
     * 10, or student is already enrolled. */
    public boolean addCourse(Course someCourse) {
        int numCourses = 0;
        if(schedule.length==10)
            return false;
        for(int loopvar=0;loopvar<schedule.length;loopvar++){
            if(someCourse.equals(schedule[loopvar]))
                return false;
            numCourses++;
        }

        schedule[numCourses] = someCourse;
        return true;
    }
    /* Removes course and returns true if successful.
     * Returns false if: course was not on student’s schedule.
     */
    public boolean dropCourse(Course someCourse) {
        ArrayList<Course> templist = new ArrayList<Course>(Arrays.asList(schedule));
        for(int loopvar=0;loopvar<schedule.length;loopvar++){
            if(someCourse.equals(schedule[loopvar])){
                templist.remove(loopvar);
                schedule=(Course[])templist.toArray();
                return true;
            }

        }
        return false;

    }
}

