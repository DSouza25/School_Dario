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
        Scanner sc = new Scanner(System.in); // Declaração do objeto Scanner pra ler os dados pelo teclado.
        List<Student> students = new ArrayList<>(); // Declaração de uma nova lista de alunos | serve pra adicionar vários alunos de tipos diferentes em um só lugar.
        Integer option = 0; // inicializado como zero pra poder dar entrada no While

        while (option != 3) {
            clear(); // função que limpa o console pra deixar mais bonitinho só. Pura frescura minha!
            System.out.printf("Enter option number: \n1 - Add new Student\n2 - Show students list\n3 - Exit system\n-> "); // menu principal do sistema
            option = sc.nextInt(); // lê a opção do menu que o usuário quer acessar
            sc.nextLine(); // limpa o buffer que lê os dados pra não dar problema no switch-case (É um pouco complexo, mas eu explico, se quiserem.)
            switch (option) {
                case 1: // cadastra um novo aluno
                    clear();
                    System.out.printf("What the student type? [Tec/Universitier/Postgraduate]"); // escolhe o tipo de aluno que vai ser cadastrado
                    String type = sc.nextLine();

                    // Toda essa parte funciona como o switch-case, mas decidi fazer com o IF-Else pra verem mais de uma opção de código
                    if (type.toUpperCase().charAt(0) == 'T') { // caso escolha Tec
                        students.add(addTecStudent(sc));
                    }else if (type.toUpperCase().charAt(0) == 'U') { // caso escolha Universitário
                        students.add(addUniversitier(sc));
                    }else if (type.toUpperCase().charAt(0) == 'P') { // caso escolha Pós-graduando
                        students.add(addPostgraduate(sc));
                    }else{ // essa parte é pro caso do usuário maldito escolher uma opção inválida.
                        clear();
                        System.out.println("Option invalid.\n\nPress Enter to return to menu...");
                        sc.nextLine();
                    }
                    break;
                case 2: // essa parte imprime a lista de alunos cadastrados com o nome, a média e o status.
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
                case 3:// Finaliza o sistema
                    clear();
                    System.out.println("System finished.");
                    break;
                default: // Erro apontado caso o usuário escolha uma opção inválida
                    clear();    
                    System.out.println("Are you crazy? Enter a correct option.\n\nPress enter to return to menu...");
                    sc.nextLine();
                    break;
            }
        }
        sc.close(); // fecha o objeto Scanner porque ele não pode ficar aberto
    }
    public static Student addTecStudent(Scanner sc){ // método  pra adicionar um Tec
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
    
    public static Student addUniversitier(Scanner sc){// método pra adicionar um Universitário
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

    public static Student addPostgraduate(Scanner sc){// método pra adicionar um Pós-graduando
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
   
    public static void clear() {// funcção que limpa o console
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
