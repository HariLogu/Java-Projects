import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class NewStudent{
    int Id;
    String Name;
    int[] Marks;


    public NewStudent(int id, String name, int[] marks) {
        Id = id;
        Name = name;
        Marks = marks;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int[] getMarks() {
        return Marks;
    }

    public void setMarks(int[] marks) {
        Marks = marks;
    }
    public char getGrade(){
        double tot=0;
        for(int i:getMarks()){
            if(i<35){
                return 'F';
            }
            else
                tot+=i;
        }
        double per= tot/5;
        if(per>90){
            return 'A';
        }
        else if(per<90 && per>80){
            return 'B';
        }
        else if(per<80 && per>70){
            return 'C';
        }
        else{
            return 'D';
        }
    }

    public void displayStudent(){
        System.out.println("Id    : "+getId()+"\n"+"Name  : "+getName()+"\n"+"Marks : "+ Arrays.toString(getMarks())+"\n"+"Grade : "+getGrade()+"\n");
    }


}
public class Exercise2 {
    static ArrayList<NewStudent> students=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<Integer> idArr = new ArrayList<>();

    static ArrayList<Integer> idArray(ArrayList<Integer> idArr){
        for (NewStudent n : students) {
            idArr.add(n.getId());
        }
        return idArr;
    }

    static void addStudent(){



        System.out.print("How many students do you want to add: ");
        int length=scanner.nextInt();
        for (int i = 0; i < length; i++) {


            System.out.print("Enter the Id:");
            int id = scanner.nextInt();
            if(id>0) {

                if (!idArray(idArr).contains(id)) {

                    System.out.print("Enter the Name:");
                    String name = scanner.next();

                    System.out.println("Enter the Marks:");
                    int[] marks = new int[5];
                    for (int j = 0; j < 5; j++) {
                        int m = scanner.nextInt();
                        if (m > 0 && m <= 100)
                            marks[j] = m;
                        else {
                            System.out.println("invalid input");
                            j--;
                        }
                    }

                    NewStudent ss = new NewStudent(id, name, marks);
                    students.add(ss);


                    System.out.println("*** student added ***\n");
                } else {
                    System.out.println("Duplicate Id found!");
                    i--;
                }
            }
            else{
                System.out.println("invalid input");
                i--;
            }
        }
    }

    static void displayStudentDetails(){
        if(!students.isEmpty()){
            System.out.println("***** Available Students *****");
            for(NewStudent n:students){
                n.displayStudent();
            }
        }
        else{
            System.out.println("No student records found!");
        }

    }

    public static void findAverage(){
        if(!students.isEmpty()) {
            displayStudentDetails();
            System.out.print("Enter the studentId to average: ");
            int av = scanner.nextInt();
            if(idArray(idArr).contains(av)) {
                int[] arr = new int[5];
                double total = 0;

                for (NewStudent n : students) {
                    if (n.getId() == av) {
                        for (int i : arr = n.getMarks()) {
                            total += i;
                        }
                    }
                }

                System.out.print("\nTotal  : " + total + "\nAverage: " + total / arr.length);
            }else{
                System.out.println("Id not found!");
            }
        }
        else{
            System.out.println("No student records found!");
        }
    }

    static void searchStudent() {
        if(!students.isEmpty()) {

            System.out.println("Enter the id to search student: ");
            int searchId = scanner.nextInt();

            if (idArray(idArr).contains(searchId)) {
                for (NewStudent n : students) {
                    if (n.getId() == searchId) {
                        n.displayStudent();
                    }

                }
            } else {
                System.out.println("Not found!");
            }
        }
        else{
            System.out.println("No student records found!");
        }
    }

    static void removeStudent(){
        System.out.print("Enter id to delete:");
        int id=scanner.nextInt();
        if(idArray(idArr).contains(id)) {
//            we should not use this
//            for (NewStudent n : students) {
//                if (n.getId() == id) {
//                    students.remove(n);
//                }
//            }
//      we can use this
            students.removeIf(n -> n.getId() == id);

            System.out.println("Removed successfully\n");
        }
        else{
            System.out.println("Id not found\n");
        }
    }

    static void updateDetails(){
        System.out.println("***** Update process *****");
        System.out.print("Enter their id: ");
        int id=scanner.nextInt();
        if(idArray(idArr).contains(id)) {


            for (NewStudent n : students) {
                if (n.getId() == id) {

                    System.out.println("""
                            1.Id
                            2.Name
                            3.Marks
                            """);
                    System.out.print("Enter the choice:");
                    int changeChoice = scanner.nextInt();
                    switch (changeChoice) {
                        case 1:
                            System.out.print("Enter the new Id: ");
                            int newId = scanner.nextInt();
                            n.setId(newId);
                            System.out.println("Id updated successfully");
                            break;
                        case 2:
                            System.out.print("Enter the new Name: ");
                            String newName = scanner.next();
                            n.setName(newName);
                            System.out.println("Name updated successfully");
                            break;
                        case 3:
                            System.out.print("Enter the new Marks: ");
                            int[] newMarksArr = new int[5];
                            for (int i = 0; i < 5; i++) {
                                int newMark = scanner.nextInt();
                                newMarksArr[i] = newMark;
                                n.setMarks(newMarksArr);
                            }
                            System.out.println("Marks updated successfully");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            }
        }else{
            System.out.println("invalid input");
        }
    }

    public static void main(String[] args) {

//        predefined objects for ref use

        NewStudent s1=new NewStudent(11,"logu", new int[]{55, 77, 99, 88, 77});
        NewStudent s2=new NewStudent(22,"hari", new int[]{64, 87, 67, 55, 88});
        NewStudent s3=new NewStudent(32,"nami", new int[]{54, 96, 99, 87, 88});
        NewStudent s4=new NewStudent(44,"jim", new int[]{90, 96, 99, 91, 88});



        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);


        System.out.println("******************");
        System.out.println("Student Management");
        System.out.println("******************");

        int choice=0;
        while(choice<6) {


            System.out.println("""
                    ----------------------
                    1.Add student
                    2.Remove Student
                    3.Search Student
                    4.Find Average
                    5.Update Details
                    6.Display All Details
                    7.Quit
                    """);

            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            if (choice > 0 && choice < 7) {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudentDetails();
                        removeStudent();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        findAverage();
                        break;
                    case 5:
                        updateDetails();
                        break;
                    case 6:
                        displayStudentDetails();
                        break;

                    default:
                        System.out.println("Bye");
                }
            }
        }




    }








//        addStudent();


//       findAverage();
//        searchStudent();















}
