package algoMonster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("dhacks", 25, 10_000.00);
        Employee emp2 = new Employee("dhanraj", 35, 121_000.00);
        Employee emp3 = new Employee("shravz", 25, 30_000.00);
        Employee emp4 = new Employee("shravanthi", 33, 25_000.00);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        Collections.sort(employeeList);
        employeeList.forEach(System.out::println);
        employeeList.stream()
                            .sorted(Comparator.comparing(Employee::getSalary))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
    }

    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }
    @Override
    public String toString() {
        return "Employee {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
