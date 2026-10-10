package main.java.week9;

import java.util.Scanner;

abstract class Student {

    protected String name;

    protected static final double TRANSPORT_FEE = 12000;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();

    public String getName() {
        return name;
    }
}

interface BusUser {
    boolean usesBus();
}

class DayScholar extends Student implements BusUser {

    public DayScholar(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000 + TRANSPORT_FEE;
    }

    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student implements BusUser {

    public Hosteller(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000 + 60000;
    }

    public boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    public ScholarshipStudent(String name) {
        super(name);
    }

    public double calculateFee() {
        return 20000 + TRANSPORT_FEE;
    }

    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n", name, fee);

            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}