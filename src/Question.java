public class Question {
    private final String text;
    private final String[] options;
    private final int correctOption;

    public Question(String text, String[] options, int correctOption) {
        if (options.length != 4 || correctOption < 1 || correctOption > 4) {
            throw new IllegalArgumentException("A question needs 4 options and a valid answer.");
        }
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getText() { return text; }
    public String[] getOptions() { return options; }

    public boolean isCorrect(int answer) {
        return answer == correctOption;
    }

    public String toFileString() {
        return text.replace("|", "/") + "|" +
               String.join("|", options).replace("|", "/") + "|" + correctOption;
    }

    public static Question fromFileString(String line) {
        String[] p = line.split("\\|");
        if (p.length != 6) throw new IllegalArgumentException("Invalid question record.");
        String[] options = {p[1], p[2], p[3], p[4]};
        return new Question(p[0], options, Integer.parseInt(p[5]));
    }
}
