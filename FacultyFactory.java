import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class FacultyFactory {
    Scanner sc;
    File facultyFile;
    
    FacultyFactory(String source){
        try{
            facultyFile = new File("FacultyData.csv");
            sc = new Scanner(facultyFile);}
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.Enter info from keyboard");
            e.printStackTrace();
            sc = new Scanner(System.in);
        }
    }

    boolean hasMoreData(){return(sc.hasNextLine());}

    Faculty getNextFaculty(){
        Faculty f; 
        if (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arrOfStr = data.split(",", 4);
            String id = arrOfStr[0].replaceAll("[^a-zA-Z0-9]", "");

            Course course1 = new Course(arrOfStr[2]);
            Course course2 = new Course(arrOfStr[3]);

            ArrayList<Course> cour = new ArrayList<Course>();
            cour.add(course1);
            cour.add(course2);

            f = new Faculty(Integer.parseInt(id),arrOfStr[1], cour);
            return(f);
        }
        else{
            ArrayList<Course> cour = new ArrayList<Course>();
            Course course1 = new Course("CS335");
            Course course2 = new Course("CS327");
            cour.add(course1);
            cour.add(course2);
            f = new Faculty(5, "Carroll", cour);
            return(f);
        }
    }

}
