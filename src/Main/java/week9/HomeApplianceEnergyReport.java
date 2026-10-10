package main.java.week9;

import java.util.Scanner;

abstract class Appliance {

    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPower();

    public double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    public double calculateCost() {
        return calculateUnits() * 8;
    }
}

interface SaverMode {
    double getSaverUnits();
}

class Fridge extends Appliance {

    public Fridge(double hours) {
        super(hours);
    }

    public double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {

    public AC(double hours) {
        super(hours);
    }

    public double getPower() {
        return 1500;
    }

    public double getSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

class TV extends Appliance {

    public TV(double hours) {
        super(hours);
    }

    public double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {

    public Washer(double hours) {
        super(hours);
    }

    public double getPower() {
        return 500;
    }

    public double getSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested = true;
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AC(hours);
            } else if (type.equals("TV")) {
                appliance = new TV(hours);
            } else {
                appliance = new Washer(hours);
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {

                System.out.println(
                    type + ": saver mode not supported"
                );

                continue;
            }

            double units;

            if (saverRequested) {
                SaverMode saver = (SaverMode) appliance;
                units = saver.getSaverUnits();
            } else {
                units = appliance.calculateUnits();
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}