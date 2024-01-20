package studentmanagement;

import java.util.Scanner;

public class StudentManagementSystem {
    private static Student[][] students = new Student[5][1];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clearScreen();
        displayWelcomeBanner();
        Pause();
        clearScreen();
        displayMenu();
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Find Student by Roll Number");
            System.out.println("5. Display Students by Grade");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    clearScreenWithPrompt();
                    addStudent();
                    Pause();
                    clearScreen();
                    break;
                case 2:
                    clearScreenWithPrompt();
                    displayStudentDetails();
                    Pause();
                    clearScreen();
                    break;
                case 3:
                    clearScreenWithPrompt();
                    double averageGrade = calculateAverageGrade();
                    System.out.println("Average Grade: " + averageGrade);
                    Pause();
                    clearScreen();
                    break;
                case 4:
                    clearScreenWithPrompt();
                    System.out.print("Enter Roll Number to find: ");
                    int searchRollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Student foundStudent = findStudentByRollNumber(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found by roll number " + searchRollNumber + ": " + foundStudent.name);
                    } else {
                        System.out.println("Student with roll number " + searchRollNumber + " not found.");
                    }
                    Pause();
                    clearScreen();
                    break;
                case 5:
                    clearScreenWithPrompt();
                    System.out.print("Enter Grade to display students: ");
                    Grade displayGrade = Grade.valueOf(scanner.nextLine().toUpperCase());
                    displayStudentsByGrade(displayGrade);
                    Pause();
                    clearScreen();
                    break;
                case 0:
                    clearScreen();
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    clearScreen();
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);

        clearScreenWithPrompt();
        // Close the scanner to prevent resource leak
        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Grade (A, B, C, D, F): ");
        Grade grade = Grade.valueOf(scanner.nextLine().toUpperCase());

        // Find an empty slot in the students array to add the new student
        for (int i = 0; i < students.length; i++) {
            if (students[i][0] == null) {
                students[i][0] = new Student(name, rollNumber, grade);
                System.out.println("Student added successfully.");
                return;
            }
        }

        System.out.println("Student array is full. Cannot add more students.");
    }

    private static void displayStudentDetails() {
        System.out.println("Student Details:");
        for (Student[] row : students) {
            for (Student student : row) {
                if (student != null) {
                    System.out.println("Name: " + student.name);
                    System.out.println("Roll Number: " + student.rollNumber);
                    System.out.println("Grade: " + student.grade);
                    System.out.println("--------------");
                }
            }
        }
    }

    private static double calculateAverageGrade() {
        double totalGradePoints = 0;
        int count = 0;
        for (Student[] row : students) {
            for (Student student : row) {
                if (student != null) {
                    switch (student.grade) {
                        case A:
                            totalGradePoints += 4.0;
                            break;
                        case B:
                            totalGradePoints += 3.0;
                            break;
                        case C:
                            totalGradePoints += 2.0;
                            break;
                        case D:
                            totalGradePoints += 1.0;
                            break;
                        // Grade F contributes 0.0 to the total
                        case F:
                            totalGradePoints += 0.0;
                    }
                    count++;
                }
            }
        }
        return count > 0 ? totalGradePoints / count : 0.0;
    }

    private static Student findStudentByRollNumber(int rollNumber) {
        for (Student[] row : students) {
            for (Student student : row) {
                if (student != null && student.rollNumber == rollNumber) {
                    return student;
                }
            }
        }
        return null; // Student not found
    }

    private static void displayStudentsByGrade(Grade grade) {
        System.out.println("Students with Grade " + grade + ":");
        for (Student[] row : students) {
            for (Student student : row) {
                if (student != null && student.grade == grade) {
                    System.out.println("Name: " + student.name + ", Roll Number: " + student.rollNumber);
                }
            }
        }
        System.out.println("--------------");
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exceptions if needed
            e.printStackTrace();
        }
    }

    public static void clearScreenWithPrompt() {
        System.out.print("Press Enter to continue...");
        scanner.nextLine(); 
        clearScreen();
    }

    public static void Pause() {
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // This line will wait for the user to press Enter
        System.out.println("Continuing...");
    }

    public static void displayWelcomeBanner() {
        System.out.println("*********************************************");
        System.out.println("*   Welcome to Student Management System    *");
        System.out.println("*********************************************");
    }
}
