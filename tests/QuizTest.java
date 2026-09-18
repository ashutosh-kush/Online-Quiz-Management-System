import java.util.*;

public class QuizTest {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("2 + 2 = ?", new String[]{"3","4","5","6"}, 2));
        questions.add(new Question("Java is a?", new String[]{"Language","Database","OS","Browser"}, 1));

        Quiz quiz = new Quiz("Test", questions);
        int score = quiz.calculateScore(new int[]{2, 1});

        if (score != 2) throw new AssertionError("Score calculation failed.");
        System.out.println("QuizTest passed.");
    }
}
