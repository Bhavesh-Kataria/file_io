package file_io;

import java.util.ArrayList;
import java.util.Scanner;

class Employee{
    int id;
    String name;
    double salary;

    Employee(int id , String name , double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{ID: "+id+" ,NAME: "+name+" ,SALARY: "+salary+"}";
    }
}

public class EmployeePayIO {

    public static void printEmployeeToConsole(ArrayList<Employee> emps){
        System.out.println("AlL Employees In Our Organization");
        for(Employee e : emps){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        int id = 0;
        String name = null;
        double salary = 0;
        boolean flag = true;
        String choice = null;
        Employee e;
        ArrayList<Employee> emps = new ArrayList<>();
        System.out.println("WELCOME TO EMPLOYEE PAYROLL IO SYSTEM");
        Scanner sc = new Scanner(System.in);
        while(flag){
            System.out.println("Enter Employee ID");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Employee Name");
            name = sc.nextLine();
            System.out.println("Enter Employee Salary");
            salary = sc.nextDouble();
            e = new Employee(id,name,salary);
            emps.add(e);
            System.out.println("Want to add another employee");
            System.out.println("yes or no");
            sc.nextLine();
            choice = sc.nextLine();
            if(choice.equals("no")){
                flag = false;
            }
        }
        printEmployeeToConsole(emps);
    }
}
