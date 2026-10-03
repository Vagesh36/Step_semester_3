package main.java.week8;

import java.time.LocalDate;
import java.util.Scanner;

interface SubscriptionPlan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class BasicPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusMonths(1); // 1-month validity
    }
}

class StandardPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusMonths(3); // 3-month validity
    }
}

class PremiumPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusMonths(6); // 6-month validity
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nCustomer " + (i + 1) + ":");
            System.out.print("Enter plan type (BASIC/STANDARD/PREMIUM): ");
            String type = sc.next().toUpperCase();

            System.out.print