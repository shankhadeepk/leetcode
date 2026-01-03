package com.companies.questions.accolite;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solutions {

    public static void main(String[] args) {

        Map<Integer,Employee> empsFromDB = getEmployeesFromDB();
        Map<Integer,Employee> newlyEmployees = getNewEmployees();

        //Employees to be removed

        Predicate<Integer> employeesToBeRemoved = (emp) -> {return !newlyEmployees.containsKey(emp);};
        Set<Integer> employeesRemoved = empsFromDB.keySet().stream().filter(employeesToBeRemoved).collect(Collectors.toSet());
        System.out.println("Employees to be removed");
        employeesRemoved.stream().forEach(e -> System.out.println(" "+e));

        //Employees to be added
        Predicate<Integer> employeesNotPresentInDB = (emp) -> {return !empsFromDB.containsKey(emp);};
        Set<Integer> employeesToBeAdded = newlyEmployees.keySet().stream().filter(employeesNotPresentInDB).collect(Collectors.toSet());
        System.out.println("Employees to be added");
        employeesToBeAdded.stream().forEach(e-> System.out.println(" "+e));

        //Employees to be updated

        Map<Integer, Employee> employeeUpdated = newlyEmployees.entrySet().stream()
                .filter((emp) -> {
                    Employee employee = empsFromDB.get(emp.getKey());
                    return employee != null && !isSame(employee, emp.getValue());
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Employees to be updated");
        employeeUpdated.entrySet().stream().forEach(emp -> System.out.println(" "+emp.getKey()+" "+emp.getValue()+" "));
    }

    private static boolean isSame(Employee emp1, Employee emp2) {
        return emp1.firstName().equalsIgnoreCase(emp2.firstName())
                && emp1.lastName().equalsIgnoreCase(emp2.lastName())
                && emp1.department().equalsIgnoreCase(emp2.department())
                && emp1.salary() == emp2.salary()
                && emp1.mgrId() == emp2.mgrId();

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
                .firstName("MadhuUpdated")
                .lastName("Kumar")
                .mgrId(20001)
                .salary(20000.00)
                .department("TECH")
                .build());
        newEmployees.put(10901, Employee.builder().empId(10901)
                .firstName("Mukundan")
                .lastName("Kishore")
                .mgrId(20002)
                .salary(25000.00)
                .department("TECH")
                .build());
        return newEmployees;
    }

    private static Map<Integer, Employee> getEmployeesFromDB() {
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



}
