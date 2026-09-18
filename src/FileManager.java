import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileManager {
    private static final String DATA_DIR = "data";
    private static final String USERS_FILE = DATA_DIR + "/users.txt";
    private static final String QUESTIONS_FILE = DATA_DIR + "/questions.txt";
    private static final String RESULTS_FILE = DATA_DIR + "/results.txt";

    public static void initialize() {
        try {
            Files.createDirectories(Paths.get(DATA_DIR));
            createIfMissing(USERS_FILE);
            createIfMissing(QUESTIONS_FILE);
            createIfMissing(RESULTS_FILE);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize data files.", e);
        }
    }

    private static void createIfMissing(String file) throws IOException {
        Path p = Paths.get(file);
        if (!Files.exists(p)) Files.createFile(p);
    }

    public static List<String> readLines(String file) {
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            System.out.println("Unable to read " + file);
            return new ArrayList<>();
        }
    }

    public static void append(String file, String line) {
        try (BufferedWriter w = Files.newBufferedWriter(
                Paths.get(file), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            w.write(line);
            w.newLine();
        } catch (IOException e) {
            System.out.println("Unable to save data.");
        }
    }

    public static void overwrite(String file, List<String> lines) {
        try {
            Files.write(Paths.get(file), lines);
        } catch (IOException e) {
            System.out.println("Unable to update data.");
        }
    }

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        for (String line : readLines(USERS_FILE)) {
            if (line.isBlank()) continue;
            String[] p = line.split("\\|", -1);
            if (p.length == 3 && p[0].equals("STUDENT"))
                students.add(new Student(p[1], p[2]));
        }
        return students;
    }

    public static List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();
        for (String line : readLines(QUESTIONS_FILE)) {
            if (line.isBlank()) continue;
            try { questions.add(Question.fromFileString(line)); }
            catch (Exception ignored) { }
        }
        return questions;
    }

    public static void saveStudent(Student student) {
        append(USERS_FILE, "STUDENT|" + student.getUsername() + "|password");
    }

    public static void saveStudentWithPassword(String username, String password) {
        append(USERS_FILE, "STUDENT|" + username + "|" + password.replace("|", "/"));
    }

    public static void saveQuestion(Question q) {
        append(QUESTIONS_FILE, q.toFileString());
    }

    public static List<String> loadResultsFor(String username) {
        List<String> results = new ArrayList<>();
        for (String line : readLines(RESULTS_FILE)) {
            if (line.startsWith(username + "|")) results.add(line);
        }
        return results;
    }

    public static void saveResult(Result result) {
        append(RESULTS_FILE, result.toFileString());
    }

    public static List<String> allResultLines() {
        return readLines(RESULTS_FILE);
    }

    public static List<String> allQuestionLines() {
        return readLines(QUESTIONS_FILE);
    }

    public static void removeQuestion(int index) {
        List<String> lines = allQuestionLines();
        if (index >= 0 && index < lines.size()) {
            lines.remove(index);
            overwrite(QUESTIONS_FILE, lines);
        }
    }
}
