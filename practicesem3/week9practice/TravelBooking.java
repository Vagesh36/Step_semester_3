package practicesem3.week9practice;
import java.util.Scanner;

abstract class Travel {
    static final double FEE = 50;

    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 2;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double fare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel t;

            if (mode.equals("BUS")) {
                t = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                t = new Train(distance);
            } else {
                t = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n", mode, t.total());
        }

        sc.close();
    }
}