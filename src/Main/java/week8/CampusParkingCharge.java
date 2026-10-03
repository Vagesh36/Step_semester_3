package main.java.week8;

import java.util.Scanner;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30 + (hours * 20);
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        double charge = hours * 50;
        if (charge < 100) {
            charge = 100;
        }
        return charge;
    }
}

public class CampusParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vehicle type (bike/car/truck): ");
        String type = sc.nextLine().toLowerCase();

        System.out.println("Enter number of parking hours: ");
        int hours = sc.nextInt();

        Vehicle vehicle;

        switch (type) {
            case "bike":
                vehicle = new Bike();
                break;
            case "car":
                vehicle = new Car();
                break;
            case "truck":
                vehicle = new Truck();
                break;
            default:
                System.out.println("Invalid vehicle type!");
                sc.close();
                return;
        }

        double charge = vehicle.calculateCharge(hours);
        System.out.println("Parking charge for " + type + " is: ₹" + charge);

        sc.close();
    }
}
