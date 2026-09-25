package main.java.week3;

public class EmployeeDefaultValues {

    static class Employee {
        String empName;
        double salary;
        boolean permanent;
    }

    public static void main(String[] args) {

        Employee employee = new Employee();

        System.out.println("Name: " + employee.empName);
        System.out.println("Salary: " + employee.salary);
        System.out.println("Permanent: " + employee.permanent);
    }
}