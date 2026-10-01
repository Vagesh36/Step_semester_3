package main.java.week6;

public class EmployeeProfileCreation {

    static class Employee {

        String empId;
        String empName;
        double salary;
        boolean isIntern;

        // Constructor for permanent employee
        public Employee(String empId,
                        String empName,
                        double salary) {

            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        // Constructor for intern
        public Employee(String empId,
                        String empName) {

            this(empId, empName, 0);

            this.isIntern = true;
        }

        void printProfile() {

            System.out.println(
                empId + " | " +
                empName + " | Rs " +
                salary + " | Intern: " +
                isIntern
            );
        }
    }

    public static void main(String[] args) {

        Employee permanentEmployee =
            new Employee(
                "E-101",
                "Divya",
                65000
            );

        Employee internEmployee =
            new Employee(
                "E-102",
                "Arjun"
            );

        permanentEmployee.printProfile();
        internEmployee.printProfile();
    }
}
