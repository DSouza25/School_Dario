package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Postgraduate;
import entities.Student;
import entities.TecStudent;
import entities.Universitier;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        Integer option = 0;

        while (option != 3) {
            clear();
            System.out.printf("Enter option number: \n1 - Add new Student\n2 - Show students list\n3 - Exit system\n-> ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    clear();
                    System.out.printf("What the student type? [Tec/Universitier/Postgraduate]");
                    String type = sc.nextLine();

                    if (type.toUpperCase().charAt(0) == 'T') {
                        students.add(addTecStudent(sc));
                    }else if (type.toUpperCase().charAt(0) == 'U') {
                        students.add(addUniversitier(sc));
                    }else if (type.toUpperCase().charAt(0) == 'P') {
                        students.add(addPostgraduate(sc));
                    }else{
                        clear();
                        System.out.println("Option invalid.\n\nPress Enter to return to menu...");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    clear();
                    if(students.size() == 0){
                        System.out.println("No have students registered.\n\nPress Enter to return to menu...");
                        sc.nextLine();
                    }else{
                        for (Student student : students) {
                            System.out.println("Name: " + student.getName() + " | Average: " + String.format("%.2f", student.getAverage()) + " | Status: " + student.getStatus());
                            System.out.println("------------------------------------------------------------------");
                        }
                        System.out.println("Press Enter to return to menu...");
                        sc.nextLine();
                    }
                    break;
                case 3:
                    clear();
                    System.out.println("System finished.");
                    break;
                default:
                    clear();    
                    System.out.println("Are you crazy? Enter a correct option.\n\nPress enter to return to menu...");
                    sc.nextLine();
                    break;
            }
        }
        sc.close();
    }
    public static Student addTecStudent(Scanner sc){
        clear();
        System.out.printf("What the student name? ");
        String name = sc.nextLine();
        System.out.printf("Enter grade 1: ");
        Double grade1 = sc.nextDouble();
        System.out.printf("Enter grade 2: ");
        Double grade2 = sc.nextDouble();
        TecStudent student = new TecStudent(name, grade1, grade2);
        return student;
    }
    
    public static Student addUniversitier(Scanner sc){
        clear();
        System.out.printf("What the student name? ");
        String name = sc.nextLine();
        System.out.printf("Enter grade 1: ");
        Double grade1 = sc.nextDouble();
        System.out.printf("Enter grade 2: ");
        Double grade2 = sc.nextDouble();
        System.out.printf("Enter grade 3: ");
        Double grade3 = sc.nextDouble();
        Universitier student = new Universitier(name, grade1, grade2, grade3);
        return student;
    }

    public static Student addPostgraduate(Scanner sc){
        clear();
        
        System.out.printf("What the student name? ");
        String name = sc.nextLine();
        System.out.printf("Enter grade 1: ");
        Double grade1 = sc.nextDouble();
        System.out.printf("Enter grade 2: ");
        Double grade2 = sc.nextDouble();
        System.out.printf("Enter grade 3: ");
        Double grade3 = sc.nextDouble();
        System.out.printf("Enter grade 4: ");
        Double grade4 = sc.nextDouble();
        Postgraduate student = new Postgraduate(name, grade1, grade2, grade3, grade4);
        return student;
    }
   
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
