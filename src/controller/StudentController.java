package controller;

import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> list = new ArrayList<>();

    public void add() {
        System.out.println("Enter EnrolID:");
        String enrolId = scanner.nextLine();
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name!");
        String lastName = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = Integer.parseInt(scanner.nextLine());
        list.add(new Student(enrolId, firstName, lastName, age));
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter("/home/phu/IdeaProjects/Thi-java-2/src/students.dat");
            BufferedWriter buffer = new BufferedWriter(writer);
            for (Student student : list) {
                buffer.write(student.getEnrolId() + "|" + student.getFirstName() + "|" + student.getLastName() + "|" + student.getAge() + "\n");
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void display() {
        try {
            FileReader fileReader = new FileReader("/home/phu/IdeaProjects/Thi-java-2/src/students.dat");
            BufferedReader br = new BufferedReader(fileReader);
            System.out.printf("%-18s%-20s%s\n", "EnrolID", "FullName", "Age");
            System.out.printf("%-12s%-22s%s\n", "-----------", "---------------------", "---------");
            String line;
            while ((line = br.readLine()) != null) {
                String[] student = line.split("\\|");
                System.out.printf("%-15s%-23s%s\n", student[0], student[1] + " " + student[2], student[3]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
