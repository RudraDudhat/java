package Assigment;
import java.util.Scanner;

public class StudentRecordMGMT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordSystem srs = new StudentRecordSystem();

        while (true) {
            System.out.println("Enter your preference:");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student by ID");
            System.out.println("3. Display all Students");
            System.out.println("4. Exit");

            int c = sc.nextInt();

            switch (c) {
                case 1:
                    srs.addStudent();
                    break;
                case 2:
                    System.out.println("Enter Student ID:");
                    int id = sc.nextInt();
                    Student student = srs.getStudent(id);
                    if (student != null) {
                        System.out.println(student);
                    } 
                    else {
                        System.out.println("Student not found");
                    }
                    break;
                case 3:
                    srs.displayAllStudent();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Student {
    private int studentId, age;
    private String department, name;

    public Student(int id, int age, String department, String name) {
        this.studentId = id;
        this.age = age;
        this.department = department;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "StudentId: " + studentId + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class StudentRecordSystem {
    Scanner sc = new Scanner(System.in);

    private int count;
    private Student[] student;

    public void addStudent() {
        System.out.println("Enter number of students:");
        count = sc.nextInt();
        student = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter student ID:");
            int id = sc.nextInt();
            System.out.println("Enter student age:");
            int age = sc.nextInt();
            System.out.println("Enter student department:");
            String department = sc.next();
            System.out.println("Enter student name:");
            String name = sc.next();
            student[i] = new Student(id, age, department, name);
        }
    }

    public Student getStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (student[i].getStudentId() == id) {
                return student[i];
            }
        }
        return null;
    }

    public void displayAllStudent() {
        for (int i = 0; i < count; i++) {
            System.out.println(student[i]);
        }
    }
}