package com.izdebski.client;

import com.izdebski.entities.Employee;
import com.izdebski.service.EmployeeService;
import com.izdebski.service.impl.EmployeeServiceImpl;
import com.izdebski.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
//            createEmployee(employeeService);
            getEmployeeById(employeeService);
//            updateEmployeeById(employeeService);
            //deleteEmployeeById(employeeService);
        }

    private static void deleteEmployeeById(EmployeeService employeeService) {
        employeeService.deleteEmployeeById(1);
    }

    private static void updateEmployeeById(EmployeeService employeeService) {
        employeeService.updateEmployeeById(2, 70000.00);
    }

    private static void getEmployeeById(EmployeeService employeeService) {
        Employee employee = employeeService.getEmployeeById(2);
        System.out.println(employee);
    }

    private static void createEmployee(EmployeeService employeeService){
        employeeService.createEmployee(getEmployee());
    }

    private static Employee getEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeName("Martin Bingo");
        employee.setEmail("martin.bg2039@gmail.com");
        employee.setSalary(50000.00);
        employee.setDoj(new Date());
        return employee;
    }
}