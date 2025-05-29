import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Student> students = new HashMap<>();


        while (true) {
            System.out.println("1. Добави студент");
            System.out.println("2. Добави оценка на студент");
            System.out.println("3. Покажи оценки");
            System.out.println("4. Покажи средна оценка");
            System.out.println("5. Покажи всички студенти");
            System.out.println("0. Изход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Моля въведете име на студента: ");
                    String name = scanner.nextLine();

                    System.out.println("Моля въведете фак. номер на студента: ");
                    String facNum = scanner.nextLine();

                    if (students.containsKey(facNum)) {
                        System.out.println("Студент с този фак. номер вече  съществува.");
                    } else {
                        Student student = new Student(name, facNum);
                        students.put(facNum, student);
                        System.out.println("Студентът е добавен.");
                    }
                    break;
                case 2:
                    System.out.println("Моля въведете фак. номер на студента: ");
                    String facToGrade = scanner.nextLine();

                    Student studentToGrade = students.get(facToGrade);
                    if (studentToGrade == null) {
                        System.out.println("Студентът не е намерен.");
                    } else {
                        System.out.println("Моля въведете оценка: ");
                        int grade = scanner.nextInt();

                        studentToGrade.addGrade(grade);
                        System.out.println("Оценката е добавена успешно.");
                    }
                    break;
                case 3:
                    System.out.println("Моля въведете фак. номер на студента: ");
                    String showGrades = scanner.nextLine();

                    Student studentGrades = students.get(showGrades);
                    if (studentGrades == null) {
                        System.out.println("Студентът не е намерен.");
                    } else {
                        studentGrades.printGrade();
                    }
                    break;
                case 4:
                    System.out.println("Моля въведете фак. номер на студента: ");
                    String facToAvgGrade = scanner.nextLine();
                    Student studentToAvgGrade = students.get(facToAvgGrade);
                    if (studentToAvgGrade == null) {
                        System.out.println("Студентът не е намерен.");
                    } else {
                        studentToAvgGrade.calculateAvg();
                    }
                    break;
                case 5:
                    if (students.isEmpty()) {
                        System.out.println("Няма въведени студенти.");
                    } else {
                        for (Student student : students.values()) {
                            System.out.println("Име: " + student.getName() + " | Фак. номер: " + student.getFacNum());
                            System.out.println("Оценки: ");
                            if (student.getGrades().isEmpty()) {
                                System.out.println("Няма въведени оценки");
                            } else {
                                for (int grade : student.getGrades()) {
                                    System.out.println(grade + " ");
                                }
                                int num = 0;
                                for (int grade : student.getGrades()) {
                                    num += grade;
                                }
                                int avg = num / student.getGrades().size();
                                System.out.println("Средна оценка: " + avg);
                            }
                        }
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Невалиден избор!");
            }
        }
    }
}