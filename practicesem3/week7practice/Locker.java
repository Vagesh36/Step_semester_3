package practicesem3.week7practice;

public class Locker {
    private int lockerNumber;
    private String code;

    // Constructor
    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    // Method to change the code
    public void changeCode(String oldCode, String newCode) {
        if (this.code.equals(oldCode)) {
            this.code = newCode;
            System.out.println("Code changed successfully!");
        } else {
            System.out.println("Wrong code.");
        }
    }

    // Optional: Display locker info
    public void displayLockerInfo() {
        System.out.println("Locker Number: " + lockerNumber);
        System.out.println("Current Code: " + code);
    }

    public static void main(String[] args) {
        Locker l1 = new Locker(101, "1234");

        // Correct old code
        l1.changeCode("1234", "5678");

        // Wrong old code
        l1.changeCode("0000", "9999");

        // Display locker info
        l1.displayLockerInfo();
    }
}
