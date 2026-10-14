package practicesem3.week7practice;

class Scorecard {
    private boolean[] results;
    private int count = 0;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
    }

    void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;
            count++;
        } else {
            System.out.println("All answers recorded");
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Total score: " + sc.getScore());
    }
}
