package practicesem3.week8practice;

abstract class Question {
    String type;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String type, String correctAnswer,
             String studentAnswer, double points) {
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String correct, String student, double points) {
        super("MCQ", correct, student, points);
    }

    double calculateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }
}

class TrueFalse extends Question {
    TrueFalse(String correct, String student, double points) {
        super("TF", correct, student, points);
    }

    double calculateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String correct, String student, double points) {
        super("ESSAY", correct, student, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String word : keywords) {
            if (studentAnswer.toLowerCase().contains(word.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Question[] questions = {
            new MCQ("Paris", "Paris", 10),
            new TrueFalse("False", "True", 5),
            new Essay("Inheritance, Polymorphism, Encapsulation",
                      "Polymorphism is one.", 20),
            new Essay("Abstraction, Composition",
                      "I talked about abstraction.", 15)
        };

        double total = 0;

        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
