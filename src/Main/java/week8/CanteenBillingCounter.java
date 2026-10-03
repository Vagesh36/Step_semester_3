package main.java.week8;

import java.util.Scanner;

interface Customer {
    double calculateAmount(double bill);
}

class Student implements Customer {
    public double calculateAmount(double bill) {
        return bill * 0.90; // 10% discount
    }
}

class Staff implements Customer {
    public double calculateAmount(double bill) {
        return bill * 0.95; // 5% discount
    }
}

class Guest implements Customer {
    public double calculateAmount(double bill) {
        return bill + 10; // ₹10 service charge
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nCustomer " + i + ":");
            System.out.print("Enter customer type (student/staff/guest): ");
            String type = sc.next().toLowerCase();

            System.out.print("Enter bill amount: ");
            double bill = sc.nextDouble();

            Customer c;
            switch (type) {
                case "student":
                    c = new Student();
                    break;
                case "staff":
                    c = new Staff();
                    break;
                case "guest":
                    c = new Guest();
                    break;
                default:
                    System.out.println("Invalid customer type! Skipping...");
                    continue;
            }

            double finalAmount = c.calculateAmount(bill);
            System.out.println("Final amount to be paid: ₹" + finalAmount);
            total += finalAmount;
        }

        System.out.println("\nTotal amount collected: ₹" + total);
        sc.close();
    }
}
