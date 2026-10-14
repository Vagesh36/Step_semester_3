package practicesem3.week8practice;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + amount * 0.02;
    }

    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + amount * 0.01;
    }

    String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount;
    }

    String getType() {
        return "BANKTRANSFER";
    }
}

class PaymentProcessor {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(1000),
            new WalletPayment(500),
            new BankTransferPayment(2000)
        };

        double total = 0;

        for (Payment p : payments) {
            double finalAmount = p.calculateAmount();
            System.out.printf("%s: %.2f%n", p.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

