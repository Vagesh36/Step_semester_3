package main.java.week8;

import java.util.Scanner;

interface Room {
    double calculateBill(int units);
}

class SingleRoom implements Room {
    public double calculateBill(int units) {
        return units * 8.0; // ₹8 per unit
    }
}

class SharedRoom implements Room {
    private int occupants;

    public SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    public double calculateBill(int units) {
        return (units * 6.0) / occupants; // ₹6 per unit divided among occupants
    }
}

class ACRoom implements Room {
    public double calculateBill(int units) {
        return (units * 10.0) + 200.0; // ₹10 per unit + ₹200 fixed charge
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nRoom " + i + ":");
            System.out.print("Enter room type (single/shared/ac): ");
            String type = sc.next().toLowerCase();

            System.out.print("Enter units consumed: ");
            int units = sc.nextInt();

            Room room;
            switch (type) {
                case "single":
                    room = new SingleRoom();
                    break;
                case "shared":
                    System.out.print("Enter number of occupants: ");
                    int occupants = sc.nextInt();
                    room = new SharedRoom(occupants);
                    break;
                case "ac":
                    room = new ACRoom();
                    break;
                default:
                    System.out.println("Invalid room type! Skipping...");
                    continue;
            }

            double bill = room.calculateBill(units);
            System.out.println("Electricity bill for this room: ₹" + bill);
            total += bill;
        }

        System.out.println("\nTotal electricity bill collected: ₹" + total);
        sc.close();
    }
}
