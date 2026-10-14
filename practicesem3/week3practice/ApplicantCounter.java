package practicesem3.week3practice;
class Applicant {
    static int totalApplicants = 0;

    Applicant() {
        totalApplicants++;
    }
}

public class ApplicantCounter {
    public static void main(String[] args) {
        new Applicant();
        new Applicant();
        new Applicant();

        System.out.println("Total applicants: "
                + Applicant.totalApplicants);
    }
}