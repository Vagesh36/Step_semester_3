package main.java.week8;

import java.util.Scanner;

interface EmployeeBonus {
    double calculateBonus(double salary);
}

class FullTimeEmployee implements EmployeeBonus {
    public double calculateBonus(double salary) {
        return salary * 0.10;
    }
}

class PartTimeEmployee implements EmployeeBonus {
    public double calculateBonus(double salary) {
        return salary * 0.05;
    }
}

class Intern implements EmployeeBonus {
    public double calculateBonus(double salary) {
        return salary * 0.02;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee type (FULLTIME/PARTTIME/INTERN): ");
            String type = sc.next();
            System.out.print("Enter employee name: ");
            String name = sc.next();
            System.out.print("Enter employee salary: ");
            double salary = sc.nextDouble();

            EmployeeBonus employee;

            if (type.equalsIgnoreCase("FULLTIME")) {
                employee = new FullTimeEmployee();
            } else if (type.equalsIgnoreCase("PARTTIME")) {
                employee = new PartTimeEmployee();
            } else {
                employee = new Intern();
            }

            double bonus = employee.calculateBonus(salary);
            System.out.printf("%s: %.2f%n", name, bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}

