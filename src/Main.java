import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin123";

    public static void main(String[] args) {
        FileManager.initialize();
        seedQuestions();

        System.out.println("================================");
        System.out.println("     ONLINE QUIZ MANAGEMENT     ");
        System.out.println("================================");

        while (true) {
            System.out.println("\n1. Student Login");
            System.out.println("2. Student Registration");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            int choice = readInt("Choose: ", 1, 4);

            switch (choice) {
                case 1 -> studentLogin();
                case 2 -> registerStudent();
                case 3 -> adminLogin();
                case 4 -> {
                    System.out.println("Thank you for using the system.");
                    return;
                }
            }
        }
    }

    private static void registerStudent() {
        System.out.print("Choose username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Choose password: ");
        String password = scanner.nextLine().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        for (Student s : FileManager.loadStudents()) {
            if (s.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        FileManager.saveStudentWithPassword(username, password);
        System.out.println("Registration successful.");
    }

    private static void studentLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        for (Student s : FileManager.loadStudents()) {
            if (s.getUsername().equals(username) && s.checkPassword(password)) {
                studentMenu(s);
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    private static void adminLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {
            adminMenu();
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    private static void studentMenu(Student student) {
        QuizManager manager = new QuizManager(scanner);
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Attempt Quiz");
            System.out.println("2. View My Results");
            System.out.println("3. Logout");
            int choice = readInt("Choose: ", 1, 3);

            if (choice == 1) attemptQuiz(student, manager.getQuiz());
            else if (choice == 2) viewResults(student);
            else return;
        }
    }

    private static void attemptQuiz(Student student, Quiz quiz) {
        List<Question> qs = quiz.getQuestions();
        if (qs.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        int[] answers = new int[qs.size()];
        System.out.println("\n--- " + quiz.getTitle() + " ---");

        for (int i = 0; i < qs.size(); i++) {
            Question q = qs.get(i);
            System.out.println("\nQ" + (i + 1) + ". " + q.getText());
            String[] op = q.getOptions();
            for (int j = 0; j < 4; j++)
                System.out.println((j + 1) + ") " + op[j]);
            answers[i] = readInt("Your answer: ", 1, 4);
        }

        int score = quiz.calculateScore(answers);
        Result result = new Result(student.getUsername(), quiz.getTitle(), score, qs.size());
        FileManager.saveResult(result);

        double percent = score * 100.0 / qs.size();
        System.out.printf("Quiz completed. Score: %d/%d (%.2f%%)%n",
                score, qs.size(), percent);
    }

    private static void viewResults(Student student) {
        List<String> results = FileManager.loadResultsFor(student.getUsername());
        if (results.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        System.out.println("\n--- My Results ---");
        for (String line : results) {
            String[] p = line.split("\\|");
            if (p.length >= 5)
                System.out.println(p[1] + " - " + p[2] + "/" + p[3] + " (" + p[4] + ")");
        }
    }

    private static void adminMenu() {
        QuizManager manager = new QuizManager(scanner);
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Remove Question");
            System.out.println("4. View All Results");
            System.out.println("5. Logout");
            int choice = readInt("Choose: ", 1, 5);

            if (choice == 1) manager.addQuestion();
            else if (choice == 2) manager.viewQuestions();
            else if (choice == 3) manager.removeQuestion();
            else if (choice == 4) viewAllResults();
            else return;
        }
    }

    private static void viewAllResults() {
        List<String> lines = FileManager.allResultLines();
        if (lines.isEmpty()) {
            System.out.println("No results available.");
            return;
        }
        System.out.println("\n--- All Results ---");
        for (String line : lines) {
            String[] p = line.split("\\|");
            if (p.length >= 5)
                System.out.println(p[0] + " | " + p[1] + " | " + p[2] + "/" + p[3] + " | " + p[4]);
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int n = Integer.parseInt(scanner.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) {}
            System.out.println("Enter a number from " + min + " to " + max + ".");
        }
    }

    private static void seedQuestions() {
        if (!FileManager.loadQuestions().isEmpty()) return;
        FileManager.saveQuestion(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"this", "extends", "implements", "super"}, 2));
        FileManager.saveQuestion(new Question(
                "Which collection allows duplicate elements?",
                new String[]{"Set", "Map", "List", "Queue"}, 3));
        FileManager.saveQuestion(new Question(
                "Which method is the entry point of a Java application?",
                new String[]{"start()", "run()", "main()", "init()"}, 3));
        FileManager.saveQuestion(new Question(
                "Which keyword is used to handle an exception?",
                new String[]{"catch", "throwable", "error", "final"}, 1));
    }
}
