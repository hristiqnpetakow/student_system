import java.util.ArrayList;

public class Student {
    private String name;
    private String facNum;
    private ArrayList<Integer> grades;

    public Student(String name, String facNum) {
        this.name = name;
        this.facNum = facNum;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }
    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void printGrade() {
        for (int grade : grades) {
            System.out.println(grade);
        }
    }

    public void calculateAvg() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        int avg = sum / grades.size();
        System.out.println("Средната оценка е: " + avg);
    }

    public void printInfo() {
        System.out.println("Име: " + name + "Фак.номер: " + facNum);
        System.out.println("Оценки: ");
        for (int grade : grades) {
            System.out.println(grade + " ");
        }
    }

    public String getFacNum() {
        return facNum;
    }
}
