import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class StudentFactory {
    Scanner sc;
    File studentFile;
    
    StudentFactory(String source){
        try{
            studentFile = new File("StudentData.csv");
            sc = new Scanner(studentFile);}
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.Enter info from keyboard");
            e.printStackTrace();
            sc = new Scanner(System.in);
        }
    }

    boolean hasMoreData(){return(sc.hasNextLine());}

    Student getNextStudent(){
        Student s; 
        if (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arrOfStr = data.split(",", 4);
            String id = arrOfStr[0].replaceAll("[^a-zA-Z0-9]", "");

            Course course1 = new Course(arrOfStr[2]);
            Course course2 = new Course(arrOfStr[3]);

            ArrayList<Course> cour = new ArrayList<Course>();
            cour.add(course1);
            cour.add(course2);
            s = new Student(Integer.parseInt(id),arrOfStr[1], cour);
            return (s);
        }
        else{
            ArrayList<Course> cour = new ArrayList<Course>();
            Course course1 = new Course("CS232");
            Course course2 = new Course("CS227");
            cour.add(course1);
            cour.add(course2);
            s = new Student(13, "Elise", cour);
            return(s);
        }
        
    }
}
