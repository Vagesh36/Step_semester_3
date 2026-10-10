package main.java.week9;

import java.util.Scanner;

abstract class Ticket {

    protected int count;

    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getPrice();

    public double getAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {

    public RegularTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {

    public PremiumTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {

    public ReclinerTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            if (seat.equals("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else {
                ticket = new ReclinerTicket(count);
            }

            double amount = ticket.getAmount();

            System.out.printf("%s: %.2f%n", seat, amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}