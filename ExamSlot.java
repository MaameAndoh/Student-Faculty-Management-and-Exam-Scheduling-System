import java.util.ArrayList;

public class ExamSlot {
    protected ArrayList<Course> slotCourses = new ArrayList<Course>();
    protected int slotNum;

    ExamSlot(int n) {
        this.slotNum = n;
    }

    public void addCourse(Course c) {
        slotCourses.add(c);
    }

    public ArrayList<Course> getSlotCourses() {
        return slotCourses;
    }

    public void displayCourse() {
        System.out.println("Courses in slot " + slotNum);
        for (Course c: slotCourses)
            System.out.println(c.getCourse());
    }

}
