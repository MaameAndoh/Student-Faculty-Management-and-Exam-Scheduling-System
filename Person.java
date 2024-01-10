import java.util.ArrayList;
abstract class Person {
    protected int id;
    protected String name;
    protected ArrayList<Course> courses;

    Person(int id, String n, ArrayList<Course> c){
        this.id = id;
        this.name = n;
        this.courses = c;
    }

    abstract int getID();
    abstract String getName();
    abstract ArrayList<Course> getCourses();
}
