import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Result {
    private final String username;
    private final String quizTitle;
    private final int score;
    private final int total;
    private final String dateTime;

    public Result(String username, String quizTitle, int score, int total) {
        this.username = username;
        this.quizTitle = quizTitle;
        this.score = score;
        this.total = total;
        this.dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public String toFileString() {
        return username + "|" + quizTitle.replace("|", "/") + "|" +
               score + "|" + total + "|" + dateTime;
    }

    @Override
    public String toString() {
        return quizTitle + " - " + score + "/" + total + " (" + dateTime + ")";
    }
}
