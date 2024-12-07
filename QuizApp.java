import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {

    private static final int TIME_LIMIT = 30;

    public static void main(String[] args) {
        List<Question> questions = createQuestions();
        int score = 0;

        for (Question question : questions) {
            score += displayQuestion(question);
        }

        displayResult(score, questions.size());
    }

    private static List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();

        
        questions.add(new Question("What is the capital of India?",
                new String[]{"Ottawa", "New Delhi", "Paris"}, 1));
        questions.add(new Question("What is the largest planet in our solar system?",
                new String[]{"Jupiter", "Mars", "Earth"}, 0));

        return questions;
    }

    private static int displayQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        System.out.println(question.getText());
        for (int i = 0; i < question.getOptions().length; i++) {
            System.out.println((i + 1) + ". " + question.getOptions()[i]);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                timer.cancel();
            }
        };

        timer.schedule(task, TIME_LIMIT * 1000);

        int answer = scanner.nextInt() - 1;
        timer.cancel();

        if (answer == question.getCorrectAnswer()) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is " + (question.getCorrectAnswer() + 1));
            return 0;
        }
    }

    private static void displayResult(int score, int totalQuestions) {
        System.out.println("You scored " + score + " out of " + totalQuestions);
    }
}

class Question {
    private String text;
    private String[] options;
    private int correctAnswer;

    public Question(String text, String[] options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}