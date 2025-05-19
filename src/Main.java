import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
            System.out.println("\n=== Student Records Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    manager.addStudent(new Student(id, name, age));
                    break;
                case "2":
                    manager.listStudents();
                    break;
                case "3":
                    System.out.print("Enter ID to search: ");
                    Student found = manager.searchById(scanner.nextLine());
                    System.out.println(found != null ? found : "Student not found.");
                    break;
                case "4":
                    System.out.print("Enter ID to update: ");
                    String uid = scanner.nextLine();
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New Age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    manager.updateStudent(uid, newName, newAge);
                    break;
                case "5":
                    System.out.print("Enter ID to delete: ");
                    manager.deleteStudent(scanner.nextLine());
                    break;
                case "6":
                    System.out.println("Exiting. Bye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                }
            }
        }
    }
}
