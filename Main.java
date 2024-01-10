import java.util.ArrayList; 

public class Main {
    public static void main (String[] args) {

        StudentFactory sf = new StudentFactory("StudentData.csv");
        ArrayList<Student> students = new ArrayList<Student>();

        ArrayList<ExamSlot> slots = new ArrayList<ExamSlot>();
        for (int i = 1; i < 5; i++) {
            slots.add(new ExamSlot(i));
        }
        
        ArrayList<Course> allCourses = new ArrayList<Course>();

        while (sf.hasMoreData())
            students.add(sf.getNextStudent());
        
        FacultyFactory ff = new FacultyFactory("FacultyData.csv");
        ArrayList<Faculty> faculties = new ArrayList<Faculty>();
        
        while (ff.hasMoreData())
            faculties.add(ff.getNextFaculty());
        
        System.out.println("FACULTY AND THEIR COURSES:");
        for(Faculty fac : faculties){
            System.out.println();
            Course cour1a = fac.getCourses().get(0);
            String course1a = cour1a.getCourse();
            allCourses.add(cour1a);

            Course cour2a = fac.getCourses().get(1);
            String course2a = cour2a.getCourse();
            allCourses.add(cour2a);

            System.out.println(fac.getID() + " " + fac.getName() + " : " + course1a + "," + course2a); 

            for(Student stu : students){
                Course cour1b = stu.getCourses().get(0);
                String course1b = cour1b.getCourse();
                Course cour2b = stu.getCourses().get(1);
                String course2b = cour2b.getCourse();

                ArrayList<String> studentCourse = new ArrayList<String>(2);
                studentCourse.add(course1b);
                studentCourse.add(course2b);

                if (studentCourse.contains(course1a)) {
                    System.out.println(stu.getName() + " is in " + fac.getName() + "'s " + course1a + " class");  
                }
                else if(studentCourse.contains(course2a)) {
                    System.out.println(stu.getName() + " is in " + fac.getName() + "'s " + course2a + " class");
                }
            }
        }

        System.out.println();

        int courseIndex = 0;
        for (ExamSlot e : slots) {
            for (int i = 0; i < 2; i++) {
                if (courseIndex < allCourses.size()) {
                    Course c = allCourses.get(courseIndex);
                    e.addCourse(c);
                    courseIndex++;
                }
            }
        }

        System.out.println("EXAM SCHEDULE:");
        for (ExamSlot e: slots) {
            e.displayCourse();
        }
    } 
}
