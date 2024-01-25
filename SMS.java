import java.util.*;

// Create class Student having name, marks
class Student {
    private String name;
    private ArrayList<Integer> marks;

    public Student(String name, ArrayList<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    // Updated setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }
}

public class SMS {
    private HashMap<Integer, Student> students = new HashMap<>();

    // Add a new student to the system
    public void addStudent(int rollNumber, String name, ArrayList<Integer> marks) {
        if (students.containsKey(rollNumber)) {
            System.out.println("Student with the same number already present. Please choose a unique number.");
        } else {
            Student student = new Student(name, marks);
            students.put(rollNumber, student);
            System.out.println("Student record created successfully.");
        }
    }

    // Delete a student from the system
    public void deleteStudent(int rollNumber) {
        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
            System.out.println("Student with the given number deleted successfully.");
        } else {
            System.out.println("Student with the given number not present. Please enter the correct number.");
        }
    }

    // Update information for an existing student
    public void updateStudent(int rollNumber, String name) {
        Scanner sc = new Scanner(System.in);
        if (students.containsKey(rollNumber)) {
            System.out.println("Press 1 for updating name, press 2 for updating marks, or press 3 for both");
            int choice = sc.nextInt();

            if (choice == 1) {
                updateStudentName(rollNumber, sc);
                System.out.println("Name updated successfully.");
            } else if (choice == 2) {
                updateStudentMarks(rollNumber, sc);
                System.out.println("Marks updated successfully.");
            } else if (choice == 3) {
                updateStudentName(rollNumber, sc);
                updateStudentMarks(rollNumber, sc);
                System.out.println("Name and Marks updated successfully.");
            }
        } else {
            System.out.println("Student with the given number not present. Please enter the correct number.");
        }
    }

    // Helper method to update student name
    private void updateStudentName(int rollNumber, Scanner sc) {
        System.out.print("Enter new name: ");
        String updatedName = sc.next();
        students.get(rollNumber).setName(updatedName);
    }

    // Helper method to update student marks
    private void updateStudentMarks(int rollNumber, Scanner sc) {
        System.out.println("Enter the number of subjects: ");
        int numberOfSubjects = sc.nextInt();
        ArrayList<Integer> updatedMarks = new ArrayList<>();
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.println("Enter marks for subject " + i + ": ");
            int mark = sc.nextInt();
            updatedMarks.add(mark);
        }
        students.get(rollNumber).setMarks(updatedMarks);
    }

    // Display the list of students
    public void displayStudents() {
        System.out.println("The Student List is\n");
        System.out.println("rollnumber" + "\t" + "name" + "\t" + "marks");

        for (Integer num : students.keySet()) {
            Student student = students.get(num);
            String name = student.getName();
            ArrayList<Integer> marks = student.getMarks();

            System.out.println(num + "\t\t" + name + "\t" + marks);
        }
    }

    // Calculate and display percentage and grade for a student
    public void percentageGrade(int rollNumber, String name) {
        if (students.containsKey(rollNumber)) {
            System.out.println("Your RollNumber is: " + rollNumber);
            System.out.println("Your Name is: " + name);
            ArrayList<Integer> marks = students.get(rollNumber).getMarks();

            int sum = marks.stream().mapToInt(Integer::intValue).sum();
            double percentage = ((double) sum / (marks.size() * 100)) * 100;
            System.out.println("Your percentage is: " + percentage);

            char grade;
            if (percentage >= 90) {
                grade = 'A';
            } else if (percentage >= 80) {
                grade = 'B';
            } else if (percentage >= 70) {
                grade = 'C';
            } else if (percentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Your Grade is: " + grade);
        } else {
            System.out.println("Student with the given number not exists.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        SMS st = new SMS();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Student Management System Menu:");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Calculate Percentage and Grade");
                System.out.println("5. Exit");

                System.out.print("Enter your choice (1-5): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Add a new student
                        System.out.print("Enter Roll Number: ");
                        int rollNumber = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        String name = scanner.next();
                        System.out.print("Enter the number of subjects: ");
                        int numOfSubjects = scanner.nextInt();
                        ArrayList<Integer> marks = new ArrayList<>();
                        for (int i = 1; i <= numOfSubjects; i++) {
                            System.out.print("Enter marks for subject " + i + ": ");
                            int mark = scanner.nextInt();
                            marks.add(mark);
                        }
                        st.addStudent(rollNumber, name, marks);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        // Display the list of students
                        st.displayStudents();
                        break;
                    case 3:
                        // Update student information
                        System.out.print("Enter Roll Number: ");
                        int updateRollNumber = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        String updateName = scanner.next();
                        st.updateStudent(updateRollNumber, updateName);
                        break;
                    case 4:
                        // Calculate percentage and grade for a student
                        System.out.print("Enter Roll Number: ");
                        int percentageRollNumber = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        String percentageName = scanner.next();
                        st.percentageGrade(percentageRollNumber, percentageName);
                        break;
                    case 5:
                        // Exit the program
                        System.out.println("Exiting the program");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }
    }
}
