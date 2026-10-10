package main.java.week9;

import java.util.Scanner;

abstract class Cab {

    protected double km;

    protected static final double MINIMUM_FARE = 100;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRate();

    public double calculateFare() {

        double fare = km * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }
}

interface NightService {
    boolean supportsNightService();
}

class MiniCab extends Cab {

    public MiniCab(double km) {
        super(km);
    }

    public double getRate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {

    public SedanCab(double km) {
        super(km);
    }

    public double getRate() {
        return 14;
    }

    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab implements NightService {

    public SUVCab(double km) {
        super(km);
    }

    public double getRate() {
        return 18;
    }

    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else {
                cab = new SUVCab(km);
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {

                System.out.println(
                    type + ": night service not available"
                );

                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = fare * 1.20;
            }

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}