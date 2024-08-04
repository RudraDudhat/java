package Assigment3;
import java.util.*;

public class GradingSystemMGTM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GradingSystem gradingSystem = new GradingSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Add Course Credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    String name = scanner.next();

                    Student student = new Student(studentID, name);
                    gradingSystem.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    System.out.print("Enter grade : ");
                    char grade = scanner.next().charAt(0);

                    Grade gradeObj = new Grade(studentID, courseID, grade);
                    gradingSystem.addGrade(gradeObj);
                    break;
                case 3:
                    System.out.print("Enter course ID: ");
                    courseID = scanner.nextInt();
                    System.out.print("Enter course credits: ");
                    int credits = scanner.nextInt();

                    gradingSystem.addCourseCredits(courseID, credits);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();

                    double gpa = gradingSystem.calculateGPA(studentID);
                    System.out.println("GPA: " + gpa);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}

class Student{
    private int studentID;
    private String name;
    
    public Student(int studentId, String name) {
        this.studentID = studentId;
        this.name = name;
    }    

    public int getStudentID(){
        return studentID;
    }
    public String getName(){
        return name;
    }
}

class Grade{
    private int studentID,courseID;
    private char grade;

    public Grade(int studentId, int courseID,char grade) {
        this.studentID = studentId;
        this.courseID = courseID;
        this.grade=grade;
    }  

    public int getStudentID(){
        return studentID;
    }
    public int getCourseID(){
        return courseID;
    }
    public char getGrade(){
        return grade;
    }
}

class GradingSystem{
    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount,gradeCount;

    public GradingSystem(){
        students = new Student[10];
        grades = new Grade[10]; 
        courseCredits = new int[10];
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student Student){
        if(studentCount < students.length){
            students[studentCount] = Student;
            studentCount++;
        }
        else{
            System.out.println("Student is Full");
        }
    }

    public void addGrade(Grade grade){
        if(gradeCount < grades.length){
            grades[gradeCount] = grade;
            gradeCount++;
        }
        else{
            System.out.println("grade is full");
        }
    }

    public void addCourseCredits(int courseID,int credits){
        for(int i=0;i<gradeCount;i++){
            if(courseID==grades[i].getCourseID()){
                courseCredits[i] = credits;
            }
        }
    }

    public double calculateGPA(int studentID){
        double totalPoints=0;
        int totalCredits=0;

        for(int i=0;i<gradeCount;i++){
            if(studentID == grades[i].getStudentID()){
                int points = gradeToPoints(grades[i].getGrade());
                int credits = courseCredits[i];
                totalPoints += points * credits;
                totalCredits += credits;
            }
        }

        return totalPoints / totalCredits;
    }

    public int gradeToPoints(char grade){
        if(grade=='A')
        return 4;
        if(grade=='B')
        return 3;
        if(grade=='C')
        return 2;
        if(grade=='D')
        return 1;
        if(grade=='F')
        return 0;

        return -1;
    }
}