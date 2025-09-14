package com.simple.morganstanley;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 25 June 2025 - Accolite
 *
 * Employees present in data base.
 * Employee csv file provided. From the file data u have to identify how many needs to be added, how many removed and how many updated
 */
public class CsvProcessor {

    public static void main(String[] args) {
        // Get all employee grouped by department for highest salary in department
        List<Employee> employeesL = createEmployees();

        System.out.println("All Employees");

        employeesL.stream().forEach(System.out::println);

        // Employee of each department having maximum salary
        Map<String, Optional<Employee>> resultedEmployees = employeesL.stream().collect(Collectors.groupingBy(Employee::department, Collectors.maxBy(Comparator.comparingDouble(Employee::salary))));

        System.out.println("Employee of each department having maximum salary");
        resultedEmployees.entrySet().stream().forEach(System.out::println);
        /*
         * Employees to be added and removed
         *
         * */

        Map<Integer, Employee> newEmployees = getNewEmployees();
        Map<Integer, Employee> employeesFromDB = getEmployeesFromDb();

        Predicate<Integer> employeesToBeRemoved = (e) -> {
            return !newEmployees.containsKey(e);
        };

        Predicate<Integer> empployeesToBeAdded = (e) -> {
            return newEmployees.containsKey(e);
        };

        System.out.println("New Employees to be added");
        newEmployees.entrySet().stream().forEach(System.out::println);

        System.out.println("Employees from Db");
        employeesFromDB.entrySet().forEach(System.out::println);
        Comparator<Employee> employeeComparator = Comparator.comparing(Employee::empId);

        //To be Removed
        Set<Integer> toBeRemoved = employeesFromDB.keySet().stream().filter(employeesToBeRemoved).collect(Collectors.toSet());
        System.out.println("To be Removed Employees");
        toBeRemoved.stream().forEach(e -> System.out.print(" " + e));

        System.out.println();

        // To be inserted
        Set<Integer> toBeAdded = employeesFromDB.keySet().stream().filter(empployeesToBeAdded).collect(Collectors.toSet());
        System.out.println("To be Added Employees");
        toBeRemoved.stream().forEach(e -> System.out.print(" " + e));

        System.out.println();
        //To be updated

        Map<Integer, Employee> toBeUpdated = employeesFromDB.entrySet()
                .stream()
                .filter(e -> {
                    Employee empl = newEmployees.get(e.getKey());
                    return empl != null && !isSame(empl, e.getValue());
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("To be Updated");
        toBeUpdated.entrySet().stream().forEach(employee -> System.out.println("K=" + employee.getKey() + "V=" + employee.getValue()));
    }

    private static boolean isSame(Employee empl, Employee value) {
        return empl.firstName().equalsIgnoreCase(value.firstName())
                && empl.lastName().equalsIgnoreCase(value.lastName())
                && empl.salary() == value.salary()
                && empl.department().equalsIgnoreCase(value.department())
                && empl.mgrId() == value.mgrId();
    }

    private static List<Employee> createEmployees() {
        List<Employee> employeesL = new ArrayList<>();
        Employee emp = Employee.builder().empId(10001)
                .firstName("Shankha")
                .lastName("Karmakar")
                .mgrId(20001)
                .salary(10000.00)
                .department("COMP")
                .build();
        employeesL.add(emp);
        emp = Employee.builder().empId(10301)
                .firstName("Yashwant")
                .lastName("Kumar")
                .mgrId(20001)
                .salary(12000.00)
                .department("COMP")
                .build();
        employeesL.add(emp);
        emp = Employee.builder().empId(10401)
                .firstName("Madhu")
                .lastName("Kumar")
                .mgrId(20001)
                .salary(17000.00)
                .department("TECH")
                .build();
        employeesL.add(emp);
        emp = Employee.builder().empId(10701)
                .firstName("Ajit")
                .lastName("Jaiswal")
                .mgrId(20001)
                .salary(20000.00)
                .department("TEST")
                .build();
        employeesL.add(emp);
        return employeesL;
    }

    private static Map<Integer, Employee> getEmployeesFromDb() {
        Map<Integer, Employee> employeesFromDb = new HashMap<>();
        employeesFromDb.put(10001, Employee.builder().empId(10001)
                .firstName("Shankha")
                .lastName("Karmakar")
                .mgrId(20001)
                .salary(10000.00)
                .department("COMP")
                .build());
        employeesFromDb.put(10301, Employee.builder().empId(10301)
                .firstName("Yashwant")
                .lastName("Kumar")
                .mgrId(20001)
                .salary(12000.00)
                .department("COMP")
                .build());
        employeesFromDb.put(10401, Employee.builder().empId(10401)
                .firstName("Madhu")
                .lastName("Kumar")
                .mgrId(20001)
                .salary(17000.00)
                .department("TECH")
                .build());
        employeesFromDb.put(10701, Employee.builder().empId(10701)
                .firstName("Ajit")
                .lastName("Jaiswal")
                .mgrId(20001)
                .salary(20000.00)
                .department("TEST")
                .build());
        return employeesFromDb;
    }

    private static Map<Integer, Employee> getNewEmployees() {
        Map<Integer, Employee> newEmployees = new HashMap<>();
        newEmployees.put(10001, Employee.builder().empId(10001)
                .firstName("Shankha")
                .lastName("KarmakarUPDATED")
                .mgrId(20001)
                .salary(10000.00)
                .department("COMP")
                .build());
        newEmployees.put(10401, Employee.builder().empId(10401)
                .firstName("Madhu")
                .lastName("Kumar")
                .mgrId(20001)
                .salary(20000.00)
                .department("TECH")
                .build());
        return newEmployees;
    }


}
