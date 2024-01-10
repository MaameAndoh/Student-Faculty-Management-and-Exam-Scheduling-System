import java.util.ArrayList;

class Student extends Person {

    Student (int id, String n, ArrayList<Course> c) {
        super(id, n, c);
    }

    @Override
    public int getID() {return this.id;}

    @Override
    public String getName(){return this.name;}

    @Override
    public ArrayList<Course> getCourses(){return this.courses;}



}
