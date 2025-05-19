import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private final String filename = "students.txt";

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge());
        }
    }

    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(String id, String newName, int newAge) {
        Student s = searchById(id);
        if (s != null) {
            s.setName(newName);
            s.setAge(newAge);
            saveToFile();
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(String id) {
        Student s = searchById(id);
        if (s != null) {
            students.remove(s);
            saveToFile();
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                writer.println(s.toString());
            }
        } catch (IOException e) {
            System.out.println("Failed to save file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(filename);
        if (!file.exists()) return;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                students.add(Student.fromString(scanner.nextLine()));
            }
        } catch (IOException e) {
            System.out.println("Failed to load file: " + e.getMessage());
        }
    }
}
