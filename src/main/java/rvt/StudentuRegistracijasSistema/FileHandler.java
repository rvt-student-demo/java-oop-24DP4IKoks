package rvt.StudentuRegistracijasSistema;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "students.csv";

    public static void saveStudent(Student student) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(student.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Kļūda saglabājot failu.");
        }
    }

    public static List<Student> readStudents() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromCSV(line));
            }
        } catch (IOException e) {
            // ja fails neeksistē, ignorē
        }

        return students;
    }

    public static void overwriteFile(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Kļūda pārrakstot failu.");
        }
    }
}