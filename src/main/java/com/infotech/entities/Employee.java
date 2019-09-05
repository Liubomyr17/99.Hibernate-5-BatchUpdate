package com.infotech.entities;

import com.infotech.model.Address;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee_table")
@DynamicUpdate
public class Employee {

    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name="employee_name",length=200,nullable=false)
    private String employeeName;

    @Column(name="email")
    private String email;

    @Embedded
    @AttributeOverrides (value = {
            @AttributeOverride (column = @Column(name = "home_street_name", length = 50), name = "street"),
            @AttributeOverride (column = @Column(name = "home_city_name"), name = "city"),
            @AttributeOverride (column = @Column(name = "home_state_name"), name = "state"),
            @AttributeOverride (column = @Column(name = "home_pin_code"), name = "pincode")
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides (value = {
            @AttributeOverride (column = @Column(name = "office_street_name", length = 60), name = "street"),
            @AttributeOverride (column = @Column(name = "office_city_name"), name = "city"),
            @AttributeOverride (column = @Column(name = "office_state_name"), name = "state"),
            @AttributeOverride (column = @Column(name = "office_pin_code"), name = "pincode")
    })
    private Address officeAddress;

    @Column(name="date_of_joining")
    private Date doj;

    @Column(name="salary")
    private Double salary;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", homeAddress=" + homeAddress +
                ", officeAddress=" + officeAddress +
                ", doj=" + doj +
                ", salary=" + salary +
                '}';
    }
}