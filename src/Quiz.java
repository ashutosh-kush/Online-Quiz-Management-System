import java.util.List;

public class Quiz {
    private final String title;
    private final List<Question> questions;

    public Quiz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public String getTitle() { return title; }
    public List<Question> getQuestions() { return questions; }

    public int calculateScore(int[] answers) {
        int score = 0;
        for (int i = 0; i < questions.size() && i < answers.length; i++) {
            if (questions.get(i).isCorrect(answers[i])) score++;
        }
        return score;
    }
}
