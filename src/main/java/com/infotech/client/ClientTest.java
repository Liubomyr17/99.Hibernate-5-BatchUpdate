package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {
        try( Session session = HibernateUtil.getSessionFactory().openSession()) {

            createEmployee(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id =(Integer)session.save(getEmployee());
        System.out.println("Employee is created  with Id::"+id);
        session.getTransaction().commit();

    }

    private static Employee getEmployee(){
        Employee employee= new Employee();
        employee.setEmployeeName("Barry Bingel");
        employee.setEmail("barry.cs2017@gmail.com");
        employee.setSalary(50000.00);
        employee.setDoj(new Date());

        Address homeAddress = new Address ();
        homeAddress.setCity ("Chennai");
        homeAddress.setPincode (90123L);
        homeAddress.setState ("IL");
        homeAddress.setStreet ("Park St.");

        Address officeAddress = new Address ();
        officeAddress.setCity ("Puno");
        officeAddress.setPincode (100123L);
        officeAddress.setState ("MH");
        officeAddress.setStreet ("XYZ Street");

        employee.setHomeAddress (homeAddress);
        employee.setOfficeAddress (officeAddress);

        return employee;
    }
}