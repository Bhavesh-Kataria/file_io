package file_io;

import java.io.*;
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
        return "Employee [Name: " + name + ", ID: " + id + ", Salary: " + salary +"]";
    }
}

public class EmployeePayIO {

    public static void writeEmployeeToFile(ArrayList<Employee> emps) {
        try (PrintWriter writer = new PrintWriter("/Users/topb/Desktop/Core-Java/src/file_io/emp_db.txt")) {
            for (Employee employee : emps) {
                writer.println(employee.toString());
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static int countRecords() throws IOException {
        FileReader f = new FileReader("/Users/topb/Desktop/Core-Java/src/file_io/emp_db.txt");
        BufferedReader br  = new BufferedReader(f);
        String line = br.readLine();
        int count =0;
        while(line!=null){
            count++;
            line = br.readLine();
        }
        return count;
    }

    public static void printEmployeeToConsole(ArrayList<Employee> emps){
        System.out.println("AlL Employees In Our Organization");
        for(Employee e : emps){
            System.out.println(e);
        }
    }

    public static void printEmpFromFile() throws IOException {
        FileReader f = new FileReader("/Users/topb/Desktop/Core-Java/src/file_io/emp_db.txt");
        BufferedReader br  = new BufferedReader(f);
        String line = br.readLine();
        int count =0;
        while(line!=null){
            count++;
            System.out.println(line);
            line = br.readLine();
        }
        System.out.println("Total of "+count+" employees are in company");
    }

    public static void main(String[] args) throws IOException {
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
        writeEmployeeToFile(emps);
        System.out.println("All Employee Records have been written to file");
        printEmpFromFile();
    }
}
