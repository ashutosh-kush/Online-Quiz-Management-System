import java.util.*;

public class QuizManager {
    private final Scanner scanner;
    private final List<Question> questions;

    public QuizManager(Scanner scanner) {
        this.scanner = scanner;
        this.questions = FileManager.loadQuestions();
    }

    public void addQuestion() {
        System.out.print("Question: ");
        String text = scanner.nextLine().trim();
        if (text.isEmpty()) {
            System.out.println("Question cannot be empty.");
            return;
        }

        String[] options = new String[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Option " + (i + 1) + ": ");
            options[i] = scanner.nextLine().trim();
        }

        int correct = readInt("Correct option (1-4): ", 1, 4);
        Question q = new Question(text, options, correct);
        questions.add(q);
        FileManager.saveQuestion(q);
        System.out.println("Question added.");
    }

    public void viewQuestions() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + questions.get(i).getText());
            String[] op = questions.get(i).getOptions();
            for (int j = 0; j < op.length; j++)
                System.out.println("   " + (j + 1) + ") " + op[j]);
        }
    }

    public void removeQuestion() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }
        viewQuestions();
        int n = readInt("Question number to remove: ", 1, questions.size());
        questions.remove(n - 1);
        FileManager.removeQuestion(n - 1);
        System.out.println("Question removed.");
    }

    public Quiz getQuiz() {
        return new Quiz("General Knowledge Quiz", new ArrayList<>(questions));
    }

    private int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int n = Integer.parseInt(scanner.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) {}
            System.out.println("Enter a number from " + min + " to " + max + ".");
        }
    }
}
